package main;

import java.awt.Canvas;
import javax.swing.JFrame;

import misc.Controlls;

@SuppressWarnings("serial")
public class Window extends Canvas{
	/**
	 * Constructs a new window.
	 * @param width			The window's width.
	 * @param height		The window's height.
	 * @param caller		The window's caller.
	 * @param keyListener	A key listener to process key input.
	 */
	public Window(int width,int height,JumpyJumpStart caller,Controlls keyListener) {
		JFrame frame = new JFrame("Jumpy Jump");
		
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(caller);
		frame.addKeyListener(keyListener);
		caller.start();
	}
}
