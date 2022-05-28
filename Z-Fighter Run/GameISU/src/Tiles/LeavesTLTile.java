/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class LeavesTLTile extends Tile {

	public LeavesTLTile(int id) {
		super(Assets.leavesTL,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
