import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class time_label extends JLabel {

	
	boolean stop=false;
	boolean reset=false;
	time_label(){
		this.setText("00:00:00");
		this.setFont(new Font(null,Font.BOLD,160));
		//this.setSize(500, 500);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setVerticalTextPosition(CENTER);
		this.setBounds(0,100,300,300);
		this.setForeground(new Color(0XFFFFFF));
		
		}
	
	public void start_countUpTimer(time_label l) {
		
		
		
	
		Timer timer=  new Timer();
		TimerTask st = new TimerTask() {
			 int hr=0;
			 int min=0;
			 int sec=0;
			 int hrdigit=1;
			 
			 int prevDigit =0;
			 int digit=0;
			
			@Override
			public void run() {
				if(!stop) {
					setText(hr,min,sec);
					sec++;
					if(sec>59) {
						min++;
						sec=0;
					}
					if(min>59) {
						hr++;
						min=0;
						
					}
					prevDigit=digit;
					digit=0;
					int temp = hr;
					while(temp>0) {
						temp= temp/10;
						digit++;
					}
					
					//for clock going more than certain hours
					if(prevDigit!=digit && digit>2) {
						
						label_changesize(hrdigit);
						hrdigit++;
					}
					
					
				}
				else if(reset){
					timer.cancel();
					hr=0;min=0;
					sec=0;
					setText(hr,min,sec);
				}
			}

			private void label_changesize(int idigit) {
				
				l.setFont(new Font(null,Font.BOLD,(160-22*(idigit))));
				
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
				
				l.setText(nowtime);
				
			}
		};
		
		timer.scheduleAtFixedRate(st,0,1000);
		
		
		
		
	}
}
