package janeSample;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasScreen2 extends FullFunctionScreen {
	private TextArea text;
	public ChristmasScreen2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text= new TextArea(20, 20, 110, 110, "HI");
		viewObjects.add(text);

	}

}
