package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class buttonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(startView.start.getActionCommand())) {
			view game=new gameView();
			viewFrame.setBasePanel(game);
		}
	}
	
}
