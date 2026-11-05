package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class main extends JFrame{
	String list[] = {"사용자","관리자","사원등록","종료"};
	JButton btn[] = new JButton[list.length];
	public main() {
		setTitle("메인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,1));
		for(int i=0;i<list.length;i++) {
			btn[i] = new JButton(list[i]);
			add(btn[i]);
			btn[i].addActionListener(new main_act());
		}
		
		setSize(200,200);
		setVisible(true);
	}
	class main_act implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String n = e.getActionCommand();
			switch(n) {
			case "사용자": dispose(); new user(); break;
			case "관리자": dispose(); new admin(); break;
			case "사원등록": dispose(); new join(); break;
			case "종료":  dispose(); break;
			}
		}
	}
	public static void main(String[]args) {
		new main();
	}
}
