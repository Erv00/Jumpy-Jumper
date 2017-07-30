package misc;

import java.awt.Color;

import main.JumpyJumpStart;
import objectBase.Handler;
import objects.Player;
import objects.Wall;

public class Objects {
	/**
	 * Creates walls,players,coins.
	 * @param WIDTH		Width of screen.
	 * @param HEIGHT	Height of screen.
	 * @param h 		Handler object.
	 */
	public static void CreateObject(int WIDTH,int HEIGHT,Handler h) {
		//Create Objects
		Wall w1 = new Wall(660,0,20,200,Color.yellow);
		Wall w2 = new Wall(50,230,50,70,Color.green);
		Wall TopWall = new Wall(0,0,WIDTH,20,Color.black);
		Wall BottomWall = new Wall(0,HEIGHT-20,WIDTH,20,Color.black);
		JumpyJumpStart.pl = new Player(WIDTH/2,HEIGHT/2,20,20,Color.green);
		
		//Set attributes
		
		
		//Set speed
		w1.velX = -7;
		w2.velX = -7;
		
		//Add to list
		h.AddObject(w1);
		h.AddObject(JumpyJumpStart.pl);
		h.AddObject(TopWall);
		h.AddObject(BottomWall);
	}
}
