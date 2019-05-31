package ocv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReferenceImages {

	public static BufferedImage aluminumCan = null;
	public static BufferedImage platicBottle = null;
	public static BufferedImage paper = null;
	

	static {
		try {
			aluminumCan = javax.imageio.ImageIO.read(new File("IMG/brisk.jpg")); 
			platicBottle = javax.imageio.ImageIO.read(new File("IMG/platicBottle.jpg"));
			paper = javax.imageio.ImageIO.read(new File("IMG/paper.jpg"));
		} catch (IOException ex) {
		}
	}

}
