package JaneStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJenny extends Component implements ProgressInterfaceJane{

	private int round;
	private int sequenceSize;
	private boolean progress;
	
	public ProgressJenny(int x, int y, int w, int h) {
		super(x, y, w, h);
		progress = true;
		update();
	}

	@Override
	public void gameOver() {
		progress = false;
		update();
	}

	@Override
	public void setRound(int roundNumber) {
		round = roundNumber;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		sequenceSize = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		if(progress) {
			g.setColor(Color.black);
			g.drawString("Round: "+round, 600, 50);
			g.drawString("Sequence: "+sequenceSize,600,100);
		}else {
			g.setColor(Color.black);
			g.drawString("Game over", 600, 50);
			g.drawString("Round: "+round, 600, 100);
			g.drawString("Sequence: "+sequenceSize,600,150);
		}

	}

}
