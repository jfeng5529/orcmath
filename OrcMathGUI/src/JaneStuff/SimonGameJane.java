package JaneStuff;

import guiPlayer.CustomGUI;
import guiPlayer.CustomScreen;
import guiTeacher.GUIApplication;

public class SimonGameJane extends GUIApplication {

	public SimonGameJane(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreen screen = new SimonScreen(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		SimonGameJane s = new SimonGameJane(800, 550);
		Thread runner = new Thread(s);
		runner.start();

	}

}
