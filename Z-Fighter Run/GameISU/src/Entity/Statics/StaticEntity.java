/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: Abstract class defining a entity that does not move
 */
package Entity.Statics;

import java.awt.Graphics;

import Entity.Entity;
import Game.PocketHandler;

public abstract class StaticEntity extends Entity {

	//constructor
	public StaticEntity(PocketHandler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics graphics) {
	}

}
