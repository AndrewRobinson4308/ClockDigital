<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clock extends JFrame{
	
	
	JFrame MainFrame = new JFrame("Digital Clock");
	JLabel MainClock = new JLabel();
	JPanel frame1 = new JPanel();
	JPanel frame2 = new JPanel();
	JPanel frame3 = new JPanel();
	Font AlarmFont;
	
	Timer StopwatchTimer;
	int OneSecond = 1000;
	int TenthOfASecond = 100;


	JButton Start, Stop, Reset;
	JLabel StopLable;

	int StopwatchTick;
	double StopwatchTime;
	String StopwatchTimeString;
	
	int TempHour;
	int TempMinute;
	int TempSecond;
	
	public clock(){
		
		//MainFrame setup
		MainFrame.setSize(500,300);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setVisible(true);
		MainFrame.setResizable(true);
		MainFrame.setLocationRelativeTo(null);
			
		MainFrame.add(frame1,BorderLayout.NORTH);
		MainFrame.add(frame2,BorderLayout.CENTER);
		MainFrame.add(frame3,BorderLayout.SOUTH);

		
		
		//Font setup
		
		GraphicsEnvironment ge = null;
		try {
			AlarmFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("AlarmClock.ttf")).deriveFont(80f);
	        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(AlarmFont);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Please place AlarmClock.ttf into .class location.", "Font Error", JOptionPane.WARNING_MESSAGE);
	        AlarmFont = new Font("Serif", Font.BOLD, 24);
	    }
		
		
		//Clock setup
		MainClock.setFont(AlarmFont);
		frame1.add(MainClock);
		frame1.setVisible(true);
		
		
		
		//Alarm
		
		JLabel AlarmHourLable = new JLabel("Hour");
		frame2.add(AlarmHourLable);
		final JTextField AlarmHour = new JTextField();
		AlarmHour.setColumns(3);
		frame2.add(AlarmHour);
		
		JLabel AlarmMinuteLable = new JLabel("Minute");
		frame2.add(AlarmMinuteLable);
		final JTextField AlarmMinute = new JTextField();
		AlarmMinute.setColumns(3);
		frame2.add(AlarmMinute);
		
		JLabel AlarmSecondLable = new JLabel("Hour");
		frame2.add(AlarmSecondLable);
		final JTextField AlarmSecond = new JTextField();
		AlarmSecond.setColumns(3);
		frame2.add(AlarmSecond);
		
		JButton AlarmSet = new JButton("Set Alarm");
		frame2.add(AlarmSet);


		AlarmSet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				if (AlarmHour.getText() == null || AlarmHour.getText().trim().isEmpty()
					|| AlarmMinute.getText() == null || AlarmMinute.getText().trim().isEmpty()
					|| AlarmSecond.getText() == null || AlarmSecond.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "All field must have a value." , "Missing Fields", JOptionPane.WARNING_MESSAGE);
				}
				else {
				
					TempHour = Integer.parseInt(AlarmHour.getText().toString());
					TempMinute = Integer.parseInt(AlarmMinute.getText().toString());
					TempSecond = Integer.parseInt(AlarmSecond.getText().toString());
					
					if (TempHour >=0 && TempHour <=23 && TempMinute >= 0 && TempMinute <=59 && TempSecond >= 0 && TempSecond <=59) {
						
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Hour must be between 0-23. Minute and second must be between 0-59" , "Invalid alarm", JOptionPane.WARNING_MESSAGE);
						
					}
					

				}	
			}
		});

		
		
		//StopWatch

		StopwatchTick = 0;
		StopwatchTime = ((double)StopwatchTick)/10.0;

		StopwatchTimeString = new Double(StopwatchTime).toString();

		StopLable = new JLabel();
		StopLable.setFont(AlarmFont);
		StopLable.setText(StopwatchTimeString);

		Start = new JButton("Start");
		Stop = new JButton("Stop");
		Reset = new JButton("Reset");


		StopwatchTimer = new Timer(TenthOfASecond, new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			StopwatchTick++;
			StopwatchTime = ((double)StopwatchTick)/10.0;
			StopwatchTimeString = new Double(StopwatchTime).toString();
			StopLable.setText(StopwatchTimeString);
		    }
		});


		Start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTimer.start();
			}
		});

		Stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTimer.stop();
			}
		});

		Reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTick = 0;
				StopwatchTime = ((double)StopwatchTick)/10.0;
				StopwatchTimeString = new Double(StopwatchTime).toString();
				StopLable.setText(StopwatchTimeString);
			}
		});
		
		frame3.add(StopLable);
		frame3.add(Start);
		frame3.add(Stop);
		frame3.add(Reset);
		
		
		
		//clock startup
		
		Timer t = new Timer(1000, new Updater());	
		t.start();
	}
	
	
	class Updater implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			Calendar rightNow = Calendar.getInstance();
			
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			int mins = rightNow.get(Calendar.MINUTE);
			int second = rightNow.get(Calendar.SECOND);
			
			if (TempHour == hour && TempMinute == mins && TempSecond == second) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "ALARM", "WAKE UP", JOptionPane.WARNING_MESSAGE);
			}
			
			MainClock.setText(hour + ":" + mins + ":" + second);
			
		}	
	}
	

