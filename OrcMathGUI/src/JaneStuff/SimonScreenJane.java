package JaneStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJane extends ClickableScreen implements Runnable{

	private TextArea label;
	private TextArea test;
	private ButtonInterfaceJane[] button;
	private ProgressInterfaceJane progress;
	private ArrayList<String> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	private Button startButton;
	private String[] buttonIndex;
	
	public SimonScreenJane(int width, int height) {
		super(width, height);
		Thread ex = new Thread(this);
		ex.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		sequenceIndex=0;
		acceptingInput=true;
		label = new TextArea(130,250,200,40,"Let's play Simon Game!");
		test = new TextArea(200,100,210,40,"Simon's Sequence");
		viewObjects.add(test);
		viewObjects.add(label);
		addButtons();
		for(ButtonInterfaceJane j: button){ 
		    viewObjects.add(j); 
		}
		progress = getProgress();
		
		sequence = new ArrayList<String>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
	}
	private void clearSequence() {
		sequence = new ArrayList<String>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = -1;
	}
	private String randomMove() {
		 int bNum = (int)(Math.random()*button.length);
		    while(bNum == lastSelectedButton){
		        bNum = (int)(Math.random()*button.length);
		    }
		    return buttonIndex[bNum];}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
//	private ButtonInterfaceJane getMove(int bIndex) {
//		return button[bIndex];
//	}

	/**
		Placeholder until partner finishes implementation of ProgressInterface
//	 */
	private ProgressInterfaceJane getProgress() {
		 return new ProgressJenny(100, 300, 50, 50); 
}

	private void addButtons() {
		int numOfButtons = 4;
		button = new ButtonInterfaceJane[numOfButtons];
		Color[] buttonColors = {Color.green, Color.cyan, Color.magenta, Color.orange};
		String[] buttontemp = {"green","cyan","magenta","orange"};
		buttonIndex=buttontemp;
		for(int i=0; i<numOfButtons; i++) {
			ButtonInterfaceJane b = getAButton(buttonIndex[i]);
			button[i] = b;
			b.setColor(buttonColors[i]);
			b.setOn(true);
			b.setX((int) (80+50*Math.cos(i*(Math.PI/2))));
			b.setY((int) (80+50*Math.sin(i*(Math.PI/2))));//make a circle
			b.setAction(new Action(){

				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(500);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}

							}

						});b.dim();
						blink.start();
						if( sequence.get(sequenceIndex)==b.getIndex()) {
							sequenceIndex++;
						}
						else
							gameOver();
					}
					if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenJane.this); 
					    nextRound.start(); 
					}
				}


			});
		}
	}
	private void gameOver() {
		changeText("GAVE OVER!!");
		acceptingInput=false;
		for(ButtonInterfaceJane b: button) {
			b.setOn(false);
		}
	}

	/**
	Placeholder until partner finishes implementation of ButtonInterface
	 * @param  
	*/
	private ButtonInterfaceJane getAButton(String index) {
		return new ButtonJenny(80, 80, 50, 50, "", null, index);
	}
	
	private void changeText(String s) {
		label.setText(s);
		Thread blink = new Thread(new Runnable(){

			public void run(){
				try {
					Thread.sleep(1500);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}

		});
		blink.start();
	}
	@Override
	public void run() {
		label.setText("");
	    nextRound();
		
	}

	private void nextRound() {
		acceptingInput=false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		label.setText("Simon's turn");
		playSequence();
		label.setText("Your Turn");
		acceptingInput=true;
		sequenceIndex=0;
	}
	
	private void playSequence() {
		for(int i=0; i<sequence.size(); i++) {
				test.setText(sequence.get(i));
				int sleepTime = Math.abs(1500-6*roundNumber);
				try        
				{
				    Thread.sleep(sleepTime);
				} 
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}
			}
		}
	}

