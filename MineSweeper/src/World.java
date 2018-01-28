import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class World {

	private static int worldWidth = 20;
	private static int worldHeight = 20;
	private Random ran = new Random();

	private Tile[][] tileArr;

	private final int NUM_BOMBS = 35;

	private boolean isFinished;
	private boolean lost;

	private BufferedImage bomb = LoadImages.scale(
			LoadImages.loadImage("bomb.png"), Tile.getWidth(),
			Tile.getHeight());
	private BufferedImage flag = LoadImages.scale(
			LoadImages.loadImage("flag.png"), Tile.getWidth(),
			Tile.getHeight());
	private BufferedImage raised = LoadImages.scale(
			LoadImages.loadImage("normal.png"), Tile.getWidth(),
			Tile.getHeight());
	private BufferedImage pressed = LoadImages.scale(
			LoadImages.loadImage("pressed.png"), Tile.getWidth(),
			Tile.getHeight());

	private LinkedList<String> index;

	private Map<LinkedList<String>, Boolean> revealed;

	public World() {

		tileArr = new Tile[worldWidth][worldHeight];
		revealed = new HashMap<LinkedList<String>, Boolean>();
		index = new LinkedList<String>();
		for (int x = 0; x <= worldWidth - 1; x++) {
			for (int y = 0; y <= worldHeight - 1; y++) {
				tileArr[x][y] = new Tile(x, y, raised, bomb, pressed, flag);
			}
		}
		reset();
	}

	// After placing bombs calculate how many neighbors
	// of each tile are bombs.
	private void setNumbers() {
		int w = worldWidth;
		int h = worldHeight;
		for (int x = 0; x <= w - 1; x++) {
			for (int y = 0; y <= h - 1; y++) {
				int numbers = 0;

				int right = x + 1;
				int left = x - 1;
				int up = y - 1;
				int down = y + 1;

				if (left < 0) {
					left = 0;
				}
				if (up < 0) {
					up = 0;
				}
				if (down >= h) {
					down = h - 1;
				}
				if (right >= w) {
					right = w - 1;
				}

				for (int m = left; m <= right; m++) {
					for (int n = up; n <= down; n++) {
						if (!(m == x && n == y)) {
							if (tileArr[m][n].hasBomb()) {
								numbers++;
							}
						}
					}
				}
				tileArr[x][y].setNeighbors(numbers);
			}

		}

	}

	// Place all 35 bombs, call helper method.
	private void placeBombs() {
		for (int i = 0; i < NUM_BOMBS; i++) {
			placeBomb();
		}
	}

	// Use a random stream to place bomb.
	// Also add whether or not the tile is
	// a bomb to the map.
	private void placeBomb() {
		int x = ran.nextInt(worldWidth);
		int y = ran.nextInt(worldHeight);

		if (!tileArr[x][y].hasBomb()) {
			tileArr[x][y].setBomb(true);

			index.add("Index" + x + "," + y); // ADDED COMPONENT
			revealed.put(index, true);
			index.removeFirst();

		} else {
			index.add("Index" + x + "," + y); // ADDED COMPONENT
			revealed.put(index, false);
			index.removeFirst();
			placeBomb();
		}

	}

	// Renders the tiles and draws on screen
	// if a user has won or lost.
	public void draw(Graphics w) {

		for (int x = 0; x < worldWidth; x++) {
			for (int y = 0; y < worldHeight; y++) {
				tileArr[x][y].draw(w);
			}
		}
		if (lost) {
			w.drawString("YOU LOST", 100, 200);
			w.drawString("Press R key to start again!", 100, 400);
		} else if (isFinished) {
			w.drawString("YOU WIN.", 100, 200);
		}

	}

	// Check to see if the game has been completed
	// if the user has won or lost.
	private void gameFinished() {

		isFinished = true;
		outer: for (int x = 0; x < worldWidth; x++) {
			for (int y = 0; y < worldHeight; y++) {
				if (!(tileArr[x][y].isOpened() || (tileArr[x][y].hasBomb() && tileArr[x][y]
						.hasFlag()))) {
					isFinished = false;
					break outer;
				}
			}
		}
	}

	public static int getWorldWidth() {
		return worldWidth;
	}

	public static int getWorldHeight() {
		return worldHeight;
	}

	public void clickedL(int x, int y) {

		if (lost == false && isFinished == false) {
			int tileX = x / Tile.getWidth();
			int tileY = y / Tile.getHeight();

			if (tileArr[tileX][tileY].hasFlag() == false) {
				tileArr[tileX][tileY].setOpened(true);
				if (tileArr[tileX][tileY].hasBomb()) {
					lost = true;
				} else {
					if (tileArr[tileX][tileY].getNeighbors() == 0) {

						openRec(tileX, tileY);
					}
				}
				gameFinished();

			}
		}
	}

	// Place flag if clicked right, check if
	// the game is done.
	public void clickedR(int x, int y) {

		if (lost == false && isFinished == false) {
			tileArr[x / Tile.getWidth()][y / Tile.getHeight()].placeFlag();
			gameFinished();
		}
	}

	// Recursive method to open empty squares.
	public void openRec(int x, int y) {
		tileArr[x][y].setOpened(true);

		if (tileArr[x][y].getNeighbors() == 0) {
			int left = x - 1;
			int right = x + 1;
			int up = y - 1;
			int down = y + 1;
			// same row
			if (left >= 0 && tileArr[left][y].canOpen())
				openRec(left, y);
			if (right < worldWidth && tileArr[right][y].canOpen())
				openRec(right, y);

			// row above
			if (left >= 0 && up >= 0 && tileArr[left][up].canOpen())
				openRec(left, up);
			if (up >= 0 && tileArr[x][up].canOpen())
				openRec(x, up);
			if (right < worldWidth && up >= 0 && tileArr[right][up].canOpen())
				openRec(right, up);

			// row below
			if (left >= 0 && down < worldHeight
					&& tileArr[left][down].canOpen())
				openRec(left, down);
			if (down < worldHeight && tileArr[x][down].canOpen())
				openRec(x, down);
			if (right < worldWidth && down < worldHeight
					&& tileArr[right][down].canOpen())
				openRec(right, down);
		}
	}

	// Reset booleans to default, reset each tile.
	public void reset() {
		for (int x = 0; x < worldWidth; x++) {
			for (int y = 0; y < worldHeight; y++) {
				tileArr[x][y].restart();
			}
		}
		lost = false;
		isFinished = false;
		placeBombs();
		setNumbers();
	}
}
