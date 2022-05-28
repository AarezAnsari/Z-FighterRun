/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class is to have an object for my lava tiles used in the game
 * */

package zighterrun.Objects;


	import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Animations;
import Window.Game;
import Window.Handler;
import Window.Game.States;
import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.KeyboardInput;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;
	//Part of the objects package which will contain various things in the game 
	public class Lava extends Gameobject {
		
		//Creating objects that are needed to be used in this class 
		Tiles tile = Game.getInstance();
		private Animations lavaFlow;
		Handler handler;
		
		//Constructor to be used in other classes to set values to like the main class 
		public Lava(float x, float y, Objectid id, Handler handler) {
			super(x, y, id);
			this.handler= handler;
		//Creating the flowing animations of the lava tiles	
		lavaFlow = new Animations(20,tile.lava[0],tile.lava[1],tile.lava[2]);	
		}

		//Tick method which can be used to update different features of the block object like movement
		public void tick(LinkedList<Gameobject> object) {
			//Ticking collision and animation so it keeps updating
			collision(object);
			lavaFlow.runAnimation();
			
		}

		//Rendering blocks 
		public void render(Graphics g) {
			//Drawing the actual animations to the object
			lavaFlow.drawAnimation(g, (int)x, (int)y,32,32);
			
			
			/*g.setColor(Color.white);
			g.drawRect((int) x,(int) y, 32, 32);
			*/
		}


		//Getting the actual collision bounds of the blocks
		public Rectangle getBounds() {
			//Setting parameters of the bound
			return new Rectangle((int )x, (int) y, 32,32 );
		}
		//This method will be checking for collision
		private void collision(LinkedList <Gameobject> object) {
			//For loop that will run through our objects to see which one is being used
				for (int a =0; a<handler.object.size(); a++) {
					//Getting a value for game object
					Gameobject tempobject = handler.object.get(a);
					
					
					//This will detect and execute the collision between the Lava and the player
					if(tempobject.getId() == Objectid.Player) {
						//This will detect if the player is in the lava
						if((getBounds().intersects( tempobject.getBounds()))) {
							//Updating static death counter and displaying it
								Boundry.DEATHS++;
								String deaths="number of deaths:";
								//using string handling to put the string variable to all uppercase 
								System.out.println(deaths.toUpperCase()+Boundry.DEATHS);
								
								
							//Removing the player once he hits the lava
							handler.removeObject(tempobject);
							//Respawning my player back to the starting point
							handler.addObject(new player(100,100,Objectid.Player,handler));;
							//Resetting the number of attacks you can use
							KeyboardInput.noOfAttacks=0;
							
							
						}
					}
				}
			}



	}

