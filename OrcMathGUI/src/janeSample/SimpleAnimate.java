/**
 * 
 */
package janeSample;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

/**
 * @author BT_1N3_02
 *
 */
public class SimpleAnimate extends AnimatedComponent {

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public SimpleAnimate() {
		super(40, 40, 260, 260);
		addSequence("resources/myPic.png", 160, 0, 0, 251, 251, 6);
		Thread animation= new Thread(this);
		animation.start();
		update();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiTeacher.components.Component#update(java.awt.Graphics2D)
	 */
	@Override
	public void update(Graphics2D g) {
		super.update(g);

	}

}
