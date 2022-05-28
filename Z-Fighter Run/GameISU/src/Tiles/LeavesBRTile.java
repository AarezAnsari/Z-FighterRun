/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class LeavesBRTile extends Tile {

	public LeavesBRTile(int id) {
		super(Assets.leavesBR,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
