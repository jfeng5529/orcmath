package JaneStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJane extends Clickable {

	void setColor(Color color);
	
	void setAction(Action a);

	void highlight();

	void dim();

	void setOn(boolean b);

	String getIndex();




}
