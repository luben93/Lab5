package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class Controller {
	private viewFrame frame;

	public Controller() {
		frame = new viewFrame("jackBlack");
		 frame.getBasePanel().addButtonListener(new buttonListener()); 
		//ska controller ha actionlistner?? (det är ett helvete att göra med olika package)
		
	}
		class buttonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand()=="start") {
					view game=new gameView();
					viewFrame.setBasePanel(game);
				}
			}
			
		}

	
}
