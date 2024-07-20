import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FinishPopUp extends JFrame implements ActionListener {
	JLabel label;
	JButton button;
	
	FinishPopUp(){
		label = new JLabel();
		button = new JButton();
		
		label.setText("TIME IS UP!!");
		label.setForeground(Color.white);
		label.setFont(new Font(null,Font.BOLD,50));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
	
	
		
		button.setText("OK");
		button.setForeground(Color.white);
		button.setBackground(new Color(0X150C35));
		button.setForeground(Color.WHITE);
		button.setBorder(null);
		button.setFont(new Font(null,Font.PLAIN,35));
		button.setFocusable(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0X150C20));
		this.setSize(350,250);
		//this.setResizable(false);
		this.setLayout(new GridLayout(2,1,10,100));
		
		this.add(label);
	
		this.add(button);
		this.setVisible(true);
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			this.dispose();
			}
	}
	
}
