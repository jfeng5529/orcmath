/**
 * 
 */
package janeSample;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

/**
 * @author BT_1N3_02
 *
 */
public class book extends Component {

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public book() {
		super(40, 40, 100, 100);
		update();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiTeacher.components.Component#update(java.awt.Graphics2D)
	 */
	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, getWidth(), getHeight());

	}

}
