import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class CountDown_Frame extends JFrame{
	private static final String JLayerPane = null;
	buttonForCountDown ButtonsPanel;

	CountDown_Frame(){
		MyMenu menu =new MyMenu(this);
		menu.timer.setText("CountDown Timer");
		
	
		countDownTime_panel timer_val = new countDownTime_panel(this);
		ButtonsPanel = new buttonForCountDown(timer_val,menu);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0X150C25));
		this.setSize(700,500);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		this.add(timer_val,BorderLayout.NORTH);
		
		

		this.add(ButtonsPanel,BorderLayout.SOUTH);
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		
	}
}
