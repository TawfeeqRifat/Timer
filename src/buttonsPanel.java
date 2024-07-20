import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class buttonsPanel extends JPanel implements ActionListener{
	time_label tl;
	JButton pause;
	JButton reset;
	String pauseStatus ="start";
	MyMenu menu;
	buttonsPanel(time_label tl,MyMenu menu) {
		//ImageIcon pauseIcon= new ImageIcon("pause1.png");
		
		
		//pause.setText("PAUSE");
		
		this.tl= tl;
		this.menu=menu;
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,50,135));
		this.setBackground( new Color(0X150C25));
		//this.setForeground(Color.WHITE);
		
		this.setSize(350,200);
		
		//ImageIcon pauseIcon = new ImageIcon(new ImageIcon("pause1.png").getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
		
		pause = new JButton();
		//pause.setIcon(pauseIcon);
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
					System.out.println("pause clicked!");
					pause.setText("RESUME");
					pauseStatus="resume";
			}
			else if(pauseStatus.equals("resume")) {
						tl.stop=false;
						System.out.println("resume clicked!");
						pause.setText("PAUSE");
						pauseStatus="pause";
			}
			else if(pauseStatus.equals("start")) {
				tl.start_countUpTimer(tl);
				tl.stop=false;
				tl.reset=false;
				pauseStatus="pause";
				pause.setText("PAUSE");
				
				menu.timer.setText("Stop Watch");
				
				System.out.println("timer stated");
			}
		}
		if(e.getSource()==reset) {
			System.out.println("reset clicked");
			tl.stop=true;
			tl.reset=true;
			pauseStatus="start";
			pause.setText("START");
			
		}
	}

}
