package objects;

import java.awt.Color;
import java.awt.Graphics;

import main.JumpyJumpStart;
import misc.Objects;
import objectBase.GameObject;

public class Wall extends GameObject {

	public Wall(int _x, int _y, int _width, int _height, Color _color) {
		super(_x, _y, _width, _height, _color);
		//useGrav = true;
	}

	@Override
	public void Tick() {
		x += velX;
		y += velY;
		if(useGrav) {
			velY += mass;
		}
		if(x < -width) {
			JumpyJumpStart.h.RemoveObject(this);
			if(y == 0) {
				Objects.CreateNewPillars();
			}
			
		}
	}

	@Override
	public void Render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void OnCollision(GameObject g) {
		try {
			((Player)g).DieNextFrame = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
