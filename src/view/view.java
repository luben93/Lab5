package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public abstract class view extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4181834050490651494L;
	private BufferedImage image=null;
	private Timer timer;
	private int height,width;
	//protected ArrayList<JButton> button;//lite fult

	public view(String background){
		
		try {
			image =ImageIO.read(new File("donepic/"+background));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
			
		}
	}

	/**
	 * @Override
	 */
	public void startAnimation() {
		// Create, and start, the timer-object responsible for the animation
		timer = new Timer(10, this); // Signal every 10 milliseconds
										// (actionPerformed is called)
		timer.start();
	}

	/**
	 * @Override
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//setSize(width,height);
		repaint();

	}
	


	/**
	 * @Override
	 */
	@Override
	public void paintComponent(Graphics g) {

		
		g.drawImage(image, 0, 0, getSize().width, getSize().height, this);
		
	}

	/**
	 * @Override
	 */
	public void addButtonListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}
}
