/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class is to create my player object and use him in game
 * 
 * */
package zighterrun.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Animations;
import Window.Game;
import Window.Handler;
import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;

//Part of the objects package and is the blue-print for the main character
public class player extends Gameobject{
	//Variables used 
	private float width = 46, height = 71;
	private float gravity=0.6f;
	//Objects needed in this class
	private Handler handler;
	
	Tiles tile = Game.getInstance();
	//Creating the animations objects for the character
	private Animations moveRight,moveLeft,Jumping;
	
	
	//Constructor to be used in main class 
	public player(float x, float y, Objectid id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		//Creating the animations by getting there rows and coloumn numbers and displaying it as an animation
		moveRight = new Animations(10,tile.player[1],tile.player[1],tile.player[1]);
		moveLeft = new Animations(10,tile.player[2],tile.player[2]);
		Jumping = new Animations(5, tile.player[6]);

		
	}

	//This method will be checking for collision
	private void collision(LinkedList<Gameobject>object) {
		//For loop that will run through our objects to see which one is being used
		for (int a =0; a<handler.object.size(); a++) {
			Gameobject tempobject = handler.object.get(a);
			
			
			//This will detect and execute the collision between the objects and blocks
			if(tempobject.getId() == Objectid.block||tempobject.getId()==Objectid.Glass) {
				//Executing when the top collision box hits the block and setting values to 0
				if(getboundstop().intersects(tempobject.getBounds())) {
					//This will make sure our player always stays on top of the platform and wont go through
					y = tempobject.getY() + (68);
					vely=0;
					
				
				}
				//This will execute when the right collision box hits the blocks
				if(getboundsright().intersects(tempobject.getBounds())) {
					x = tempobject.getX() - (43);
				}
				
				//Executing when the bottom collision box hits the block and setting values to 0
				if(getBounds().intersects(tempobject.getBounds())) {
					//This will make sure our player always stays on top of the platform and wont go through
					y = tempobject.getY() - 70;
					vely=0;
					falling= false; jumping = false;
				
				}
				//This will execute when the left collision box hits a block
				if(getboundsleft().intersects(tempobject.getBounds())) {
					x = tempobject.getX() + (28);
				}
				
				//This makes sure that our player comes back down after jumping if its not on a platform
				else
				 falling = true;
					
			}
		}
	}
	//Tick method used to update players movement 
	public void tick(LinkedList<Gameobject> object) {
		//Adding velocity movement
		x+=velx;
		y+=vely;
		
		//Checking to see if my player is moving left or right
		if(velx<0) {
			looking=-1;
		}
		if(velx>0) {
			looking =1;
		}
		
		
		//Used when player is falling or jumping
		if(falling || jumping) {
			//This makes sure that the player goes back to the platform
			vely += gravity;
			
		}
		//Calling collision method to execute if collision occurs
		collision(object);
		//Running animations in tick
		moveRight.runAnimation();
		moveLeft.runAnimation();
		Jumping.runAnimation();
	}

	//Render method used to render the player
	public void render(Graphics g) {
		
		//g.setColor(Color.red);
		//Drawing my animations using render method
		
		if(velx!=0) {
			if(looking==1)
			moveRight.drawAnimation(g,(int) x,(int) y,46,71);
			else
			moveLeft.drawAnimation(g, (int) x, (int)y, 46,71);
		}
		else if(jumping==true) {
			Jumping.drawAnimation(g,(int) x, (int)y, 46,71);
		}
	
		else {
			g.drawImage(tile.player[0], (int)x, (int) y, 46,71,null);
		}
		
		//g.fillRect((int)x, (int)y, (int) width, (int) height);	
		
		
	    
		//convert graphics variable to graphics 2d variable to draw boxes 
		
			Graphics2D G2D= (Graphics2D) g;
			g.setColor(Color.WHITE);
			//These will get my collision bounds and actually draw them to my character
		/*	G2D.draw(getBounds());
			G2D.draw(getboundsleft());
			G2D.draw(getboundsright());
			G2D.draw(getboundstop());
	*/
	}


	//These methods set the collision bounds to my character
		public Rectangle getBounds() {
			
			return new Rectangle((int) ((int) x+(width/2)-(width/2)/2), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
		}
		public Rectangle getboundstop() {
			
			return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int)y, (int)width/2, (int)height/2);
		}

		public Rectangle getboundsleft() {
			
			return new Rectangle((int)x+2, (int)y+5, (int)5, (int)height-10);
		}
		public Rectangle getboundsright() {
			
			return new Rectangle((int) ((int)x+(width-8)), (int)y+5, (int)5, (int)height-15);
		}

	
		
	}

