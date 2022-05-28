package States;

import java.awt.Graphics;

import Game.PocketHandler;
import Window.Game;
import Window.Game.States;
import zfighterrun.Framework.KeyboardInput;
import zighterrun.Objects.Coins;


public class ZFighterRunState extends State{
	
	private int runOnce=1;
	Game game;
	public ZFighterRunState(PocketHandler handler){
		super(handler);

	}

	@Override
	public void tick() {
		if(runOnce==1) {
			game = new Game();
			runOnce=2;
		}
		if(runOnce==2) {
			game.tick();
			if(KeyboardInput.quit) {
				Game.currentState= States.Start;
				runOnce=1;
				Coins.coinCount=0;
				State.setState(handler.getGame().startingState);
				
				
				
			}
		}
		
			
	}

	@Override
	public void render(Graphics g) {
		if(runOnce==2) {
			game.render(g);
		}
		
	}
	

}

