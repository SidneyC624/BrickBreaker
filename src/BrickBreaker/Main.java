package BrickBreaker;

import java.awt.Dimension;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Gameplay gamePlay = new Gameplay();
		
		frame.getContentPane().setPreferredSize(new Dimension(695,558));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Brick Breaker");
		frame.add(gamePlay);
		frame.setVisible(true);
	}

}
