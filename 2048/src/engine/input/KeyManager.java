package engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	private ArrayList<Key> heldKeys;
	private Key[] keyKey;
	public boolean up, down, left, right, up1, down1, left1, right1;
	
	public KeyManager() {
		keys= new boolean[256];
		heldKeys = new ArrayList<Key>();
		keyKey = new Key[256];
		
		for(int i = 0; i < keys.length; i++)
			keyKey[i] = new Key(keys[i], i);
	}
	
	public void tick() {
		
		//if in both make false
		for(int i = 0; i < keys.length; i++)
			if(keys[i] && heldKeys.contains(keyKey[i]))
				keys[i]=false;
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		up1 = keys[KeyEvent.VK_UP];
		down1 = keys[KeyEvent.VK_DOWN];
		left1 = keys[KeyEvent.VK_LEFT];
		right1 = keys[KeyEvent.VK_RIGHT];
		
		for(int i = 0; i < keys.length; i++)
			keyKey[i].setstat(keys[i]);
		
		//move to list
		for(int i = 0; i < keys.length; i++)
			if(keys[i]) 
				heldKeys.add(keyKey[i]);
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;		
	//	System.out.println("pressed");
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		heldKeys.remove(heldKeys.indexOf(keyKey[e.getKeyCode()]));
	}

	public void keyTyped(KeyEvent e) {}
}
