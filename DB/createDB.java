package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createDB {
	public createDB() {
		Connection con = null;
		Statement st = null;
		String creDB = "create database if not exists meal";
		String cretable []= {"create table if not exists member(memberNo int not null auto_increment, memberName varchar(20), passwd varchar(4),primary key(memberNo))",
				"create table if not exists cuisine(cuisineNo int not null primary key auto_increment, memberName varchar(20))",
				"create table if not exists meal(mealNo int primary key not null auto_increment, cuisineNo int, mealName varchar(20), price int, maxCount int, todayMeal tinyint(1))",
				"create table if not exists orderlist(orderNo int primary key not null auto_increment, cuisineNo int, mealNo int, memberNo int, orderCount int, amount int, orderDate datetime)"};
				
		try {
			con = connection.makeConnection("");
			st = con.createStatement();
			st.execute(creDB);
			st.execute("use meal");
			for(int i=0;i<cretable.length;i++) {
				st.execute(cretable[i]);
			}
			System.out.println("데이터베이스 생성 완료");
		}catch(SQLException e) {
			System.out.println("데이터베이스 생성 오류 : "+e);
		}
	}
//	public static void main(String[]args) {
//		new createDB();
//	}
}
