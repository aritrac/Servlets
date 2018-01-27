import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	private int xCoord;
	private int yCoord;
	private int numNeighbors;
	
	private BufferedImage normal;
	private BufferedImage openTile;
	private BufferedImage BombImage;
	private BufferedImage flag;
	
	private boolean hasBomb;
	private boolean hasOpened;
	private boolean hasFlag;
	
	
	private static int tileWidth = Frame.getFrameWidth()/ World.getWorldWidth();
	private static int tileHeight = Frame.getFrameHeight()/ World.getWorldHeight();
	
	public Tile(int x, int y, BufferedImage normal, BufferedImage bomb, 
			BufferedImage openTile, BufferedImage flag){
		xCoord = x;
		yCoord = y;
		this.normal = normal;
		this.BombImage = bomb;
		this.openTile = openTile;
		this.flag = flag;
	}
	
	public void setNormal(BufferedImage normal){
		this.normal = normal;
	}
	
	public void setOpenedImage(BufferedImage openTile){
		this.openTile = openTile;
	}
	
	public void setImage(BufferedImage x){
		normal = x;
	}
	
	public void setOpened(boolean hasOpened){
		this.hasOpened = hasOpened;
	}
	
	public boolean canOpen(){
		return (hasOpened == false && hasBomb == false && numNeighbors >= 0);
	}

	
	
	
public void draw(Graphics x){
	
	if (hasOpened == false)
	{
		if (hasFlag == true)
	{
		x.drawImage(flag, xCoord * tileWidth, yCoord * tileHeight, null);
	} else { 
		x.drawImage(normal, xCoord * tileWidth, yCoord * tileHeight, null);
	}
	} else { 
		
		if (hasBomb == true) { x.drawImage(BombImage, xCoord * tileWidth, yCoord * tileHeight, null);
	} else {
		x.drawImage(openTile, xCoord * tileWidth, yCoord * tileHeight, null);
		if (numNeighbors > 0 ){
			x.setColor(Color.BLACK);
			x.drawString("" + numNeighbors, xCoord * tileWidth + 7, yCoord * tileHeight + tileHeight - 4);
		}
	}
}
		
	}

public static int getWidth(){
	return tileWidth;
}

public static int getHeight(){
	return tileHeight;
}

public boolean hasBomb() {
	
	return hasBomb;
}

public void setBomb(boolean b) {
	hasBomb = b;
}

public void setNeighbors(int neighbors) {
	numNeighbors = neighbors;
	
}

public int getNeighbors(){
	return numNeighbors;
}

public boolean isOpened(){
	return hasOpened;
}

public boolean hasFlag(){
	boolean x = hasFlag;
	return x;
}

public void placeFlag(){
	
	if (hasFlag == true){
		hasFlag = false;
	} else {
		if (hasOpened == false) { 
			hasFlag = true;
		}
	}
	
}

public void restart(){
	hasFlag = false;
	hasOpened = false;
	hasBomb = false;
}


}
