/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: Handler used to pass values through the different classes
 */
package Game;

import Game.Input.KeyManager;
import Game.Input.MouseManager;
import Graphics.GameCamera;
import Worlds.World;

public class PocketHandler {
	
	private Game game;
	private World world;
	
	public  PocketHandler(Game game) {
		this.game=game;
	}

	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	
}
