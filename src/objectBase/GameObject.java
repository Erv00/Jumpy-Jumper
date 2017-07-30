package objectBase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	public int x,y,velX,velY,width,height;
	public BufferedImage image;
	public Color color;
	/**
	 * Defines whether the object should be affected by gravity.
	 * Default is false.
	 */
	public boolean useGrav = false;
	/**
	 * Defines the object's mass. Mass effects gravity's pull.
	 */
	public int mass = 1;
	/**
	 * True when the Game Object was created with an image or sprite,otherwise false.
	 */
	protected boolean hasImage;
	
	/**
	 * Creates a new Game Object with a solid color.
	 * @param _x		The object's x position.
	 * @param _y		The object's y position.
	 * @param _width	The object's width. It will also define it's hitbox.
	 * @param _height	The object's height. It will also define it's hitbox.
	 * @param _color	The object's solid color.
	 */
	public GameObject(int _x,int _y,int _width,int _height,Color _color) {
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		color = _color;
		hasImage = false;
	}
	
	/**
	 * Creates a new Game Object wit an image or sprite.
	 * @param _x		The object's x position.
	 * @param _y		The object's y position.
	 * @param _img		The object's sprite or image.
	 */
	public GameObject(int _x,int _y,BufferedImage _img) {
		x = _x;
		y = _y;
		image = _img;
		width = _img.getWidth();
		height = _img.getHeight();
		hasImage = true;
	}
	
	/**
	 * The object does things defined in this method.
	 */
	public abstract void Tick();
	/**
	 * Render the object in a way defined in this method.
	 * @param g	The Graphics object to draw with.
	 */
	public abstract void Render(Graphics g);
	
	/**
	 * Gets the objects hitbox. The hitbox is defined when the constructor is called.
	 * @return	The objects hitbox
	 */
	public Rectangle GetRect() {
		return new Rectangle(x,y,width,height);
	}
}