=======
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clock extends JFrame{
	
	
	JFrame MainFrame = new JFrame("Digital Clock");
	JLabel MainClock = new JLabel();
	JPanel frame1 = new JPanel();
	JPanel frame2 = new JPanel();
	JPanel frame3 = new JPanel();
	Font AlarmFont;
	
	Timer StopwatchTimer;
	int OneSecond = 1000;
	int TenthOfASecond = 100;


	JButton Start, Stop, Reset;
	JLabel StopLable;

	int StopwatchTick;
	double StopwatchTime;
	String StopwatchTimeString;
	
	public clock(){
		
		//MainFrame setup
		MainFrame.setSize(500,300);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setVisible(true);
		MainFrame.setResizable(true);
		MainFrame.setLocationRelativeTo(null);
			
		MainFrame.add(frame1,BorderLayout.NORTH);
		MainFrame.add(frame2,BorderLayout.CENTER);
		MainFrame.add(frame3,BorderLayout.SOUTH);

		
		
		//Font setup
		
		GraphicsEnvironment ge = null;
		try {
			AlarmFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("AlarmClock.ttf")).deriveFont(80f);
	        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(AlarmFont);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Please place AlarmClock.ttf into .class location.", "Font Error", JOptionPane.WARNING_MESSAGE);
	        MainFrame.dispose();
	    }
		
		
		//Clock setup
		MainClock.setFont(AlarmFont);
		frame1.add(MainClock);
		frame1.setVisible(true);

		
		//StopWatch

		StopwatchTick = 0;
		StopwatchTime = ((double)StopwatchTick)/10.0;

		StopwatchTimeString = new Double(StopwatchTime).toString();

		StopLable = new JLabel();
		StopLable.setFont(AlarmFont);
		StopLable.setText(StopwatchTimeString);

		Start = new JButton("Start");
		Stop = new JButton("Stop");
		Reset = new JButton("Reset");


		StopwatchTimer = new Timer(TenthOfASecond, new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			StopwatchTick++;
			StopwatchTime = ((double)StopwatchTick)/10.0;
			StopwatchTimeString = new Double(StopwatchTime).toString();
			StopLable.setText(StopwatchTimeString);
		    }
		});


		Start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTimer.start();
			}
		});

		Stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTimer.stop();
			}
		});

		Reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTick = 0;
				StopwatchTime = ((double)StopwatchTick)/10.0;
				StopwatchTimeString = new Double(StopwatchTime).toString();
				StopLable.setText(StopwatchTimeString);
			}
		});
		
		frame3.add(StopLable);
		frame3.add(Start);
		frame3.add(Stop);
		frame3.add(Reset);
		
		
		
		//clock startup
		
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
	

>>>>>>> 64ca7c443565980a9311d6d6c661bd461531295e
}