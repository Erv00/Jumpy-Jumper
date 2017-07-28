package objectBase;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	/**
	 * List of Game Object to tick and render.
	 */
	private LinkedList<GameObject> Objects = new LinkedList<GameObject>();
	
	/**
	 * Adds a Game Object to {@link #Objects}.
	 * @param o	The Game Object to add.
	 */
	public void AddObject(GameObject o) {
		Objects.add(o);
	}
	/**
	 * Removes a Game Object from {@link #Objects)}.
	 * @param x	The Game Object's index to remove.
	 */
	public void RemoveObject(int x) {
		Objects.remove(x);
	} 
	/**
	 * Removes a Game Object from {@link #Objects)}.
	 * @param o	The Game Object to remove.
	 * @return	True if the List contained it and was successfully removed, otherwise false.
	 */
	public boolean RemoveObject(GameObject o) {
		return Objects.remove(o);
	}
	
	/**
	 * Iterates and ticks the game objects.
	 */
	public void Tick() {
		for(int i=0;i<Objects.size();i++) {
			Objects.get(i).Tick();
		}
	}
	/**
	 * Iterates and renders the game objects.
	 * @param g	This parameter will be passed to the game objects render function.
	 */
	public void Render(Graphics g) {
		for(int i=0;i<Objects.size();i++) {
			Objects.get(i).Render(g);
		}
	}
}
