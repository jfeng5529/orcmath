package janeSample;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {

	private String s1;
	private String s2;
	private Color color;

	public CustomButton(int x, int y) {
		super(x, y, 80, 50, "", null);
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.black);
		g.drawString(s1, 40, 40);
		g.drawString(s2, 40, 80);
		g.setColor(color);
		g.drawRect(20, 20, 10, 10);
		g.fillRect(20, 20, 10, 10);
		
	}
	
	public void updateString1(String string) {
		s1=string;
	}

	public void updateString2(String string) {
		s2=string;
	}

	public void setIconColor(Color color) {
		this.color=color;
	}
}
