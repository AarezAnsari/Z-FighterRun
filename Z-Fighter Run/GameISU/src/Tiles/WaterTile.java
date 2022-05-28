/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
