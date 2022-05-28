/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose:This is where i will load all of the different sprites used in the game
 * images sourced from spriters-resource.com
 * 
 * */

package zfighterrun.Framework;

import java.awt.image.BufferedImage;

import Window.BufferedimageLoader;
import zfighterrun.Framework.Sprites;


public class Tiles {
	
	//Creating Sprites objects for each type of tile i have 
	Sprites Sp, Sb,Sg,Sc,Sl,SG;
	//Creating bufferedImage objects of each tile
	private BufferedImage blocks = null;
	private BufferedImage Lava= null;
	private BufferedImage MainCharacter= null;
	private BufferedImage Coins=null;
	private BufferedImage Glass= null;
	//Creating array of objects type bufferedImage so that it can run through the animations of each sprite 
	public BufferedImage[] tiles = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[12];
	public BufferedImage[] coin = new BufferedImage[6];
	public BufferedImage[] lava = new BufferedImage[3];
	public BufferedImage[] glass = new BufferedImage[2];
	
	
	//Creating constructor that will be used to create sprites images
	public Tiles(){
		
		BufferedimageLoader load = new BufferedimageLoader();
		try {
			MainCharacter = load.loadImage("/maincharacter.png");
			blocks = load.loadImage("/Tiles.png");
			Coins= load.loadImage("/Tiles.png");
			Lava= load.loadImage("/Tiles.png");
			Glass = load.loadImage("/Tiles.png");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//29x44
		//This is where i create a type sprite object so that i can use the GetImage method i created to form the images
		//Player
		Sp = new Sprites(MainCharacter);
		//Blocks
		Sb = new Sprites(blocks);
		//Coins
		Sc = new Sprites(Coins);
		//Lava
		Sl = new Sprites(Lava);
		//Glass 
		SG = new Sprites(Glass);
		
		getTile();
	}
	//This is where i get the actual image from png files from there row and coloumn
	private void getTile() {
		//Setting my background
		//Lava Animation
		lava[0]=Sl.GetImage(3, 1, 32, 32);
		lava[1]=Sl.GetImage(4, 1, 32, 32);
		lava[2]=Sl.GetImage(5, 1, 32, 32);
		
		//Coin object animation
		coin[0]= Sc.GetImage(1, 2, 32, 32);
		coin[1]= Sc.GetImage(2, 2, 32, 32);
		coin[2]= Sc.GetImage(3, 2, 32, 32);
		coin[3]= Sc.GetImage(4, 2, 32, 32);
		coin[4]= Sc.GetImage(5, 2, 32, 32);
		coin[5]= Sc.GetImage(6, 2, 32, 32);
		//Dirt block
		tiles[0] = Sb.GetImage(1, 1, 32, 32);
		//Grass block
		tiles[1] = Sb.GetImage(2, 1, 32, 32);
		//Idle stance
		player[0] = Sp.GetImage(1, 1, 29,44);
		//Moving right 
		player[1] = Sp.GetImage(2, 1, 29,44);
		//Moving left
		player[2] = Sp.GetImage(3, 1, 30,44);
		//Other animations 
		player[3] = Sp.GetImage(4, 10,50,50);
		player[4] = Sp.GetImage(7, 2, 39,44);
		player[5] = Sp.GetImage(4, 1, 29,45);
		//Jumping Animations
		player[6] = Sp.GetImage(5, 1, 30,45);
		player[7] = Sp.GetImage(6, 1, 33,44);
		player[8] = Sp.GetImage(7, 1, 30,46);
		player[9] = Sp.GetImage(8, 1, 29,48);
		player[11] = Sp.GetImage(9, 1, 36,35);
		
		//attack orb animation
		player[10] = Sp.GetImage(10, 1, 32,45);
		//Glass image
		glass[0] = SG.GetImage(1, 3, 32, 32);
		
		
		
		
	}
	
}
