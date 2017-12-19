package janeSample;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private static ArrayList<food> foodList;
	private static String[] items;
	
	public CatalogMaker() {
		foodList = new ArrayList<food>();
		foodList.add(new food ("Ice Cream", "Dessert", "sweet", "resources/iceCream.jpg"));
		foodList.add(new food ("Cupcakes", "Dessert", "sweet",  "resources/cupcake.jpg"));
		foodList.add(new food ("French Fries", "Side Dish", "savory", "resources/fries.jpg"));
		foodList.add(new food ("Fruit Salad", "Side Dish", "sweet","resources/salad.jpg"));
		foodList.add(new food ("Sushi", "Main Course", "savory", "resources/sushi.jpg"));
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
		creatItem(parameter);
		System.out.println("Do you want to add more items?");
		s=in.nextLine();
		if(s.equalsIgnoreCase("yes"))
			startAdding();
		else
			System.out.println("Thank you. Item saved.");
	}

	private void creatItem(String[] parameter) {
		foodList.add(new food (parameter[0], parameter[1], parameter[2], "resources/sushi.jpg"));
		
		
	}

	private static void checkInput(String[] parameter, int field, String s) {
			parameter[field] =s;
		
	}

	public String getCSVConetnt() {
		String data ="";
		for(food f: foodList) {
			data=data+f+"\n";
		}
		return data;
	}

}
