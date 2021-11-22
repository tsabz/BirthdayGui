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
import java.time.LocalDate;
import java.time.Period;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

//		Show input example to user	
		JLabel dateExample = new JLabel();
		dateExample.setText("<html><p>Date input example: dd/MM/yyyy </p></html>");
		
//		textField
		textField = new JTextField(20);
		
//		Button
		button = new JButton("Calculate Age");
		button.addActionListener(this);
		
//		Label
		label = new JLabel("Your Age is: ");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(dateExample);
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
		String action = e.getActionCommand();
		if (action.equals("Calculate Age")) {
			
//			retrieves text inputed into textField
			label.setText(textField.getText());
			
//			assigns text to textBday
			String textBday = label.getText();
			
//			parses text date to an actual date
			Date birthDate = null;
			try {
				birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(textBday);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			assign variable to today's date
			LocalDate today = LocalDate.now();
			
//			Calculates period between birthDate and today
			
			label.setText("Your Age is: " + birthDate + "\n" + today);
			
		}
	}

}

//References

// https://introcs.cs.princeton.edu/java/15inout/GUI.java.html
// https://www.youtube.com/watch?v=dOvYkzKfsdg
