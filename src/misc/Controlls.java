package misc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.JumpyJumpStart;

public class Controlls implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("The key " + arg0.getKeyChar() + "'s keycode is " + arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == 32) {
			JumpyJumpStart.pl.Jump();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
