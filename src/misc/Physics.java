package misc;

import java.awt.Rectangle;

import main.JumpyJumpStart;
import objectBase.GameObject;

public class Physics {
	/**
	 * Checks if the hitbox is in contact with something.
	 * @param hitbox	The hitbox to check against.
	 * @return			True if it is standing on something.
	 */
	public static void OnCollision(GameObject hitbox) {
		for(int i=0;i<JumpyJumpStart.h.Objects.size();i++) {
			Rectangle hitbox2 = JumpyJumpStart.h.Objects.get(i).GetRect();
			if(hitbox.GetRect().intersects(hitbox2)) {
				if(!IsSame(hitbox.GetRect(),hitbox2))
					JumpyJumpStart.h.Objects.get(i).OnCollision(hitbox);
			}
		}
	}
	
	/**
	 * Checks whether two Rectangles have the same parameters.
	 * @param a	Rectangle 1.
	 * @param b	Rectangle 2.
	 * @return	True when the parameters match, otherwise false.
	 */
	private static boolean IsSame(Rectangle a, Rectangle b) {
		if(a.getX() == b.getX() && a.getY() == b.getY() && a.getWidth() == b.getWidth() && a.getHeight() == b.getHeight()) {
			return true;
		}
		return false;
	}
}
