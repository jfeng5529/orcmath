package janeSample;

import java.util.ArrayList;

public class catalogMaker {

	private ArrayList<food> foodList;
	
	public catalogMaker() {
		foodList = new ArrayList<food>();
		foodList.add(new food ("Ice Cream", "Dessert", 200, false, "resources/iceCream.jpg"));
		foodList.add(new food ("Cupcakes", "Dessert", 250, false, "resources/cupcake.jpg"));
		foodList.add(new food ("French Fries", "Side Dish", 230, false, "resources/fries.jpg"));
		foodList.add(new food ("Fruit Salad", "Side Dish", 160, true, "resources/salad.jpg"));
		foodList.add(new food ("Sushi", "Main Course", 360, false, "resources/sushi.jpg"));
	}

	public static void main(String[] args) {
		catalogMaker list =new catalogMaker();
		System.out.println(list.getCSVConetnt());
	}
	public String getCSVConetnt() {
		String data ="";
		for(food f: foodList) {
			data=data+f+"\n";
		}
		return data;
	}

}
