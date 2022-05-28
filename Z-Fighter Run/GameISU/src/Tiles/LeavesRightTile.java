/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class LeavesRightTile extends Tile {
	
	public LeavesRightTile(int id) {
		super(Assets.leavesRight,id);

	}
	
	//making tile solid
		public boolean isSolid() {
			return true;
		}
}
