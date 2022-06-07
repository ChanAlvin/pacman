import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Pacman extends JFrame {
	Control control = new Control(this);
	
	final int BOARD_SIZE = 21;
	int playerC = 0, playerR = 0;
	JPanel panel = new JPanel();
	int[][] map = {
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2}, 
			{2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 2, 2, 0, 0, 2, 0, 2, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 2, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 0, 2, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 0, 0}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 0, 2, 0, 2, 2, 0, 2, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 0, 0}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 0, 2, 2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2, 2, 0, 2}, 
			{2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
			};
	JLabel[][] board = new JLabel[BOARD_SIZE][BOARD_SIZE];
	int name = 0;
	ImageIcon blackTile = new ImageIcon("blackTile.png");
	ImageIcon brownTile = new ImageIcon("brownTile.png");
	ImageIcon whiteTile = new ImageIcon("whiteTile.png");
	ImageIcon blueWall = new ImageIcon("blue.png");
	ImageIcon pacman = new ImageIcon("pacAntRight.png");
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacman frame = new Pacman();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pacman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		FlowLayout layout = new FlowLayout();
		getContentPane().setLayout(layout);
		
		GridLayout layout1 = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		panel.setLayout(layout1);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				board[row][col] = new JLabel();
				if(map[row][col]==0) {
					board[row][col].setIcon(blackTile);
				}
				else if(map[row][col]==1) {
					board[row][col].setIcon(pacman);
					playerR = row;
					playerC = col;
				}
				else if(map[row][col]==2) {
					board[row][col].setIcon(blueWall);
				}
				else if(map[row][col]==3) {
					board[row][col].setIcon(whiteTile);
				}
				panel.add(board[row][col]);
			}
		}
		
		this.add( panel, BorderLayout.CENTER  );
		
		setVisible(true);
		addKeyListener(control);
	}
	
	public void printMap()
	{  // print map to console for debugging
		for (int i = 0; i < board.length; i++ ) 
		{
			for (int j = 0; j < board[0].length; j++ ) 
			{
				System.out.print("  "+map[i][j]);                    

			} 
			System.out.println();
		}
		System.out.println();
	}
	
	public void mapRead() {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				switch (map[row][col]) {
					case 0: 
						board[row][col].setIcon(blackTile);
						break;
					case 1:
						board[row][col].setIcon(pacman);
						break;
					case 2:
						board[row][col].setIcon(blueWall);
						break;
					case 3:
						board[row][col].setIcon(whiteTile);
						break;
						
				}
			}
		}
	}

}