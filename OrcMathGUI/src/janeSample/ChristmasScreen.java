package janeSample;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasScreen extends FullFunctionScreen {
	private TextArea label;
	private Button nextButton;
	AnimatedComponent tree;
	private Graphic back;
	private Graphic logo;
	public ChristmasScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		back = new Graphic(0, 0,800,800, "resources/back.jpg");
		viewObjects.add(back);
		logo = new Graphic(490,0, 300,300,"resources/logo.png");
		viewObjects.add(logo);
//		tree= new AnimatedComponent(280, 245, 180, 220);
//		tree.addSequence("resources/tree.png", 160, 0, 0, 101, 140, 15);
//		Thread run = new Thread(tree);
//		run.start();
//		viewObjects.add(tree);
		label = new TextArea(450, 450, 300, 150, "SOME PEOPLE ARE WORTH MELTING FOR!");
		viewObjects.add(label);
		nextButton = new Button(490, 500, 70, 70, "Open Me!", new Action() {
			
			@Override
			public void act() {
				ChristmasCard.sample.setScreen(ChristmasCard.z);
				
			}
		});
		viewObjects.add(nextButton);
	}

}
