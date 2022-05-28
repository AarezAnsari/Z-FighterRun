/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: the purpose of this class is to be able to use sprite images and create an animation with them
 * 
 * */
package Window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animations {
	//Variables needed
	private int frame;
	private int Speed;
	
	private int in=0;
	private int counter=0;
	//Objects type buffered Image to get the specific picture and current frame 
	private BufferedImage[] img;
	private BufferedImage current;
	//The "..." allows us to basically to have an infinite amount of parameters type bufferedimage
	//Creating a constructor which can be used to create other animations
	public Animations(int Speed, BufferedImage...args) {
		this.Speed = Speed;
		img = new BufferedImage[args.length];
		for(int a =0; a<args.length; a++) {
			img[a] = args[a];
		}
		frame = args.length;
	}
	//This method will actually loop throught the sprite images
	public void runAnimation() {
		in++;
		if(in>Speed) {
			in = 0; 
			nextframe();
		}
		
	}
	//this method will get the image that is next to the previous so that it can create a proper animation
	private void nextframe() {
		for(int a =0; a<frame; a++) {
			if(counter == a) {
				current = img[a];
			}
		}
		counter++;
		
		if(counter>frame) {
			counter=0;
		}
	}
	//This method will be able to used any sprite graphics image and display it on an object
	public void drawAnimation(Graphics g, int X, int Y) {
		g.drawImage(current, X, Y, null);
	}
	//Overloading the method to be able to put the image to scale to the object
	public void drawAnimation(Graphics g, int X, int Y, int scalex, int scaley) {
		g.drawImage(current, X, Y, scalex, scaley ,null);
	}
	
	
	
	
	
}
