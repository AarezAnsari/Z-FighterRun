/*
 * Name: Nathan
 * Date: 1/16/2020
 * Purpose: Overworld game state, contains main map and player positions loaded from txt file
 */
package States;

import java.awt.Graphics;

import Game.PocketHandler;
import Worlds.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(PocketHandler handler){
		super(handler);
	
		//world
		world = new World(handler,"Resources/Worlds/MainTown");
		handler.setWorld(world);

	
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics graphics) {
		//rendering world
		world.render(graphics);
	
	}
}
