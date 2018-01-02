package HolidayCard;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasScreen2 extends FullFunctionScreen {
	private TextArea text;
	private AnimatedComponent deer;
	private Button nextButton;
	private Visible back;
	private Graphic logo;
	public ChristmasScreen2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		back = new Graphic(0, 0,800,800, "resources/back2.jpg");
		viewObjects.add(back);
		logo = new Graphic(10,0, 300,300,"resources/logo2.png");
		viewObjects.add(logo);
		text= new TextArea(20, 20, 110, 110, "HI");
		viewObjects.add(text);
		deer= new AnimatedComponent(400, 300, 280, 240);
		ArrayList<Integer> times = new ArrayList<Integer>();
		times.add(2000);
		times.add(100);
		times.add(100);
		times.add(100);
		deer.addSequence("resources/deer.png", times, 0, 1100, 373, 340, 4);
		Thread run = new Thread(deer);
		run.start();
		viewObjects.add(deer);
		nextButton = new Button(490, 520, 70, 70, "Close Me!", new Action() {
			
			@Override
			public void act() {
				ChristmasCard.sample.setScreen(ChristmasCard.s);
				
			}
		});
		nextButton.setForeground(Color.white);

		nextButton.update();
		viewObjects.add(nextButton);

	}

}
