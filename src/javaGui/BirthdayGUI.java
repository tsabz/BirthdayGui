package javaGui;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BirthdayGUI implements ActionListener {
	
	private int ageCount = 0;
	private JFrame appFrame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	private JTextField textField;
	
	public BirthdayGUI() {
//		Frame
		appFrame = new JFrame();
		
//		Panel
		panel = new JPanel();
		
//		textField
		textField = new JTextField(20);
		
//		Button
		button = new JButton("Calculate Age");
		button.addActionListener(this);
		
//		Label
		label = new JLabel("Your Age is: ");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(textField);
		panel.add(button); // adds button to panel	
		panel.add(label); // adds label to panel
		
		appFrame.add(panel, BorderLayout.CENTER);
		appFrame.setSize(400, 250);
		appFrame.setTitle("Age Calculator");
		appFrame.pack();
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		appFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new BirthdayGUI(); // initialize constructor 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText(textField.getText());
		
		String date = label.getText();
		
		label.setText("Your Age is: " + date);
		
	}

}

//References

// https://introcs.cs.princeton.edu/java/15inout/GUI.java.html
// https://www.youtube.com/watch?v=dOvYkzKfsdg
