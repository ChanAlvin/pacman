import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Pacman extends JFrame implements ActionListener{
	private JTextField txtScore;
	Control control = new Control(this);
	AI ai = new AI(this);
	
	final int BOARD_SIZE = 21;
	int playerC = 0, playerR = 0;
	int redC = 0, redR = 0;
	int greenC = 0, greenR = 0;
	int purpleC = 0, purpleR = 0;
	int total = 0;
	JPanel panel = new JPanel();
	Timer timer; 
	int timerCounter = 0;
	int[][] map = {
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2}, 
			{2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{7, 7, 7, 7, 2, 0, 2, 0, 0, 2, 2, 2, 0, 0, 2, 0, 2, 7, 7, 7, 7}, 
			{7, 7, 7, 7, 2, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 0, 2, 7, 7, 7, 7}, 
			{7, 7, 7, 7, 2, 0, 2, 0, 0, 2, 7, 2, 0, 0, 2, 0, 2, 7, 7, 7, 7}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 7, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{7, 7, 7, 7, 7, 0, 0, 0, 2, 4, 5, 6, 2, 0, 0, 0, 7, 7, 7, 7, 7}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 7, 2, 7, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{7, 7, 7, 7, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 7, 7, 7, 7}, 
			{7, 7, 7, 7, 2, 0, 2, 2, 0, 2, 0, 2, 0, 2, 2, 0, 2, 7, 7, 7, 7}, 
			{7, 7, 7, 7, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 7, 7, 7, 7}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 0, 2, 2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2, 2, 0, 2}, 
			{2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
			};
	int[][] ghostMap = {
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
			{0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 5, 6, 2, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 0, 2, 0, 2, 2, 0, 2, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 0, 0}, 
			{2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 2, 2, 2, 2}, 
			{2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2}, 
			{2, 0, 2, 2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2, 2, 0, 2}, 
			{2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
			};
	JLabel[][] board = new JLabel[BOARD_SIZE][BOARD_SIZE];
	ImageIcon blackTile = new ImageIcon("blackTile.png");
	ImageIcon brownTile = new ImageIcon("brownTile.png");
	ImageIcon whiteTile = new ImageIcon("whiteTile.png");
	ImageIcon blueWall = new ImageIcon("blue.png");
	ImageIcon pacman = new ImageIcon("pacAntRight.png");
	ImageIcon redBee = new ImageIcon("redBeeUp.png");
	ImageIcon greenBee = new ImageIcon("greenBeeUp.png");
	ImageIcon purpleBee = new ImageIcon("purpleBeeUp.png");
	ImageIcon blackTileDot = new ImageIcon("blackTileDot.png");
	
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
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		FlowLayout layout = new FlowLayout();
		getContentPane().setLayout(layout);
		
		GridLayout layout1 = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		GridLayout layout2 = new GridLayout(3,2);
		
		panel.setLayout(layout1);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				board[row][col] = new JLabel();
				if(map[row][col]==0) {
					board[row][col].setIcon(blackTileDot);
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
				else if(map[row][col]==4) {
					board[row][col].setIcon(redBee);
					redR = row;
					redC = col;
				}
				else if(map[row][col]==5) {
					board[row][col].setIcon(greenBee);
					greenR = row;
					greenC = col;
				}
				else if(map[row][col]==6) {
					board[row][col].setIcon(purpleBee);
					purpleR = row;
					purpleC = col;
				}
				else if(map[row][col]==7) {
					board[row][col].setIcon(blackTile);
				}
				panel.add(board[row][col]);
			}
		};
		
		this.add( panel, BorderLayout.CENTER  );
		this.add( panel, BorderLayout.SOUTH  );
		timer = new Timer(30, this);
		timer.start(); // start the time
		setVisible(true);
		addKeyListener(control);
		timer.addActionListener(ai);
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
						board[row][col].setIcon(blackTileDot);
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
					case 4:
						board[row][col].setIcon(redBee);
						break;
					case 5:
						board[row][col].setIcon(greenBee);
						break;
					case 6:
						board[row][col].setIcon(purpleBee);
						break;
					case 7:
						board[row][col].setIcon(blackTile);
						break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == timer ) { 
			 
			timerCounter++; 
			timerCounter = timerCounter % 1000000; 

			if (timerCounter % 1 == 0) {
				ai.greenBee();
				ai.redBee();
				ai.purpleBee(); 
			}; 
		}
	}
}