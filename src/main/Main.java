package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("FrameDemo");

	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("wat fijn", SwingConstants.CENTER);
		frame.getContentPane().add(label, BorderLayout.CENTER);

		frame.pack();

		frame.setVisible(true);
	}

}
