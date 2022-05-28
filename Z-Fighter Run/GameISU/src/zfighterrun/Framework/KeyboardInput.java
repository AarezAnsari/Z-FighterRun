/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: This class is used to detect user input from the keyboard and translate it in the game to do various things 
 * */
package zfighterrun.Framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Window.Handler;
import Window.Animations;
import Window.Game;
import Window.Game.States;
import zfighterrun.Framework.Gameobject;
import zighterrun.Objects.Attack;

public class KeyboardInput extends KeyAdapter {
	
	public static boolean quit = false;
	//Created a public static varible for the number attacks used so that it can be reset after each death
	public static int noOfAttacks=0;
	Handler handler;

	Tiles tile = Game.getInstance();
	
	//constructor where we pass a handler from the main class
	public KeyboardInput(Handler handler) {
		this.handler = handler;
		
	}
	
	//This class is from the key adapter class and is responsible for our keys entered 
	public void keyPressed(KeyEvent e) {
		//Creating a variable that will hold the key values that are entered from the keyboard
		int key = e.getKeyCode();
		
		if(Game.currentState==States.Game) {
		
		//Creating a for loop that will run through the object id enum to see what object is being called
		for(int a =0; a < handler.object.size();a++) {
			//Creating tempobject to store the current object id 
			Gameobject tempobject = handler.object.get(a);
				
			//If statements that will correspond to player movement
			if(tempobject.getId() == Objectid.Player) {
					
					if(key == KeyEvent.VK_A) tempobject.setvelx(-5);
					
					if(key == KeyEvent.VK_D) tempobject.setvelx(5);
					if(key == KeyEvent.VK_SPACE && !tempobject.getJumping()) {
						//This prevents infinite jumping
						tempobject.setJumping(true); 
						//This allows our character to jump
					    tempobject.setvely(-15);
					}
					//Creating attack animation and object if user presses F
					if(key==KeyEvent.VK_F) {
						//Creating a limit on number of attacks you can use per life
						if(noOfAttacks<3) {
						//Creating attack object
						handler.addObject(new Attack(tempobject.getX(), tempobject.getY(),tempobject.getDirection()+10,Objectid.attack, handler));
						//Updating counter for attacks used
						noOfAttacks++;
						String attackcount ="Attacks Used:";
						//Creating a string then using string handling to display message in all uppercase letters
						System.out.println(attackcount.toUpperCase()+noOfAttacks);
						
						}
					}
				}
		}
		
		
		
		}
		//This will get the key input in the starting menu state of the game
		else if(Game.currentState==States.Start) {
			if(key==KeyEvent.VK_SPACE) {
				Game.currentState= States.Game;
			}
		}
		//This will get the key input in the End stae of the game
		else if(Game.currentState==States.End) {
				//This will close the program when user enters the ESC key 
			if(key == KeyEvent.VK_ESCAPE) {
					quit=true;
				}
			}
	
		}
	
	
	//This method is from the keyadapters class and is responsible for our keys released
	public void keyReleased(KeyEvent e) {
		
		//This will make sure that after the key has been released the player stops moving
		 int key = e.getExtendedKeyCode();
		 
		 if(Game.currentState==States.Game) {
		//Creating a for loop that will run through the object id enum to see what object is being called
		for(int a =0; a < handler.object.size();a++) {
			//Creating tempobject to store the current object id 
			Gameobject tempobject = handler.object.get(a);
				
			//If statements that will correspond to player movement
			if(tempobject.getId() == Objectid.Player) {
				//These are responsible for stopping the movement when key is released 
					//if(key == KeyEvent.VK_W) tempobject.setvely(0);
					
					if(key == KeyEvent.VK_A) tempobject.setvelx(0);
					
					//if(key == KeyEvent.VK_S) tempobject.setvely(0);
					
					if(key == KeyEvent.VK_D) tempobject.setvelx(0);
					
					
				}
		}
		
	}
	}
	}
	
