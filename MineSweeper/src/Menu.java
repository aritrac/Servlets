import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Menu extends JFrame implements MouseListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private static int frameWidth = 800;
	private static int frameHeight = 800;
	private Screen myScreen;
	private int insetLeft;
	private int insetTop;

	//creates a new Frame.
	//This frame should not be resizable.
	public Menu(){
		
	
		super("MINESWEEPER");
		myScreen = new Screen();
		add(myScreen);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
		addKeyListener(this);
		pack();
		insetLeft = getInsets().left;
        insetTop = getInsets().top;
        setSize(frameWidth + insetLeft + getInsets().right, frameHeight + getInsets().bottom + insetTop);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//Draw the components of the screen, call
	//helper method.
	class Screen extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override 
		public void paintComponent(Graphics x){
			render(x);
		}
	}

	//Draw out the instructions of the game.
	public void render(Graphics g){
		Font fnt = new Font("Arial", Font.BOLD, 40);
		g.setFont(fnt);
		g.setColor(Color.RED);
		g.drawString("ARISWEEPER", 100, 100);
		Font fnt1 = new Font("Georgia", Font.HANGING_BASELINE, 30);
		g.setFont(fnt1);
		g.drawString("Left click to press a tile.", 100, 200);
		g.drawString("Right click to place a flag.", 100, 230);
		g.drawString("Right click again to remove a flag.", 100, 260);
		g.drawString("There are 35 mines hidden on the board.", 100, 290);
		g.drawString("If you expose a mine, YOU LOSE.", 100, 320);
		g.drawString("Your goal is to correctly place all flags", 100, 350);
		g.drawString("Press R to reset the board.", 100, 400);
		g.drawString("CLICK ANYWHERE TO START", 100, 440);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	//Check to see if the mouse has been clicked
	//anywhere on the frame.
	@Override
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		if (button == 1) {
			new Frame();
		}
	}
	
	public static void main(String[] args){
		new Menu();
	}
}
