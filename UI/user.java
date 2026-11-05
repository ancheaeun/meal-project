package UI;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class user extends JFrame{
	public user() {
		setTitle("식권 발매 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new north(),BorderLayout.NORTH);
		add(new center(),BorderLayout.CENTER);
		add(new south(),BorderLayout.SOUTH);
		
		setSize(400,600);
		setVisible(true);
	}
	class north extends JPanel{
		public north() {
			// TODO Auto-generated constructor stub
		}
	}
	class center extends JPanel{
		public center() {
			// TODO Auto-generated constructor stub
		}
	}
	class south extends JPanel{
		public south() {
			rec();	//현재시간 알아내는 함수
			
			while(true) {
				try {
					//1초마다 갱신
				}catch(Exception e) {
					System.out.println("오류 : "+e);
				}
			}
		}
	}
	public void rec() {		//현재 시간 알아내는 함수
		String recent;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		String ryear = Integer.toString(year);
		String rmonth = Integer.toString(month);
		String rdate = Integer.toString(date);
		String rhour = Integer.toString(hour);
		String rmin = Integer.toString(min);
		String rsec = Integer.toString(sec);
	}
	public static void main(String[]args) {
		new user();
	}
}
