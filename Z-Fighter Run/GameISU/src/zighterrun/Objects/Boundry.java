/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class is to add boundry blocks to the game so that the player doesnt fall off the map
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
	public class Boundry extends Gameobject {
		//Counter used for number of deaths 
		public static int DEATHS=0;
		//Creating objects that will be used in this class 
		Tiles tile = Game.getInstance();
		private Animations lavaFlow;
		Handler handler;
		
		//Constructor to be used in main class
		public Boundry(float x, float y, Objectid id, Handler handler) {
			super(x, y, id);
			this.handler= handler;
			
			
		}

		//Tick method which can be used to update different features of the block object like collision
		public void tick(LinkedList<Gameobject> object) {
			collision(object);
			
			
		}

		//Rendering blocks 
		public void render(Graphics g) {
			
			
			
			
			/*g.setColor(Color.white);
			g.drawRect((int) x,(int) y, 32, 32);
			*/
		}


		//Getting the actual collision bounds of the blocks
		public Rectangle getBounds() {
		
			return new Rectangle((int )x, (int) y, 32,32 );
		}
		//This method will be checking for collision
		private void collision(LinkedList <Gameobject> object) {
			//For loop that will run through our objects to see which one is being used
			
				for (int a =0; a<handler.object.size(); a++) {
					Gameobject tempobject = handler.object.get(a);
					
					
					//This will detect and execute the collision between the player and the boundry
					if(tempobject.getId() == Objectid.Player) {
						
						if((getBounds().intersects( tempobject.getBounds()))) {
							//System.out.println("Intersecting.");
							//This will remove my player object once it hits a boundry
							
								DEATHS++;
								String deaths="number of deaths:";
								//Using string handling to display number of deaths in all uppercase
								System.out.println(deaths.toUpperCase()+DEATHS);
								
								
							//This will remove my player once he hits the boundry
							handler.removeObject(tempobject);
							//Respawning player back to the beginning
							handler.addObject(new player(100,100,Objectid.Player,handler));;
							//This will reset the number of attacks the user can use
							KeyboardInput.noOfAttacks=0;
							
						}
					}
				}
			}



	}

