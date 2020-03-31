package engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int height = 50, width = 50;
	
	public static BufferedImage[] tiles;
	public static BufferedImage background;
	
	public static void init() {
		
		SpriteSheet Tiles = new SpriteSheet(ImageLoader.loadImage("/images/Tiles.png"));
		
		background = ImageLoader.loadImage("/images/emptyBoard.png");
		
		tiles = new BufferedImage[18];
		
		for(int i = 0; i < 10; i++)
			tiles[i + 2] = Tiles.crop(i * width, 0, width, height);
		tiles[1] = Tiles.crop(0, height, width, height);
		
	}
}
