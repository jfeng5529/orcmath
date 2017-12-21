package janeSample;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasScreen extends FullFunctionScreen {
	private TextArea label;
	private Button nextButton;
	AnimatedComponent tree;
	public ChristmasScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		tree= new AnimatedComponent(250, 265, 180, 220);
		tree.addSequence("resources/tree.png", 160, 0, 0, 101, 140, 15);
		Thread run = new Thread(tree);
		run.start();
		viewObjects.add(tree);
		label = new TextArea(150, 200, 200, 150, "Santa Come To Me Plz!!!!");
		viewObjects.add(label);
		nextButton = new Button(450, 520, 70, 70, "Open Me!", new Action() {
			
			@Override
			public void act() {
				ChristmasCard.sample.setScreen(ChristmasCard.z);
				
			}
		});
		viewObjects.add(nextButton);

	}

}
