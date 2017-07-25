package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	BufferStrategy bfs;
	
	public Window() {
		JFrame frame = new JFrame("Test");
		frame.add(this);
		frame.setSize(900, 700);
		frame.setVisible(true);
		bfs = CreateWindow();
	}
	
	private BufferStrategy CreateWindow() {
		createBufferStrategy(2);
		return this.getBufferStrategy();
		
	}
	
	private void Render() {
		Graphics g = bfs.getDrawGraphics();
		Tick(g);
		RenderObjects(g);
	}
	
	private void RenderObjects(Graphics g) {
		
	}
	
	private void Tick(Graphics g) {
		
	}
}
