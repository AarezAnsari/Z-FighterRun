/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose:This handler class is responsible for the objects used in the game
 * 
 * */
package Window;

import java.awt.Graphics;
import java.util.LinkedList;

import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.Objectid;
import zighterrun.Objects.Block;

public class Handler {
	//Creating linked list of game objects 
	public LinkedList<Gameobject> object = new LinkedList<Gameobject>();
	//Creating a temporary gameobject holder 
	private Gameobject tempobject;

	//Tick method updating the objects in the game
	public void tick() {
		for (int a =0; a <object.size();a++) {
			tempobject= object.get(a);
			//Ticking the object
			tempobject.tick(object);
		}
	}
	//Rendering the objects in the game
	public void render(Graphics g) {
		for (int a =0; a <object.size();a++) {
			tempobject= object.get(a);
			//Rendering the object
			tempobject.render(g);
		}
	}
	
	//This method will be used in the main class to add an object
	public void addObject(Gameobject object) {
		this.object.add(object);
	}
	//This method will be used in the main class to remove an object 
	public void removeObject(Gameobject object) {
		this.object.remove(object);
		
	}
	


	

}
