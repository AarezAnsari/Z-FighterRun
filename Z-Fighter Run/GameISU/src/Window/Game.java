
/*
 * Author: Aarez Ansari
 * Date: Jan 16th ,3 2020
 * Purpose: //This is the main class of the game and will contain majority of the code to execute for the game 
 * */
package Window;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Display.Display;
import street.brawler.window.BufferedImageLoader;
import zfighterrun.Framework.KeyboardInput;
import zfighterrun.Framework.Objectid;
import zfighterrun.Framework.Tiles;
import zighterrun.Objects.Block;
import zighterrun.Objects.Boundry;
import zighterrun.Objects.Coins;
import zighterrun.Objects.Glass;
import zighterrun.Objects.Lava;
import zighterrun.Objects.player;

//Extending canvas to get jframe running
//Implementing Runnable Interface that allows this class to run on a separate thread
public class Game extends Canvas  {

	private int runOnce=1;
	//Creating variables 
	private boolean running = false;
	//Creating objects of specific type to use in the main game class
	private Thread thread;
	Handler handler;
	View camera;
	//Getting the width and height of my window
	public static int width, height;
	//These will load my images to the screen
	private BufferedImage gameLevel = null;
	private BufferedImage Background = null;
	private BufferedImage StartMenu=null;
	private BufferedImage EndScreen=null;
	static Tiles tile;
	//Creating an enum for the different states of my game
	public enum States{
		Start,
		Game,
		End
	}
	//getting states

	BufferedImageLoader loader;
	
	//Creating game state as starting menu when application is opened
	public static States currentState= States.Start;
	//This is the games init method where the important variables and objects that need to be initialized are 
	private void init() {
		
		loader = new BufferedImageLoader();
		//Width of window
		width = getWidth();
		//Height of window
		height = getHeight();
		//Creating object type handler
		handler = new Handler();
		//Creating object type buffered image loader
		
		//Creating object type Tiles
		tile= new Tiles();
		
		
		
		//This allows us to load our games map
		try {
			gameLevel = loader.loadImage("/ZFighterImages/Level.png");
			//This loads the game backgoround
			Background = loader.loadImage("/ZFighterImages/GameBackground.png");
			//This is the beginning menu of our game
			StartMenu = loader.loadImage("/ZFighterImages/StartMenu.png");
			//This is the end screen of our game
			EndScreen = loader.loadImage("/ZFighterImages/EndScreen.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Creating camera object for platformer
		camera = new View(0,0);
		
	
		
		
		
		
		//Loading the maps platforms
		loadGameLevel(gameLevel);
		
		Display.getFrame().addKeyListener(new KeyboardInput(handler));
		
		
	} 
	
	
	
	
	//Creating a method that takes the RGB values of the pixels on the map image i created and creates objects to the like the blocks and player
	private void loadGameLevel(BufferedImage img) {
		//Getting the map image width and height
		int Height = img.getHeight();
		int Width = img.getWidth();
		
		
		
		//This will loop through all the pixels of our image
		for(int X =0; X<Height;X++) {
			for(int Y=0; Y<Width;Y++) {
				//This segments will get the location value of the pixel and the RGB values  
				int pix = img.getRGB(X,Y);
				 int RED =(pix >> 16)& 0xff;
				 int GREEN =(pix >>8)& 0xff;
				 int BLUE = (pix)& 0xff;
				 //Checking for pixels to add dirt block to
				if(RED == 22 && GREEN == 22 && BLUE==22) {
					handler.addObject(new Block(X*32,Y*32,Objectid.block,0));
				}
				 
				//Checking for pixels to add grass block to
				 if(RED == 11 && GREEN ==11 && BLUE==113) {
					 handler.addObject(new Block(X*32, Y*32, Objectid.block,1));
				 }
				 
				 
				 //Checking for pixels to add player to
				 if(RED == 120 && GREEN==11 && BLUE==113) {
					 handler.addObject(new player(X*32,Y*32,Objectid.Player,handler));
				 }
				 //Checking to add coin objects
				 if(RED==0&&GREEN==0&&BLUE==150) {
					 handler.addObject(new Coins(X*32, Y*32, Objectid.Coin,handler));
				 }
				 //Checking to add Lava objects
				 if(RED==255&&GREEN==0&&BLUE==0) {
					 handler.addObject(new Lava(X*32, Y*32, Objectid.Lava,handler));
				 }
				 //Checking to add glass objects 
				 if(RED==100&&GREEN==0&&BLUE==100) {
					 handler.addObject(new Glass(X*32, Y*32, Objectid.Glass,handler));
				 }
				 //Checking to add Boundry objects
				 if(RED==50&&GREEN==50&&BLUE==50) {
					 handler.addObject(new Boundry(X*35, Y*35, Objectid.Boundry,handler));
				 }
				 
			
			}
			}
		
		
	}
	//This method is responsible for rendering the buffer strategy and drawing all the graphics and images to the window
	public void render(Graphics g) {
		
		//Creating graphics 2d for camera
		Graphics2D G2D = (Graphics2D) g;
		
		//Begin Drawings here
		
       
		
		
		//Checking to see which state the game is in
		if(currentState ==States.Game) {
			//Running graphics for game state
			 g.drawImage(Background, 0, 0, 640, 480, null);
				
				
				//Beginning our camera POV 
				G2D.translate(camera.getX(), camera.getY());
				//Everything in between beginning and end will be affected by the camera
				
				
					//Render our handler so that objects appear 
					handler.render(g);
				
				
				
				
				
				//Ending our Camera POV
				G2D.translate(-camera.getX(), -camera.getY());
				

					
		}
		//Checking to see which state the game is in
		else if(currentState==States.Start) {
			//Drawing image for Starting menu state
			g.drawImage(StartMenu,0,0,640,480,null);
		}
		//Checking to see which state the game is in 
		else if(currentState==States.End) {
			//Drawing image for Ending state
			g.drawImage(EndScreen,0,0,640,480,null);
		
		}
		
       
			
		
		
	}
	
	public void resetVariables() {
		Boundry.DEATHS=0;
		Coins.coinCount=0;
		runOnce=1;
		KeyboardInput.noOfAttacks=0;
		init();
		
	}
	
	//This method is used to update the values of objects and variables in the game like the players location
	public void tick() {
		
		if(KeyboardInput.quit) {
			resetVariables();
			
		}
		
		if(runOnce==1) {
			KeyboardInput.noOfAttacks=0;
			init();
			runOnce=2;
		}
		
		if(handler.object.get(0).getY()>=480) {
			Boundry.DEATHS++;
		}
			
			//this will update all the handler objects and update their values
			handler.tick();
			//Creating a loop that runs through objects and locates player
			for(int a =0; a< handler.object.size(); a++) {
				//Ticking players location
				if(handler.object.get(a).getId()== Objectid.Player) {
					camera.tick(handler.object.get(a));  
					}
				}
			
			
				
			
	
		}
		
		
		
	//Creating an instance method for tiles so that all objects can use them
	public static Tiles getInstance() {
		return tile;
	}


	
	
}
