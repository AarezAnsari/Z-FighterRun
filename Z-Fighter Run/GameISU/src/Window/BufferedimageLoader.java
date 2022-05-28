/*Author: Aarez Ansari
 * Date: Jan 16, 2020
 * Purpose: The purpose of this class is to access the png photos that are stores in the resources folder
 * 
 * */
package Window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
//This class is used to load our images from resources folder
public class BufferedimageLoader {

	private BufferedImage IMAGE;
	//This method executes the process of loading our image
	public BufferedImage loadImage(String path) {
		//Surrounding image with try and catch to avoid errors
		try {
			//Getting the image from the resources folder
			IMAGE = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		return IMAGE;
	}
	
	
}
