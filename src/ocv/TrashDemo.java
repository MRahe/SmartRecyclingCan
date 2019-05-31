/*
 * Author: Michael Rahe
 * 05/30/2019
 */

package ocv;

import com.github.sarxos.webcam.Webcam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TrashDemo {
	public static void main(String[] args) throws IOException  {
		
		BufferedImage img1 = null;
		
		//finds default web cam on computer.
		Webcam webcam = Webcam.getDefault();
		webcam.open();

		// Tries to take image of what's in front of the webcam.
	
			ImageIO.write(webcam.getImage(), "JPG", new File("hello-world.jpg"));
			 //img1 = ImageIO.read(new File("IMG/tea.jpg"));
	}
}
