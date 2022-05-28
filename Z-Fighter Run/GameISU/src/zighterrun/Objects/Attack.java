package zighterrun.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Animations;
import Window.Game;
import Window.Handler;
import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;



public class Attack extends Gameobject {
	Tiles tile = Game.getInstance();
	private Animations attack;
	private Handler handler;

	public Attack(float x, float y,int velx, Objectid id,Handler handler) {
		super(x, y, id);
		this.velx=velx;
		this.handler= handler;
		attack = new Animations(5,tile.player[10]);
	}
	//This method will be checking for collision
		private void collision(LinkedList <Gameobject> object) {
			//For loop that will run through our objects to see which one is being used
			
				for (int a =0; a<handler.object.size(); a++) {
					Gameobject tempobject = handler.object.get(a);
					
					
					//This will detect and execute the collision between the objects and blocks
					if(tempobject.getId() == Objectid.block) {
						
						if((getBounds().intersects( tempobject.getBounds()))) {
							//System.out.println("Intersecting.");
							//This will remove my attack object once it hits a block
							handler.removeObject(this);
							
						
							
							
						}
					}
					if(tempobject.getId()==Objectid.Glass) {
						if((getBounds().intersects( tempobject.getBounds()))) {
							//System.out.println("Intersecting.");
							//This will remove my attack object once it hits a block
							handler.removeObject(this);
							handler.removeObject(tempobject);
						
						
							
							
						}
					
						
					}
				}
			}
	
	public void tick(LinkedList<Gameobject> object) {
		x+=velx;
		collision(object);
		attack.runAnimation();
	
	}

	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect((int)x,(int)y,24,24);
		attack.drawAnimation(g,(int) x-4,(int)y+4,38,39 );
		
		
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y, 24,24);
	}

}
