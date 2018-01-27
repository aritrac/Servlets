import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements MouseListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private static int frameWidth = 800;
	private static int frameHeight = 800;
	private Screen myScreen;
	private World world;
	private int insetLeft;
	private int insetTop;
	private int insetBottom;

	private Font font;

	// creates a new Frame.
	// This frame should not be resizable.
	public Frame() {

		super("MINESWEEPER");
		world = new World();
		myScreen = new Screen();
		add(myScreen);
		setResizable(false);

		addMouseListener(this);
		addKeyListener(this);

		pack();
		insetLeft = getInsets().left;
		insetTop = getInsets().top;
		insetBottom = getInsets().bottom;
		setSize(frameWidth + insetLeft + getInsets().right, frameHeight
				+ insetBottom + insetTop);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		font = new Font("Arial", 0, 30);
	}

	class Screen extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics x) {
			x.setFont(font);
			world.draw(x);
		}
	}

	public static int getFrameWidth() {
		return frameWidth;
	}

	public static int getFrameHeight() {
		return frameHeight;
	}

	@Override
	public void mouseClicked(MouseEvent a) {

	}

	@Override
	public void mouseEntered(MouseEvent a) {

	}

	@Override
	public void mouseExited(MouseEvent a) {

	}

	@Override
	public void mousePressed(MouseEvent a) {

	}

	@Override
	// Button 1 is right click, Button 3 is left click.
	public void mouseReleased(MouseEvent a) {
		int x = a.getX();
		int y = a.getY();
		int button = a.getButton();
		if (button == 1) {
			world.clickedL(x - insetLeft, y - insetTop);
		} else if (button == 3) {
			world.clickedR(x - insetLeft, y - insetTop);
		}

		myScreen.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	// Press R TO RESET THIS GAME, start over.
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_R) {
			world.reset();
			myScreen.repaint();
		}

	}

	public World getWorld() {
		World x = world;
		return x;

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
