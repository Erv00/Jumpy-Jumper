package objectBase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	public int x,y,velX,velY,width,height;
	public BufferedImage image;
	public Color color;
	public boolean useGrav = false;
	public int mass = 1;
	
	public GameObject(int _x,int _y,int _width,int _height,Color _color) {
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		color = _color;
	}
	
	public GameObject(int _x,int _y,BufferedImage _img) {
		x = _x;
		y = _y;
		image = _img;
		width = _img.getWidth();
		height = _img.getHeight();
	}
	
	public abstract void Tick();
	public abstract void Render(Graphics g);
}
