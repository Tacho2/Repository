package engine.core;

import engine.input.KeyManager;

public class Handler {

	private Game game;
	
	public Handler(Game game) {
		this.game=game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
}
