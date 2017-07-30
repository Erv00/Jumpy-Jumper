package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import misc.Controlls;
import objectBase.Handler;
import objects.Player;
import objects.Wall;

public class JumpyJumpStart extends Canvas implements Runnable{
	/**
	 * Object handler.
	 */
	public static Handler h;
	public static Controlls c = new Controlls();
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private static final int WIDTH = 640, HEIGHT = WIDTH/12*9, CANVAS_HEIGHT = HEIGHT-30;
	
	public static Player pl;
	
	public JumpyJumpStart() {
		new Window(WIDTH,HEIGHT,this,c);
		h = new Handler();
		Wall w1 = new Wall(0,CANVAS_HEIGHT/2+40,WIDTH,20,Color.green);
		Wall w2 = new Wall(50,230,50,70,Color.green);
		pl = new Player(WIDTH/2,CANVAS_HEIGHT/2,20,20,Color.green);
		//Wall k = new Wall(WIDTH+200,100,50,50,Color.GREEN);
		w1.velX = -7;
		w2.velX = -7;
		//k.velX = -7;
		//h.AddObject(k);
		h.AddObject(w1);
		//h.AddObject(w2);
		h.AddObject(pl);
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
		double ammountOfTicks = 20;
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
