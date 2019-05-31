package ocv;

import com.github.sarxos.webcam.Webcam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TrashDemo {
	public static void main(String[] args) {
		
		BufferedImage img1 = null;
		
		//finds default web cam on computer.
		Webcam webcam = Webcam.getDefault();
		webcam.open();

		// Tries to take image of what's in front of the webcam.
		try {
			ImageIO.write(webcam.getImage(), "JPG", new File("hello-world.jpg"));
			 //img1 = ImageIO.read(new File("IMG/tea.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}