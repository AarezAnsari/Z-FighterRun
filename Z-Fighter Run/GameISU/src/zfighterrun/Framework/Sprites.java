/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose:This class uses the sprites and gets the image location and height on png file and allows us to use the images 
 * 
 * */
package zfighterrun.Framework;

import java.awt.image.BufferedImage;


public class Sprites {

	private BufferedImage Image;
	//Constructor that will be used to call the images
	public Sprites(BufferedImage Image) {
		this.Image = Image;
	}

	//This method is used to get our image from the sprite sheet
	public BufferedImage GetImage(int coloumn, int row, int W, int H ) {
		//This will get the image at the specific column and row 
		BufferedImage image = Image.getSubimage((coloumn*W)-W, (row*H)-H, W, H);
		return image;
	}
}
