/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class WaterMLTile extends Tile {

	public WaterMLTile(int id) {
		super(Assets.waterML,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
