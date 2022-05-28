/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class LeavesLeftTile extends Tile {
	
	public LeavesLeftTile(int id) {
		super(Assets.leavesLeft,id);

	}
	
	//making tile solid
		public boolean isSolid() {
			return true;
		}
}
