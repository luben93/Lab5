package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameView extends view {

	final static boolean shouldFill = true;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1630919905574799437L;
	private JPanel left, middle, bottom, rigth;

	public gameView() {
		super("bg1.jpg");
		setPreferredSize(new Dimension(500, 500));
		//this.setLayout(new GridBagLayout());
		//addComponentsToPaneGrid();
		setLayout(new BorderLayout());
		addComponentsToPaneBorder(this);// no panel on panel action :(
		

	}

	public void addComponentsToPaneBorder(Container pane) {

		middle = new JPanel();
		middle.setBackground(Color.blue);
		middle.setSize((int)(pane.getHeight()*0.7),(int)(pane.getWidth()*0.6));
		pane.add(middle, BorderLayout.CENTER);

		left = new JPanel();
		left.setBackground(Color.black);
		middle.setSize((int)(pane.getWidth()*0.2),pane.getHeight());
		pane.add(left, BorderLayout.LINE_START);

		rigth = new JPanel();
		//middle.setSize((int)(pane.getWidth()*0.2),pane.getHeight());
		middle.setSize(new Dimension((int)(pane.getWidth()*0.2),pane.getHeight()));
		//middle.setBackground(Color.OPAQUE);
		pane.add(rigth, BorderLayout.PAGE_END);

		bottom = new JPanel();
		middle.setSize(pane.getWidth(),(int)(pane.getHeight()*0.2));
		pane.add(bottom, BorderLayout.LINE_END);
	}

	public void addComponentsToPaneGrid() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		left = new JPanel();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_START;

		c.ipady = 20;
		c.gridx = 0;
		c.gridy = 0;
		add(left, c);

		middle = new JPanel();
		middle.setBackground(Color.black);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_START;

		c.weightx = 0.5;
		c.ipady = 20;
		c.gridx = 1;
		c.gridy = 0;
		add(middle, c);

		rigth = new JPanel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_START;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(rigth, c);

		bottom = new JPanel();		
		bottom.setBackground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 0;
		c.gridy = 1;
		add(bottom, c);

	}
}
