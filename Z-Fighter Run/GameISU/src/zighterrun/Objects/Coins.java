/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class is to be able to add coin objects to my game 
 * */
package zighterrun.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Animations;
import Window.Game;
import Window.Game.States;
import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;
import Window.Handler;

public class Coins extends Gameobject{
	//The different variables and objects used in this game
	public static int coinCount=0;
	Handler handler;
	Tiles tile = Game.getInstance();
	private Animations coinFloat;
	
	
	//Constructor that is used later on in the code during the main game class
	public Coins(float x, float y, Objectid id, Handler handler) {
		super(x, y, id);
		
		this.handler= handler;
		//Creating the floating animations
		coinFloat = new Animations(10,tile.coin[0],tile.coin[1],tile.coin[2],tile.coin[3],tile.coin[4],tile.coin[5]);
	}

	// this method updates all the animation and collision values
	public void tick(LinkedList<Gameobject> object) {
		collision(object);
		coinFloat.runAnimation();
		
	}
	//This method will be checking for collision
	private void collision(LinkedList <Gameobject> object) {
		//For loop that will run through our objects to see which one is being used
		
			for (int a =0; a<handler.object.size(); a++) {
				Gameobject tempobject = handler.object.get(a);
				
				
				//This will detect and execute the collision between the objects and blocks
				if(tempobject.getId() == Objectid.Player) {
					
					if((getBounds().intersects( tempobject.getBounds()))) {
						//System.out.println("Intersecting.");
						//This will remove my attack object once it hits a block
						
						//Game.currentState= States.Start;
						//Checking to see if the player has collected all coins
							if(coinCount!=4) {
							handler.removeObject(this);
							coinCount++;
							System.out.println("Coins Collected: "+coinCount);
							
							//handler.resetGame();
						
						
					//Game.currentState = States.End;
						}	
							//Once player has collected all coins games state changes to end screen
							 if(coinCount==4) {
								Game.currentState= States.End;
							}
					
					}
					
					
				}
			}
		}

	//This is where i render in the animation
	public void render(Graphics g) {
		 coinFloat.drawAnimation(g, (int) x, (int) y,32,32);
		
	}

	//Creating bounds on the coin to then use for collision
	public Rectangle getBounds() {
		
		return new Rectangle((int )x, (int) y, 32,32 );
	}

}
