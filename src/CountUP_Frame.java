import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class CountUP_Frame extends JFrame {

	
	CountUP_Frame(int selected){
		MyMenu menu = new MyMenu(this);
		time_label time =new time_label();
		buttonsPanel ButtonsPanel = new buttonsPanel(time,menu);
		if(selected==1) {
			menu.timer.setText("StopWatch");
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0X150C25));
		this.setSize(700,500);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		

		this.add(time,BorderLayout.NORTH);
		this.add(ButtonsPanel,BorderLayout.SOUTH);
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		
	}
}
