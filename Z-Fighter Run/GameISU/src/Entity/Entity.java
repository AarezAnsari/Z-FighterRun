/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: Abstract class for a basic stats of an entity 
 */
package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import Entity.Creatures.Player;
import Game.PocketHandler;

public abstract class Entity {

	protected PocketHandler handler; 
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	
	//constructor
	public Entity(PocketHandler handler, float x, float y,int width,int height) {
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		//collision bounds
		bounds = new Rectangle(0,0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics graphics);
	
	//Checking entity collision
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if((!(e instanceof Player)) &&
					 e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
					   {
					    return true;
					   }
		}
		return false;
	}
	
	//Getters and setters
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
