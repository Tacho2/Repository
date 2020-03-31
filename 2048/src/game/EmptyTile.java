package game;

import java.awt.Graphics;

public class EmptyTile extends Tile{

	public EmptyTile() {
		super(false);
	}

	public void render(Graphics g, int xPos, int yPos) {}
	
}
