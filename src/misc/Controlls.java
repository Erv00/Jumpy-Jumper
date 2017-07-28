package misc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlls implements KeyListener{
	
	public boolean[] keys = new boolean[255];

	@Override
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
		System.out.println("The key " + arg0.getKeyChar() + "'s keycode is " + arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
