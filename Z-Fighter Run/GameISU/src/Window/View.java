/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class is to act as a camera that will follow the player
 * 
 * */
package Window;

import zfighterrun.Framework.Gameobject;
import zighterrun.Objects.player;

public class View {
	
	private float x, y;
	//Constructor that will be called in main class 
	public View(float x , float y) {
		this.x=x;
		this.y=y;
	}
	
	//This allows the camera to stay on our player
	public void tick(Gameobject Player) {
		
		//This will lock the camera to follow our players movements
		x = -Player.getX() + 640/2;
		
	}
	//Setters and getters for the coordinates of the camera 
	public float getY() {
		return y;
	}
	public void setY(float Y) {
		this.y=Y;
		
	}
	public float getX() {
		return x;
	}
	public void setX(float X) {
		this.x=X;
	}

}
