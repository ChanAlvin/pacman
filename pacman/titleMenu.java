
/**
 * --a short description here--
 * 
 * modified     20220531
 * date         20220531
 * @filename    HaevinChess.java
 * @author      
 * @version     0.0.1
 * @see         A21 - Culminating Project
 */

/**	Patch Notes:
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class titleMenu extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					titleMenu frame = new titleMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//ImageIcon image;
	}

	public titleMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 448);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("pacmanlogonew.png"));
		JLabel lbl1 = new JLabel(image1);
		lbl1.setBackground(Color.BLACK);
		//getContentPane().add(lbl1);
		lbl1.setBounds(31, 22, 440, 115);
		contentPane.add(lbl1);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(51, 169, 103, 91);
		contentPane.add(btnPlay);
		btnPlay.setBackground((new Color(59, 89, 182)));;
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setFocusPainted(false);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnIn = new JButton("Instructions");
		btnIn.setBounds(51, 258, 322, 78);
		contentPane.add(btnIn);
		btnIn.setBackground((new Color(59, 89, 182)));;
		btnIn.setForeground(Color.WHITE);
		btnIn.setFocusPainted(false);
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(368, 258, 103, 78);
		contentPane.add(btnExit);
		btnExit.setBackground((new Color(59, 89, 182)));;
		btnExit.setForeground(Color.WHITE);
		btnExit.setFocusPainted(false);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel name = new JLabel("By: Alvin, Hammad, Oscar");
		name.setForeground(new Color(255, 255, 0));
		name.setBackground(new Color(255, 255, 0));
		name.setBounds(222, 197, 165, 14);
		contentPane.add(name);
		name.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("v0.0.1");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(10, 384, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
				
			}
		});
	}
}

/** Developer Notes:
*	
*/
