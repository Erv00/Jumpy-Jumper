package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Window extends Canvas{
	
	public Window(JumpyJumpStart caller) {
		JFrame frame = new JFrame("Jumpy Jump");
		
		frame.setSize(640, 640/12*9);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(caller);
		caller.start();
	}
}
