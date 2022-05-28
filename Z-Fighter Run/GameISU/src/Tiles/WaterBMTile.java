/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class WaterBMTile extends Tile {

	public WaterBMTile(int id) {
		super(Assets.waterBM,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
