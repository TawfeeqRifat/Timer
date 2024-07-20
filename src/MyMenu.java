import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuBar implements ActionListener{
	JMenu timer;
	JMenuItem countUp;
	JMenuItem countDown;
	JFrame f;
	CountUP_Frame stopwatch;
	MyMenu(JFrame f){
		
		this.f= f;
		timer = new JMenu("Timer");
		countUp = new JMenuItem("Stop Watch");
		countDown= new JMenuItem("CountDown Timer");
		timer.add(countUp);
		timer.add(countDown);
		this.add(timer);
		this.setBackground(new Color(0X150C22));
		timer.setForeground(Color.white);
		
		countUp.addActionListener(this);
		countDown.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==countUp) {
			f.dispose();
			new CountUP_Frame(1);
			
			
			
			
		}
		else if(e.getSource()==countDown) {
			f.dispose();
			new CountDown_Frame();
			
		}
	}
	
	

}
