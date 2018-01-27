import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


//Simple class that reads and puts in the files, the 4 minesweeper pictures.
class LoadImages {

	public static BufferedImage loadImage(String path){
		System.out.println(path);
		try {
			return ImageIO.read(LoadImages.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage scale(BufferedImage input, int width, int height){
		BufferedImage scaled = new BufferedImage(width, height, input.getType());
		Graphics g = scaled.getGraphics();
		g.drawImage(input, 0, 0, width, height, null);
		g.dispose();
		return scaled;
	}
	
}
