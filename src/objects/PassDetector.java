package objects;

import java.awt.Color;

import main.JumpyJumpStart;
import objectBase.GameObject;

public class PassDetector extends Wall{

	public PassDetector(int _x, int _y, int _width, int _height, Color _color) {
		super(_x, _y, _width, _height, _color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void OnCollision(GameObject g) {
		System.out.println("PASS");
		JumpyJumpStart.h.RemoveObject(this);
		JumpyJumpStart.score++;
	}

}
