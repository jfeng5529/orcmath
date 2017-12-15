package janeSample;

import java.awt.Graphics2D;

import guiPlayer.Sampler;
import guiTeacher.components.Component;

public class food extends Component {
	private String name;
	private String type;
	private int calories;
	private boolean isVegan;
	private String imgAdd;

	
	public food(String name, String type, int calories, boolean isVegan, String imgAdd ) {
		super(40, 40, 260, 260);
		this.name = name;
		this.type = type;
		this.calories =calories;
		this.isVegan = isVegan;
		this.imgAdd = "resources/iceCream.jpg";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		String vegan;
		if(isVegan) vegan = "vegan";
		else
			vegan = "not vegan";
		return name +","+type+","+calories+","+vegan;
		
	}

}
