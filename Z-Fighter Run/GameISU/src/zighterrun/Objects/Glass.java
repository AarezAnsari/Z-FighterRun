/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class was to create Glass objects and use them in the game
 * 
 * */
package zighterrun.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Game;
import Window.Handler;
import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;
	//Part of the objects package which will contain various things in the game 
	public class Glass extends Gameobject {
		//The objects that are used in this class 
		Handler handler;
		Tiles tile = Game.getInstance();
		
		//Constructor to be used in main class
		public Glass(float x, float y, Objectid id,Handler handler) {
			super(x, y, id);
			this.handler = handler;
			
		}

		//Tick method which can be used to update different features of the Glass object 
		public void tick(LinkedList<Gameobject> object) {
			
			
		}

		//Rendering blocks 
		public void render(Graphics g) {
			//Drawing the actual block image
			g.drawImage(tile.glass[0],(int) x,(int) y,null);
			
			
			
			
			/*g.setColor(Color.white);
			g.drawRect((int) x,(int) y, 32, 32);
			*/
		}


		//Getting the actual collision bounds of the blocks
		public Rectangle getBounds() {
		//Setting the values of width and height
			return new Rectangle((int )x, (int) y, 32,32 );
		}



	}


