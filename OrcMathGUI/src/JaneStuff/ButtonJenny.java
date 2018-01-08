package JaneStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJenny extends Button implements ButtonInterfaceJane {
	
	private Color color;
	private boolean on;

	public ButtonJenny(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h,"",null);
	}

	public void setColor(Color color) {
		this.color = color;
		update();
	}

	public void highlight() {
		if(on) {
		this.color = color.brighter();
		update();}
	}

	public void dim() {
		if(on) {
		this.color = color.darker();
		update();
		}
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		
	}
}
