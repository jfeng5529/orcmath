package JaneStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJenny extends Button implements ButtonInterfaceJane{
	
	private Color orginal;
	private boolean on;
	
	public ButtonJenny(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
	}
	
	public void setOn(boolean o) {
		on = o;
	}

	@Override
	public void setColor(Color color) {
		this.setForeground(color);
		orginal = color;
		update();
	}

	@Override
	public void dim() {
		this.setForeground(orginal.darker());
		update();
	}

	@Override
	public void highlight() {
		this.setColor(orginal.brighter());
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);
			g.setColor(getForeground());
			g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);

}

	@Override
	public ButtonInterfaceJane getButton() {
	return this;
	}
}