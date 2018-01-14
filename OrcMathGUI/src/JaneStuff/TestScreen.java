package JaneStuff;

import java.awt.Color;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class TestScreen extends ClickableScreen {

	private TextLabel text;
	private TextLabel timerPrint;
	private Button button;
	private Timer timer;
	private int startSec;
	private int gameSec;
	private int score;
	
	public TestScreen(int width, int height) {
		super(width, height);
		startSec=4;
		gameSec=6;
		score=0;
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextLabel(230, 100, 200, 150, "Score: 0");
		viewObjects.add(text);
		timerPrint = new TextLabel(230, 120, 100, 100, "Time: 0");
		viewObjects.add(timerPrint);
		
		timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				startSec--;
				if(startSec==0) {
					text.setText("Go!");
					button.setText("Click Me");
				}
				else if(startSec>0)
					text.setText(""+startSec);
					
				if(startSec<=0) {
					gameSec--;
					timerPrint.setText("Timer: "+gameSec);
					if(gameSec==0) {
						button.setText("Done");
						button.setEnabled(false);
						timer.cancel();
					}
				}
				
			}
			
		};
		button = new Button(220, 200, 100, 100, "Ready" , new Action() {
			
			@Override
			public void act() {
				if(startSec<=0) {
					score++;
					text.setText("Score: "+score);
				}
				else
				StartTimer();
				
			}

			private void StartTimer() {
				timer.schedule(task,0,1000);
				
			}
		});
		button.setForeground(Color.cyan);
		
		viewObjects.add(button);

	}

}
