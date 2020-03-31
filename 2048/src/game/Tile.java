package game;

import java.awt.Graphics;

public class Tile {

	private boolean isFilled;
	
	public Tile(boolean isFilled) {
		this.isFilled = isFilled;		
	}
	
	public void render(Graphics g, int xPos, int yPos) {}
	
	public boolean getStatus() {
		return isFilled;
	}
	
	public int getValue() {
		return 0;
	}
	
	public void update() {}

	
}
