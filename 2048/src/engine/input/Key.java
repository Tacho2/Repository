package engine.input;

public class Key {

	private boolean isPressed;
	private int keycode;
	
	public Key(boolean isPressed, int keycode) {
		this.isPressed = isPressed;
		this.keycode = keycode;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public int getKeycode() {
		return keycode;
	}
	
	public void setstat(boolean a) {
		this.isPressed = a;
	}
}
