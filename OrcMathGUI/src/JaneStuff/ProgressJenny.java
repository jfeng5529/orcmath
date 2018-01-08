package JaneStuff;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJenny extends Component implements ProgressInterfaceJane {
	
	private int size;
	private int round;

	public ProgressJenny(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void gameOver() {
		
	}

	public void setRound(int roundNumber) {
		round = roundNumber;
	}

	public void setSequenceSize(int size) {
		this.size = size;
	}

	public void update(Graphics2D g) {

	}
}
