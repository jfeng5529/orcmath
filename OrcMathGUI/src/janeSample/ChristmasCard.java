package janeSample;

import guiTeacher.GUIApplication;
import guiTeacher.components.AnimatedComponent;

public class ChristmasCard extends GUIApplication {
	
	public static ChristmasCard sample;
	public static ChristmasScreen s;
	public static ChristmasScreen2 z;
	
	public ChristmasCard(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		z = new ChristmasScreen2(getWidth(), getHeight());
		s = new ChristmasScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		sample =new ChristmasCard(800, 600);
		Thread go = new Thread(sample);
		go.start();

	}

}
