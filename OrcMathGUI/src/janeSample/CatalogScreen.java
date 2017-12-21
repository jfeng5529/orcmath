package janeSample;

import java.io.File;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	private TextField descriptionField;
	private TextField typeField;
	private TextField flavorField;
	private TextArea text;
	private TextArea list;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private CatalogMaker catalog;
	private FileOpenButton fileOpen;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40, 50, 200, 30, "Text goes here", "Food Name");
		viewObjects.add(descriptionField);
		typeField = new TextField(40, 120, 200, 30, "Text goes here", "Food Type");
		viewObjects.add(typeField);
		flavorField = new TextField(40, 190, 200, 30, "Text goes here", "Food Flavor");
		viewObjects.add(flavorField);
		text= new TextArea(320, 20, 200, 30, "This is where text goes");
		viewObjects.add(text);
		list = new TextArea(320, 300, 100, 100, "Food List");
		viewObjects.add(list);
		addButton = new Button(280, 250, 40, 40, "add", new Action() {
			
			@Override
			public void act() {
				addClick("Add Button Clicked");
				
			}
		} );
		viewObjects.add(addButton);
		saveButton = new Button(330, 250, 40, 40, "save", new Action() {
			
			@Override
			public void act() {
				saveClick("Save Button Clicked");
				
			}
		});
		viewObjects.add(saveButton);
		deleteButton = new Button(380, 250, 40,40, "delete", new Action() {
			
			@Override
			public void act() {
				deleteClick("Delete Button Clicked");
				
			}
		} );
		viewObjects.add(deleteButton);
		fileOpen = new FileOpenButton(430, 250, 40, 40, null, this);
		viewObjects.add(fileOpen);
		catalog = new CatalogMaker();
		}

	protected void deleteClick(String string) {
		text.setText(string);
		
	}

	protected void saveClick(String string) {
		text.setText(string);
		
	}

	protected void addClick(String s) {
		catalog.addItem(new Food(descriptionField.getText(), typeField.getText(),flavorField.getText()));
		text.setText(s);
		list.setText(catalog.getCSVConetnt());
		descriptionField.setText("");
		typeField.setText("");
		flavorField.setText("");
		
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
