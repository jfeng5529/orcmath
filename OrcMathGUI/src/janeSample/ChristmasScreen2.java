package janeSample;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasScreen2 extends FullFunctionScreen {
	private TextArea text;
	private AnimatedComponent deer;
	public ChristmasScreen2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text= new TextArea(20, 20, 110, 110, "HI");
		viewObjects.add(text);
		deer= new AnimatedComponent(250, 265, 380, 340);
		deer.addSequence("resources/deer2.png", 160, 0, 0, 370, 340, 4);
		Thread run = new Thread(deer);
		run.start();
		viewObjects.add(deer);

	}

}
