package view;


import java.awt.Dimension;

import javax.swing.JFrame;

public class viewFrame extends JFrame {

	private static view basepanel;
	private static  JFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7224334486299356731L;

	public viewFrame(String title){
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		basepanel=new startView();
		
		frame.add(basepanel);
		frame.pack();

		frame.setVisible(true);
		
	}
	
	public static  void setBasePanel(view type){
		frame.remove(basepanel);
		basepanel=type;
		frame.add(basepanel);
		frame.pack();
	}
	
	public view getBasePanel(){//fult som fan
		return basepanel;
	}
	}

