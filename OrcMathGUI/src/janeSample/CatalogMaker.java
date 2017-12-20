package janeSample;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;

public class CatalogMaker {

	private  ArrayList<Food> foodList;
	private static String[] items;
	
	public CatalogMaker() {
		foodList = new ArrayList<Food>();
		String[] temp= {"name of the food", "type of the food", "the flavor of the food"};
		items = temp;
	}

	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		maker.startAdding();
		System.out.println(maker.getCSVConetnt());
	}
	private void startAdding() {
		String s;
		String[] parameter = new String[3];
		Scanner in = new Scanner(System.in);
		int field=0;
		while(field<3) {
		System.out.println("What is "+items[field]);
		s = in.nextLine();
		checkInput(parameter , field, s);
		field++;
		}
		addItem(parameter);
		System.out.println("Do you want to add more items?");
		s=in.nextLine();
		if(s.contains("yes"))
			startAdding();
		else
			save();
	}

	public void addItem(String[] parameter) {
		foodList.add(new Food (parameter[0], parameter[1], parameter[2]));
		
		
	}

	private static void checkInput(String[] parameter, int field, String s) {
			parameter[field] =s;
		
	}

	public String getCSVConetnt() {
		String data ="";
		for(Food f: foodList) {
			data=data+f+"\n";
		}
		return data;
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("foodCatalog.csv");
			for(Food b: foodList){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"foodCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	public void addItem(Food f) {
		foodList.add(f);
		
	}

}
