import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class clock extends JFrame{
	
	
	JFrame MainFrame = new JFrame("Digital Clock");
	JLabel MainClock = new JLabel();
	JPanel frame1 = new JPanel();
	JPanel frame2 = new JPanel();
	JPanel frame3 = new JPanel();
	Font AlarmFont;
	
	
	public clock(){
		//MainFrame.setTitle("Digital Clock");
		MainFrame.setSize(400,400);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setVisible(true);
		MainFrame.setResizable(true);
		MainFrame.setLocationRelativeTo(null);
		
		MainFrame.add(frame1,BorderLayout.NORTH);
		MainFrame.add(frame2,BorderLayout.CENTER);
		MainFrame.add(frame3,BorderLayout.SOUTH);
		
		frame1.setBackground(Color.CYAN);
		frame2.setBackground(Color.YELLOW);
		frame3.setBackground(Color.BLUE);
		
		
		
		
		//frame1 = new JPanel();
		frame1.setLayout(new FlowLayout());
		
		//MainClock = new JLabel();
			
		GraphicsEnvironment ge = null;
		try {
			AlarmFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("AlarmClock.ttf")).deriveFont(80f);
	        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(AlarmFont);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
		
		//MainClock.setBounds(600, 600, 600, 600);
		MainClock.setFont(AlarmFont);
		
		frame1.add(MainClock);
		frame1.setVisible(true);
		
		//add(frame1);
		
		
		//JButton AlarmButton = new JButton("Set Alarm");
		//AlarmButton.setBounds(0,0,0,0);
		//frame2.add(AlarmButton);
		
		
		
		
		Timer t = new Timer(1000, new Updater());	
		t.start();
	}
	
	class Updater implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			Calendar rightNow = Calendar.getInstance();
			
			
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			int mins = rightNow.get(Calendar.MINUTE);
			int second = rightNow.get(Calendar.SECOND);
			
			MainClock.setText(hour + ":" + mins + ":" + second);
			
		}	
	}
	

}