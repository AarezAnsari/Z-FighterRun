/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class LeavesDownTile extends Tile {
	
	public LeavesDownTile(int id) {
		super(Assets.leavesDown,id);

	}
	
	//making tile solid
		public boolean isSolid() {
			return true;
		}
}
