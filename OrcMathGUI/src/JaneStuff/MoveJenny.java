package JaneStuff;

public class MoveJenny implements MoveInterfaceJane{

	private ButtonInterfaceJane button;
	
	public MoveJenny(ButtonInterfaceJane buttonInterfaceJane) {
		this.button = buttonInterfaceJane;
	}

	@Override
	public ButtonInterfaceJane getButton() {
		return button;
	}
}
