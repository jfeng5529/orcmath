package JaneStuff;

import guiTeacher.GUIApplication;

public class TestMain extends GUIApplication {

	public TestMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		TestScreen s= new TestScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		TestMain test = new TestMain(700,550);
		Thread runner = new Thread(test);
		runner.start();


	}

}
