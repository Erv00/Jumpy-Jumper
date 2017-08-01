package misc;

import java.awt.Color;
import java.util.Random;

import main.JumpyJumpStart;
import objectBase.Handler;
import objects.PassDetector;
import objects.Player;
import objects.Wall;

public class Objects {
	/**
	 * Creates walls,players,coins.
	 * @param WIDTH		Width of screen.
	 * @param HEIGHT	Height of screen.
	 * @param h 		Handler object.
	 */
	
	static Random r = new Random();
	static int currentDist = 660;
	static int increment = 200;
	
	public static void CreateObject(int WIDTH,int HEIGHT,Handler h) {
		

		
		//Create Objects
		Wall w1 = new Wall(660,0,20,200,Color.yellow);
		Wall w2 = new Wall(660,300,20,180,Color.yellow);
		int next = IncrementDist();
		Wall w3 = new Wall(next,0,20,200,Color.yellow);
		Wall w4 = new Wall(next,300,20,180,Color.yellow);
		next = IncrementDist();
		Wall w5 = new Wall(next,0,20,200,Color.yellow);
		Wall w6 = new Wall(next,300,20,180,Color.yellow);
		
		Wall TopWall = new Wall(0,0,WIDTH,20,Color.black);
		Wall BottomWall = new Wall(0,HEIGHT-20,WIDTH,20,Color.black);
		JumpyJumpStart.pl = new Player(WIDTH/2,HEIGHT/2,20,20,Color.green);
		
		//Set attributes
		
		
		//Set speed
		w1.velX = -10;
		w2.velX = -10;
		w3.velX = -10;
		w4.velX = -10;
		w5.velX = -10;
		w6.velX = -10;
		
		//Add to list
		h.AddObject(TopWall);
		h.AddObject(BottomWall);
		h.AddObject(w1);
		h.AddObject(w2);
		h.AddObject(w3);
		h.AddObject(w4);
		h.AddObject(w5);
		h.AddObject(w6);
		h.AddObject(JumpyJumpStart.pl);
	}
	
	public static void CreateNewPillars() {
		int up = r.nextInt(4)*100;
		if(up<=0)
			up = 100;
		Wall w3 = new Wall(660,0,20,up,Color.blue);
		w3.velX = -10;
		Wall w4 = new Wall(660,up+100,20,480-up+100,Color.blue);
		w4.velX = -10;
		PassDetector ps = new PassDetector(679,up,1,100,Color.black);
		ps.velX = -10;
		JumpyJumpStart.h.AddObject(w3);
		JumpyJumpStart.h.AddObject(w4);
		JumpyJumpStart.h.AddObject(ps);
	}
	
	private static int IncrementDist() {
		currentDist += increment;
		if(currentDist > 1060 ) {
			currentDist = 660;
		}
		return currentDist;
	}
}
