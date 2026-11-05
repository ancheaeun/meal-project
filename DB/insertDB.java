package DB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class insertDB {
	public insertDB() {
		Connection con = null;
		PreparedStatement psmt = null;
		Scanner s;
		StringTokenizer meal = null;
		
		String root = "C:\\Users\\SJCOM\\Desktop\\mealProject\\meal\\Datafiles\\";
		String txt[] = {"meal","member","cuisine","orderlist"};
		String insDB[] = {"insert into meal values(?,?,?,?,?,?)",
				"insert into member values(?,?,?)",
				"insert into cuisine values(?,?)",
				"insert into orderlist values(?,?,?,?,?,?,?)"};
		
		con = connection.makeConnection("meal");
		
		try {
			for(int i=0;i<insDB.length;i++) {
				psmt = con.prepareStatement(insDB[i]);
				s = new Scanner(new FileInputStream(root+txt[i]+".txt"));
				System.out.println(txt[i]);
				//System.out.println(readfile(s));
				meal = readfile(s);
				int n = meal.countTokens();
				//System.out.println(n);
		
				while(s.hasNext()) {
					meal = readfile(s);
					for(int j=0;j<n;j++) {
						String count = meal.nextToken();
						psmt.setString(j+1, count);
						//System.out.println(count);
					}
					int re = psmt.executeUpdate();
					if(re == 1) {
					}else System.out.println("입력실패");
				}
				System.out.println("입력성공");
			}
		}catch(SQLException e) {
			System.out.println("SQL오류: "+e);
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}
	}
	public StringTokenizer readfile(Scanner s) {
		String meal;
		meal=s.nextLine();
		StringTokenizer bob=new StringTokenizer(meal,"\t");
		//System.out.println(meal);
		
		return bob;
	}
	public static void main(String[]args) {
		new createDB();
		new insertDB();
	}
}
