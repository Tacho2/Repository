package game;

import java.awt.Graphics;
import engine.core.Handler;
import engine.input.KeyManager;

public class Gameboard {

	private Tile[][] gameboard; 
	private KeyManager keyMan;
	
	public Gameboard(Handler handler) {
		this.keyMan = handler.getKeyManager();
		
		gameboard = new Tile[4][4];
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				gameboard[i][j] = new EmptyTile();
		
		addNewTile();
		addNewTile();
		
//		gameboard[0][0] = new FilledTile(4);	gameboard[1][0] = new FilledTile(4);	gameboard[2][0] = new FilledTile(4);	gameboard[3][0] = new FilledTile(4);
//		
//		gameboard[0][1] = new FilledTile(2);	gameboard[1][1] = new FilledTile(2);	gameboard[2][1] = new FilledTile(2);	gameboard[3][1] = new FilledTile(2);
//					
///*		gameboard[0][2] = new FilledTile(0);	gameboard[1][2] = new FilledTile(0);	*/gameboard[2][2] = new FilledTile(7);	//gameboard[3][2] = new FilledTile(0);
////		
//        	gameboard[0][3] = new FilledTile(11);	//gameboard[1][3] = new FilledTile(0);	gameboard[2][3] = new FilledTile(0);	*/gameboard[3][3] = new FilledTile(8);
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				gameboard[i][j].render(g, i, j);
	}
	
	public void update() {
		getInput();
	}
	
	public void getInput() {
		if(keyMan.down || keyMan.down1)
			Move.down(gameboard);
		if(keyMan.up || keyMan.up1)
			Move.up(gameboard);
		if(keyMan.left || keyMan.left1)
			Move.left(gameboard);
		if(keyMan.right || keyMan.right1)
			Move.right(gameboard);
		
	}
	
	public void fill() {
	
		}

	public void addNewTile() {
		boolean started = false;
		
		while(!started) {
			int x = (int)(Math.random()*4);
			int y = (int)(Math.random()*4);
			int f = (int)(Math.random()*2) + 1;
			
			if(!gameboard[x][y].getStatus()) {
				gameboard[x][y] = new FilledTile(f);
				started = true;
			}
		}
	}
	}
