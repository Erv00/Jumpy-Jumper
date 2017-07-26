package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import objectBase.Handler;
import objects.Wall;

public class JumpyJumpStart extends Canvas implements Runnable{
	
	public static Handler h;
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	
	public JumpyJumpStart() {
		new Window(this);
		h = new Handler();
		Wall w = new Wall(10,10,20,20,Color.green);
		h.AddObject(w);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double ammountOfTicks = 60;
		double ns = 1000000000 /ammountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		h.Tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 640, 640/12*9);
		
		h.Render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new JumpyJumpStart();
	}
}
