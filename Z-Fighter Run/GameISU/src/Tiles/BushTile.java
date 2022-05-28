/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: game tile
 */
package Tiles;

import Graphics.Assets;

public class BushTile extends Tile {

	public BushTile(int id) {
		super(Assets.bush,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
