package JaneStuff;

public class MoveJenny implements MoveInterfaceJane{

	private ButtonInterfaceJane button;
	
	public MoveJane(ButtonInterfaceJane bIndex) {
		this.button = bIndex;
	}

	@Override
	public ButtonInterfaceJane getButton() {
		return button;
	}
}
