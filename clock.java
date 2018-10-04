import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clock extends JFrame{
	
	//Clock declarations
	JFrame MainFrame = new JFrame("Digital Clock");
	JLabel MainClock = new JLabel();
	JPanel frame1 = new JPanel();
	JPanel frame2 = new JPanel();
	JPanel frame3 = new JPanel();
	Font AlarmFont;
	
	//Stopwatch declarations
	Timer StopwatchTimer;
	int OneSecond = 1000;
	int TenthOfASecond = 100;

	JButton Start, Stop, Reset;
	JLabel StopLable;

	int StopwatchTick;
	double StopwatchTime;
	String StopwatchTimeString;
	
	//Alarm declarations
	int TempHour;
	int TempMinute;
	int TempSecond;
	
	public clock(){
		
		//MainFrame setup
		//Sets up the window size and attributes that contains all the panels
		MainFrame.setSize(500,300);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setVisible(true);
		MainFrame.setResizable(true);
		MainFrame.setLocationRelativeTo(null);
			
		//Panel format
		//creates the panels and sets their location
		MainFrame.add(frame1,BorderLayout.NORTH);
		MainFrame.add(frame2,BorderLayout.CENTER);
		MainFrame.add(frame3,BorderLayout.SOUTH);

		
		
		//Font setup
		//Creates a custom font for a .ttf(true type font) file
		GraphicsEnvironment ge = null;
		try {
			AlarmFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("AlarmClock.ttf")).deriveFont(80f);
	        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(AlarmFont);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        Toolkit.getDefaultToolkit().beep();
	        JOptionPane.showMessageDialog(null, "Please place AlarmClock.ttf into .class location.\nProgram will now close.", "Font Error", JOptionPane.WARNING_MESSAGE);
	        MainFrame.dispose();
	    }
		
		
		//Clock setup
		//Adds clock to the window
		MainClock.setFont(AlarmFont);
		frame1.add(MainClock);
		frame1.setVisible(true);
		
		
		
		//Alarm
		
		//Alarm GUI
		//Creates the alarms labels, text fields and buttons
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


		//Alarm Listener
		//Waits for the set alarm button to be pressed
		AlarmSet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				
				//sets boolean if the text fields are numbers or not
		        boolean nonnumeric = false;
		        try {
		            Integer num = Integer.parseInt(AlarmHour.getText());
		            num = Integer.parseInt(AlarmMinute.getText());
		            num = Integer.parseInt(AlarmSecond.getText());
		        } 
		        catch (NumberFormatException e) {
		            nonnumeric = true;
		        }
				
		      //check if text fields have values and are numbers
				if (AlarmHour.getText() == null || AlarmHour.getText().trim().isEmpty()
					|| AlarmMinute.getText() == null || AlarmMinute.getText().trim().isEmpty()
					|| AlarmSecond.getText() == null || AlarmSecond.getText().trim().isEmpty() 
					|| nonnumeric) {
					
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "All fields must have a number value." , "Incorrect/Missing Fields", JOptionPane.WARNING_MESSAGE);
				}
				else {
				
					//changes input to integers
					TempHour = Integer.parseInt(AlarmHour.getText().toString());
					TempMinute = Integer.parseInt(AlarmMinute.getText().toString());
					TempSecond = Integer.parseInt(AlarmSecond.getText().toString());
					
					//Checks alarm input
					if (TempHour >=0 && TempHour <=23 && TempMinute >= 0 && TempMinute <=59 && TempSecond >= 0 && TempSecond <=59) {						
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Alarm set to:  " + TempHour +":" + TempMinute + ":" + TempSecond , "Alarm Set", JOptionPane.WARNING_MESSAGE);
					}
					else {
						//throws input error
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Hour must be between 0-23. Minute and second must be between 0-59" , "Invalid alarm input", JOptionPane.WARNING_MESSAGE);
					}
					
				}	
			}
		});

		
		
		//StopWatch

		//Stopwatch declarations and GUI
		StopwatchTick = 0;
		StopwatchTime = ((double)StopwatchTick)/10.0;

		StopwatchTimeString = new Double(StopwatchTime).toString();

		StopLable = new JLabel();
		StopLable.setFont(AlarmFont);
		StopLable.setText(StopwatchTimeString);

		Start = new JButton("Start");
		Stop = new JButton("Stop");
		Reset = new JButton("Reset");

		
		//Stopwatch counter
		StopwatchTimer = new Timer(TenthOfASecond, new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			StopwatchTick++;
			StopwatchTime = ((double)StopwatchTick)/10.0;
			StopwatchTimeString = new Double(StopwatchTime).toString();
			StopLable.setText(StopwatchTimeString);
		    }
		});

		//Stopwatch start listener
		Start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTimer.start();
			}
		});

		//Stowatch stop listener
		Stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTimer.stop();
			}
		});

		//Stopwatch stop listener
		Reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StopwatchTick = 0;
				StopwatchTime = ((double)StopwatchTick)/10.0;
				StopwatchTimeString = new Double(StopwatchTime).toString();
				StopLable.setText(StopwatchTimeString);
			}
		});
		
		//Draws stopwatch
		frame3.add(StopLable);
		frame3.add(Start);
		frame3.add(Stop);
		frame3.add(Reset);
		
		
		
		//Draws clock
		Timer t = new Timer(1000, new Updater());	
		t.start();
	}
	
	
	//Clock listener class
	class Updater implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			Calendar rightNow = Calendar.getInstance();
			
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			int mins = rightNow.get(Calendar.MINUTE);
			int second = rightNow.get(Calendar.SECOND);
			
			//Alarm checker
			if (TempHour == hour && TempMinute == mins && TempSecond == second) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "ALARM", "WAKE UP", JOptionPane.WARNING_MESSAGE);
			}
			
			//Sets time
			MainClock.setText(hour + ":" + mins + ":" + second);
			
		}	
	}
	

}