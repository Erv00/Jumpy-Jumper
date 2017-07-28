package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.JumpyJumpStart;
import objectBase.GameObject;

public class Player extends GameObject {

	public Player(int _x, int _y, BufferedImage _img) {
		super(_x, _y, _img);
		//useGrav = true;
	}

	@Override
	public void Tick() {
		x += velX;
		y += velY;
		if(useGrav)
			velY += mass;
		//if(JumpyJumpStart.c.keys)
	}

	@Override
	public void Render(Graphics g) {
		g.drawImage(image, x, y, null);
	}

}
