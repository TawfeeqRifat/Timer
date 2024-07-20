import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class countDownTime_panel extends JPanel{
	boolean stop=false;
	 boolean reset=false;
	JTextField textField;

	CountDown_Frame jf;
	countDownTime_panel(CountDown_Frame jf){
		this.jf=jf;
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK,0));
		
		textField.setPreferredSize(new Dimension(700,160));
		textField.setBorder(null);
		textField.setCaretColor(Color.white);
		textField.setForeground(Color.white);
		textField.setBackground(new Color(0X150C25));
		textField.setText("00:00:00");
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(new Font(null,Font.BOLD,160) );
		textField.setEditable(true);

		
		
		this.add(textField);
		this.setBounds(0,100,300,300);
		this.setBackground(new Color(0X150C25));
		
	}
	
	public void countDownOp(int h, int m, int s,countDownTime_panel tl) {
		
		
		Timer timer=  new Timer();
		TimerTask st = new TimerTask() {
			 int hr=h;
			 int min=m;
			 int sec=s;
			 
			 
			
			@Override
			public void run() {
				if(!stop) {
					setText(hr,min,sec);
					System.out.println("1.sec="+sec);
					sec--;
					if(sec<0) {
						min--;
						sec=59;
					}
					if(min<0) {
						hr--;
						min=59;
						
					}
					if(hr==-1||(hr==0&&min<=0&&sec==-1)) {
						
						if(hr==-1) {
							finished(1);}
						else {
							finished(0);}
					}
					
					
					System.out.println("2.sec="+sec);
					
					
				}
				if(reset){
					timer.cancel();
					hr=h;min=m;
					sec=s;
					setText(hr,min,sec);
				}
			}
			
			private void finished(int st) {
				
				if(st==1) {
					hr=0;
					min=0;
					sec=0;
				}
				setText(hr,min,sec);
				
				
				tl.stop=true;
				tl.reset=true;
				timer.cancel();
				tl.textField.setCaretColor(Color.white);
			
				
				
				jf.ButtonsPanel.pauseStatus="start";
				jf.ButtonsPanel.pause.setText("START");
				new FinishPopUp();
				System.out.println("Timer finished!");
				
				tl.textField.setEditable(true);
				
				
			}


			private void setText(int hr2, int min2, int sec2) {
				String nowtime=null;
				
				if(sec2<10 && min2<10 && hr2<10) {
					nowtime="0"+hr2+":0"+min2+":0"+sec2;
				}
				else if(min2<10 && hr2<10) {
					nowtime="0"+hr2+":0"+min2+":"+sec2;
				}
				
				else if(sec2<10 && hr2<10) {
					nowtime="0"+hr2+":"+min2+":0"+sec2;
				}
				else if(sec2<10 && min2<10) {
					nowtime=""+hr2+":0"+min2+":0"+sec2;
				}
				else if(hr2<10) {
					nowtime="0"+hr2+":"+min2+":"+sec2;
				}
				else if(min2<10) {
					nowtime=""+hr2+":0"+min2+":"+sec2;
				}
				else if(sec2<10) {
					nowtime=""+hr2+":"+min2+":0"+sec2;
				}
				else {
					nowtime=""+hr2+":"+min2+":"+sec2;
				}
				
				tl.textField.setText(nowtime);
				System.out.println(nowtime);
				
			}
			
			
		};
		
		timer.scheduleAtFixedRate(st,0,1000);
		

	
	}
	

}