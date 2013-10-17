package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.buttonListener;
import javax.swing.JButton;

public class startView extends view {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1308736395982224027L;
	public static JButton start, load;

	public startView() {
		super("blackjack-06.jpg");
		// TODO Auto-generated constructor stub
		start = new JButton("start");
		load = new JButton("load old table");
		// load button?
		add(start);
		add(load);
		//start.addActionListener(new controller.buttonListener());
		/*
		 * start.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub // e.getActionCommand() if
		 * (e.getActionCommand().equals(start.getActionCommand())) { view
		 * game=new gameView(); viewFrame.setBasePanel(game); }else
		 * if(e.getActionCommand().equals(load.getActionCommand())){
		 * //loadfile() view game=new gameView(); viewFrame.setBasePanel(game);
		 * } } });// nästa rad i startView
		 */

	}

	
	public void addButtonListener(ActionListener l) {
		start.addActionListener(l);
		load.addActionListener(l);
	}
}
