package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.Highlighter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
public class Main {

	public static void main(String[] args) {
		
//		main frame
		JFrame frame = new JFrame();
		
//		configuration
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Text Compare");
		frame.setSize(new Dimension(800, 800));
		Image icon = Toolkit.getDefaultToolkit().getImage("logo.PNG");
		frame.setIconImage(icon);
		
		
		JPanel panel;
		JLabel lblTitle;
		JLabel lblVersionOne;
		JTextArea txtVersionOne;
		JLabel lblVersionTwo;
		JTextArea txtVersionTwo;
		JButton btnCompare;
		ActionListener compare;
		JLabel comment;
		
//		declaring variables
		lblTitle = new JLabel();
		lblVersionOne = new JLabel();
		txtVersionOne = new JTextArea();
		lblVersionTwo = new JLabel();
		txtVersionTwo = new JTextArea();
		panel = new JPanel();
		btnCompare = new JButton();
		comment = new JLabel();
		
//		panel configuration
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(600,600));
		
//		grid bag constraints
		GridBagConstraints constraints = new GridBagConstraints();
		Insets i = new Insets(10,10,20,10);
		
//		title
		lblTitle.setText("Text Compare");
		constraints.insets = i;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
//		constraints.gridwidth = 2;
		panel.add(lblTitle, constraints);
		
//		version one text area
		lblVersionOne.setText("Version One");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(lblVersionOne, constraints);
		
		txtVersionOne.setMaximumSize(new Dimension(250,250));
		txtVersionOne.setMinimumSize(new Dimension(200,200));
		txtVersionOne.setPreferredSize(new Dimension(200,200));
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(txtVersionOne, constraints);
		
//		version two text area
		lblVersionTwo.setText("Version Two");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(lblVersionTwo, constraints);
		
		txtVersionTwo.setMaximumSize(new Dimension(250,250));
		txtVersionTwo.setMinimumSize(new Dimension(200,200));
		txtVersionTwo.setPreferredSize(new Dimension(200,200));
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 2;
		panel.add(txtVersionTwo, constraints);
		
		
		btnCompare.setText("Compare");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 3;
		panel.add(btnCompare, constraints);

		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 4;
		panel.add(comment, constraints);
		
		Highlighter highlighter = txtVersionOne.getHighlighter();
		HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
		compare = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String versionOne = txtVersionOne.getText();
				String versionTwo = txtVersionTwo.getText();
				
				if (versionOne.equals(versionTwo)) {
					comment.setText("Same!!");
//					int p0 = versionOne.indexOf("one");
//					int p1 = p0 + "world".length();
//					highlighter.addHighlight(p0, p1, painter);
////					JOptionPane.showMessageDialog(null, new JScrollPane(txtVersionOne));
				}
				else {
					comment.setText("Not Same!!");
				}
				
			}
			
		};
		

		btnCompare.addActionListener(compare);
		
//		Panel panel = new Panel();
		frame.add(panel);
		
//		set the frame to visible
		frame.setVisible(true);


	}

}
