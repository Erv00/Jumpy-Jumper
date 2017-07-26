package objectBase;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Handler {
	private LinkedList<GameObject> Objects = new LinkedList<GameObject>();
	
	public void AddObject(GameObject o) {
		Objects.add(o);
	}
	public void RemoveObject(int x) {
		Objects.remove(x);
	} 
	public boolean RemoveObject(GameObject o) {
		return Objects.remove(o);
	}
	
	public void Tick() {
		for(int i=0;i<Objects.size();i++) {
			Objects.get(i).Tick();
		}
	}
	public void Render(Graphics g) {
		for(int i=0;i<Objects.size();i++) {
			Objects.get(i).Render(g);
		}
	}
}
