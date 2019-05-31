/*
 * Author: Michael Rahe
 * 05/30/2019
 */

package ocv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {

	public static void main(String[] args) throws IOException {
		BufferedImage img1 = ImageIO.read(new File("IMG/tea.jpg"));

		double percentCan = getDifferencePercent(img1, ReferenceImages.aluminumCan);
		double percentBottle = getDifferencePercent(img1, ReferenceImages.platicBottle);
		double percentPaper = getDifferencePercent(img1, ReferenceImages.paper);

		System.out.println("diff percentfor can: " + percentCan);
		System.out.println("diff percent for bottle: " + percentBottle);
		System.out.println("diff percent for paper: " + percentPaper);
		mostlike(percentCan, percentBottle, percentPaper);
	}

	private static double getDifferencePercent(BufferedImage img1, BufferedImage img2) {
		int width = img1.getWidth();
		int height = img1.getHeight();
		int width2 = img2.getWidth();
		int height2 = img2.getHeight();
		if (width != width2 || height != height2) {
			throw new IllegalArgumentException(String.format(
					"Images must have the same dimensions: (%d,%d) vs. (%d,%d)", width, height, width2, height2));
		}

		long diff = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				diff += pixelDiff(img1.getRGB(x, y), img2.getRGB(x, y));
			}
		}
		long maxDiff = 3L * 255 * width * height;

		return 100.0 * diff / maxDiff;
	}

	private static int pixelDiff(int rgb1, int rgb2) {
		int r1 = (rgb1 >> 16) & 0xff;
		int g1 = (rgb1 >> 8) & 0xff;
		int b1 = rgb1 & 0xff;
		int r2 = (rgb2 >> 16) & 0xff;
		int g2 = (rgb2 >> 8) & 0xff;
		int b2 = rgb2 & 0xff;
		return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
	}

	private static void mostlike(double percentCan, double percentbottle, double percentPaper) {
		if (percentCan < percentbottle && percentCan < percentPaper) {
			System.out.println("The object is most like an aluminum can.");

		} else if ((percentPaper < percentbottle && percentPaper < percentCan)) {
			System.out.println("The object is most like a pice of paper.");
		} else {
			System.out.println("The object is most like a plastic bottle.");

		}
	}
}
