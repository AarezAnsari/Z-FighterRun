/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose:The purpose of this class is to be able to create block objects to the game
 * */
package zighterrun.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Game;
import zfighterrun.Framework.Gameobject;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;
//Part of the objects package which will contain various things in the game 
public class Block extends Gameobject {
	
	private int Type;
	Tiles tile = Game.getInstance();
	
	//Constructor to be used in main class
	public Block(float x, float y, Objectid id, int type) {
		super(x, y, id);
		this.Type = type;
	}

	//Tick method which can be used to update different features of the block object like movement
	public void tick(LinkedList<Gameobject> object) {
		
		
	}

	//Rendering blocks 
	public void render(Graphics g) {
		
		if(Type == 0) g.drawImage(tile.tiles[0],(int) x,(int) y,null);
		
			if(Type == 1) g.drawImage(tile.tiles[1],(int) x,(int) y,null);
		
		
		/*g.setColor(Color.white);
		g.drawRect((int) x,(int) y, 32, 32);
		*/
	}


	//Getting the actual collision bounds of the blocks
	public Rectangle getBounds() {
	
		return new Rectangle((int )x, (int) y, 32,32 );
	}



}
