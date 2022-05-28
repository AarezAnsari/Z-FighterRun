/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class WaterTLTile extends Tile {

	public WaterTLTile(int id) {
		super(Assets.waterTL,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
