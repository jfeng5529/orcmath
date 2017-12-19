package janeSample;

import java.util.List;
import java.util.Objects;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField descriptionField;
	private TextField typeField;
	private TextField flavorField;

	
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40, 40, 200, 30, "Text goes here", "Food Name");
		viewObjects.add(descriptionField);
		typeField = new TextField(40, 110, 200, 30, "Text goes here", "Food Type");
		viewObjects.add(typeField);
		flavorField = new TextField(40, 180, 200, 30, "Text goes here", "Food Flavor");
		viewObjects.add(flavorField);
		}

}
