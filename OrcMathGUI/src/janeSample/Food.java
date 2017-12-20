package janeSample;

import java.awt.Graphics2D;

import guiPlayer.Sampler;
import guiTeacher.components.Component;

public class Food extends Component {
	private String name;
	private String type;
	private String flavor;


	
	public Food(String name, String type, String flavor) {
		super(40, 40, 260, 260);
		this.name = name;
		this.type = type;
		this.flavor =flavor;
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
