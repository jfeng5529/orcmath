package janeSample;

import java.awt.Graphics2D;

import guiPlayer.Sampler;
import guiTeacher.components.Component;

public class food extends Component {
	private String name;
	private String type;
	private String flavor;
	private String imgAdd;

	
	public food(String name, String type, String flavor, String imgAdd ) {
		super(40, 40, 260, 260);
		this.name = name;
		this.type = type;
		this.flavor =flavor;
		this.imgAdd = "resources/iceCream.jpg";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return name +","+type+","+flavor;
		
	}

}
