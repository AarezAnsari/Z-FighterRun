/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose:This class is used as a blue-print for different objects in the game like player, enemies, or attacks, etc.
 * 
 * */
package zfighterrun.Framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;


public abstract class Gameobject {
	//Variables used
	protected float x,y;
	protected Objectid id;
	protected float velx=0, vely=0;
	protected boolean falling  = true, jumping = false;
	protected int looking =1;
	//Objects used
	public Rectangle getBounds;
	//Creating a constructor to use in other packages of the game
	public Gameobject(float x , float y, Objectid id) {
		
		this.x= x;
		this.y=y;
		this.id= id;
	}

	
	//Tick, render and bound methods for the game objects
	public abstract void tick(LinkedList<Gameobject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//Setters and getters for the game objects location (x,y), velocity (velx, vely), checking to see if the object is falling or jumping, and getting the objects id
	public float getX() {
		
		return x;
	}

	
	public float getY() {
	
		return y;
	}

	
	public void setX(float x) {
		this.x=x;
		
	}

	
	public void setY(float y) {
		this.y=y;
		
	}

	
	public float getvelx() {
	
		return velx;
	}

	
	public float getvely() {
		
		return vely;
	}

	
	public void setvelx(float velx) {
		
		this.velx=velx;
	}

	
	public void setvely(float vely) {
		
		this.vely = vely;
	}

	public boolean getFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean getJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public  Objectid getId() {
		return id;
	}
	public int getDirection() {
		return looking;
	}
}
