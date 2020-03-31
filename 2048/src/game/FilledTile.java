package game;

import java.awt.Graphics;

import engine.gfx.Assets;

public class FilledTile extends Tile{

	int value;
	public static int	factor = 145, 
						constant = 18, 
						size = 127;
	
	public FilledTile(int value) {
		super(true);
		this.value = value;
	}
	
	public void render(Graphics g, int xPos, int yPos) {
		g.drawImage(Assets.tiles[value], xPos * factor + constant, yPos * factor + constant, size, size, null);		
	}
	
	public void update() {}
	
	
	
	public int getValue() {
		return value;
	}

}
