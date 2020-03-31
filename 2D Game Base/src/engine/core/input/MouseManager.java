package engine.core.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager  implements MouseListener, MouseMotionListener{

	private boolean[] keys;
	public boolean left, right;
	public int mouseX, mouseY;
	
	public MouseManager() {
		keys = new boolean[7];
	}
	
	public void tick() {
		left = keys[1];
		right = keys[3];
	}
	
	public void mouseReleased(MouseEvent e) { keys[e.getButton()] = false; }
	public void mousePressed(MouseEvent e) { keys[e.getButton()] = true; }
	
	public void mouseDragged(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
	}
	public void mouseMoved(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	

}
