package JaneStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJane extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterfaceJane[] button;
	private ProgressInterfaceJane progress;
	private ArrayList<ButtonInterfaceJane> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	private Button startButton;
	
	public SimonScreenJane(int width, int height) {
		super(width, height);
		Thread ex = new Thread(this);
		ex.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		acceptingInput=false;
		addButtons();
		for(ButtonInterfaceJane j: button){ 
		    viewObjects.add(j); 
		}
		progress = getProgress();
		startButton = new Button(40, 340, 100, 30, "Start", new Action() {

			@Override
			public void act() {
				clearSequence();
				label.setText("Let's play Simon Game!");
				nextRound();
			}
		});
		viewObjects.add(startButton);
		label = new TextLabel(130,230,200,40,"Let's play Simon Game!");
		viewObjects.add(label);
		sequence = new ArrayList<ButtonInterfaceJane>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
	}
	private void clearSequence() {
		sequence = new ArrayList<ButtonInterfaceJane>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = -1;
	}
	private ButtonInterfaceJane randomMove() {
		 int bNum = (int)(Math.random()*button.length);
		    while(bNum == lastSelectedButton){
		        bNum = (int)(Math.random()*button.length);
		    }
		    return getMove(bNum);
	}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private ButtonInterfaceJane getMove(int bIndex) {
		return button[bIndex];
	}

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
		for(int i=0; i<numOfButtons; i++) {
			final ButtonInterfaceJane b = getAButton();
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
									Thread.sleep(1000);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
									b.dim();
							}

						});
						blink.start();
						if( b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}
						else
							progress.gameOver();
							gameOver();
					}
					if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenJane.this); 
					    nextRound.start(); 
					}
				}


			});button[i] = b;
		}
	}
	private void gameOver() {
		changeText("GAVE OVER!!");
		for(ButtonInterfaceJane b: button) {
			b.setOn(false);
		}
	}

	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceJane getAButton() {
		return new ButtonJenny(80, 80, 50, 50, "", null);
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
		changeText("Simon's turn");
		changeText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput=true;
		sequenceIndex=0;
	}
	
	private void playSequence() {
		for(int i=0; i<sequence.size(); i++) {
				sequence.get(i);
				sequence.get(i).highlight();
				int sleepTime = Math.abs(1500-6*roundNumber);
				Thread blink = new Thread(new Runnable(){

					public void run(){
						try {
							Thread.sleep(sleepTime);
							} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
					}

				});
				sequence.get(i).dim();
				blink.start();
				sequence.get(i).dim();
			}
		}
	}

