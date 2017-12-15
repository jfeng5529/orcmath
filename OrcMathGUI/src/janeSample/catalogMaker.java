package janeSample;

import java.util.ArrayList;

public class catalogMaker {

	private ArrayList<food> foodList;
	
	public catalogMaker() {
		foodList = new ArrayList<food>();
		foodList.add(new food ("Ice Cream", "Dessert", 200, false, "ice"));
		foodList.add(new food ("Cupcakes", "Dessert", 250, false, "ice"));
		foodList.add(new food ("French Fries", "Side Dish", 230, false, "ice"));
		foodList.add(new food ("Fruit Salad", "Side Dish", 160, true, "ice"));
		foodList.add(new food ("Sushi", "Main Course", 360, false, "ice"));
		foodList.add(new food ("taco", "Main Course", 460, false, "ice"));
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
