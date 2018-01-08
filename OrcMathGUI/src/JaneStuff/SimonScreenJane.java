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
	private ArrayList<MoveInterfaceJane> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenJane(int width, int height) {
		super(width, height);
		Thread ex = new Thread(this);
		ex.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJane j: button){ 
		    viewObjects.add(j); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon Game!");
		sequence = new ArrayList<MoveInterfaceJane>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceJane randomMove() {
		 int bNum = (int)(Math.random()*button.length);
		    while(bNum == lastSelectedButton){
		        bNum = (int)(Math.random()*button.length);
		    }
		    return getMove(bNum);
	}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceJane getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
		Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceJane getProgress() {
		 return null; 
	}

	private void addButtons() {
		int numOfButtons = 4;
		button = new ButtonInterfaceJane[numOfButtons];
		Color[] buttonColors = {Color.green, Color.cyan, Color.magenta, Color.orange};
		for(int i=0; i<numOfButtons; i++) {
			final ButtonInterfaceJane b = getAButton();
			button[i] = b;
			b.setColor(buttonColors[i]);
			b.setX((int) Math.cos(i*(Math.PI/2)));
			b.setY((int) Math.sin(i*(Math.PI/2)));//make a circle
			b.setAction(new Action(){

				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
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
					}
					if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenJane.this); 
					    nextRound.start(); 
					}
				}

			});
		}
	}

	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceJane getAButton() {
		// TODO Auto-generated method stub
		return null;
	}
	private void changeText(String s) {
		Thread blink = new Thread(new Runnable(){

			public void run(){
				label.setText(s);
				try {
					Thread.sleep(1000);
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
		ButtonInterfaceJane b=null;
		for(int i=0; i<sequence.size(); i++) {
			if(b!= null) {
				b.dim();
				b=sequence.get(i).getButton();
				b.highlight();
				int sleepTime = Math.abs((800-6*roundNumber));
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
				blink.start();
			}
		}
		b.dim();
	}
}
