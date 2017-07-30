package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.JumpyJumpStart;
import misc.Physics;
import objectBase.GameObject;

public class Player extends GameObject {
	
	boolean DieNextFrame = false;

	public Player(int _x, int _y, BufferedImage _img) {
		super(_x, _y, _img);
		//useGrav = true;
	}

	public Player(int _x, int _y, int _width, int _height, Color _color) {
		super(_x,_y,_width,_height,_color);
		useGrav=true;
	}

	@Override
	public void Tick() {
		x += velX;
		y += velY;
		if(Physics.IsStanding(GetRect())) {
			System.out.println("Standing");
			DieNextFrame = true;
		}
		if(useGrav) {
			velY += mass;
			//if(velY>0)
			//	velY--;
			if(velY<0)
				velY++;
		}
	}

	private void Die(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("Ur DEAD!    NOT BIG SUPRISE    :P", JumpyJumpStart.WIDTH/2, JumpyJumpStart.CANVAS_HEIGHT/2);
	}

	@Override
	public void Render(Graphics g) {
		if(DieNextFrame){
			Die(g);
			return;
		}
		if(hasImage)
			g.drawImage(image, x, y, null);
		else {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
		
	}
	
	/**
	 * Jumps.
	 */
	public void Jump() {
			velY = -15;
			System.err.println("JUMP!");
	}

}
