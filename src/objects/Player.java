package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import objectBase.GameObject;

public class Player extends GameObject {

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
		if(useGrav) {
			velY += mass;
			if(velY>0)
				velY--;
			if(velY<0)
				velY++;

		}
	}

	@Override
	public void Render(Graphics g) {
		if(hasImage)
			g.drawImage(image, x, y, null);
		else {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
		
	}
	
	public void Jump() {
		velY = -15;
		System.err.println("JUMP!");
	}

}
