package JaneStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import javafx.scene.paint.Color;

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
		int numOfButtons = 5;
		button = new ButtonInterfaceJane[numOfButtons];
		Color[] buttonColors= new Color[];
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
