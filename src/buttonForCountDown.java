

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class buttonForCountDown extends JPanel implements ActionListener{
	countDownTime_panel tl;
	JButton pause;
	JButton reset;
	String pauseStatus ="start";
	MyMenu menu;
	String enteredTime;
	buttonForCountDown(countDownTime_panel tl,MyMenu menu) {
		
		
		this.tl= tl;
		this.menu=menu;
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,50,135));
		this.setBackground( new Color(0X150C25));
		
		
		this.setSize(350,200);
		
		
		pause = new JButton();
		
		pause.setText("START");
		pause.setBackground(null);
		pause.setForeground(Color.WHITE);
		pause.setBorder(null);
		pause.setFont(new Font(null,Font.PLAIN,40));
		pause.setIconTextGap(5);
		pause.setFocusable(false);
		pause.setHorizontalTextPosition(JButton.CENTER);
		pause.setVerticalTextPosition(JButton.BOTTOM);
		//pause.setHorizontalAlignment(JButton.CENTER);
		//pause.setVerticalAlignment(JButton.CENTER);
		pause.addActionListener(this);
		
		reset = new JButton("RESET");
		reset.setBackground(null);
		reset.setForeground(Color.WHITE);
		reset.setBorder(null);
		reset.setFont(new Font(null,Font.PLAIN,40));
		reset.setFocusable(false);
		reset.setHorizontalTextPosition(JButton.CENTER);
		reset.setHorizontalAlignment(JButton.CENTER);
		reset.setVerticalAlignment(JButton.CENTER);
		reset.addActionListener(this);
		this.add(reset);
		this.add(pause);
		//pause.addActionListener((ActionListener) this);
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pause) {
			if(pauseStatus.equals("pause")) {
					tl.stop=true;
					tl.textField.setEditable(true);
					tl.textField.setCaretColor(Color.white);
					
					getTimeVal();
					System.out.println("pause clicked!");
					pause.setText("RESUME");
					pauseStatus="resume";
			}
			else if(pauseStatus.equals("resume")) {
					 	tl.stop=false;
					 	tl.textField.setCaretColor(getBackground());
					 	
						tl.textField.setEditable(false);
						System.out.println("resume clicked!");
						pause.setText("PAUSE");
						pauseStatus="pause";
			}
			else if(pauseStatus.equals("start")) {
			
				tl.textField.setEditable(false);
				
				getTimeVal();
				
				tl.stop=false;
				tl.reset=false;
				tl.textField.setCaretColor(getBackground());
				
				pauseStatus="pause";
				pause.setText("PAUSE");
				
				
				
				System.out.println("timer stated");
			}
		}
		if(e.getSource()==reset) {
			System.out.println("reset clicked");
			tl.stop=true;
			tl.reset=true;
			tl.textField.setCaretColor(Color.white);
			
			pauseStatus="start";
			pause.setText("START");
			
		}
	}


	private void getTimeVal() {
		enteredTime = tl.textField.getText();
		
		//calculation for time
		try {
		int r= (int) (enteredTime.charAt(0));
		int hr=(r-48)*10;
	
		r= enteredTime.charAt(1);
		hr+=(r-48); 
		
		
		r= (int) (enteredTime.charAt(3) );
		int min=(r-48)*10;
		r= enteredTime.charAt(4);
		min+=(r-48); 
		
		r= (int) (enteredTime.charAt(6) );
		int sec=(r-48)*10;
		r= enteredTime.charAt(7);
		sec+=(r-48); 
		
		while(sec>59) {
			min++;
			sec-=60;
		}
		while(min>59) {
			hr++;
			min-=60;
		}
		
		System.out.println("Entered Time:"+hr+":"+min+":"+sec+" "+enteredTime);
		
		//calling the timer
		tl.countDownOp(hr,min,sec,tl);
		}
		catch(Exception e) {
			System.out.println("Entered Text may be out of bounds");
			tl.textField.setEditable(true);
			
			
		}
		
	}

}

