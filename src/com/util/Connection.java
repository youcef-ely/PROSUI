package com.util;
import java.sql.*;

public class Connection {
private static String URL="jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
private static java.sql.Connection conn;
private static Statement st;
public static void connect() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(URL, "root", "JosephELY200");
		st=conn.createStatement();
		
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}	
}
public static void disconnect() {
	try {
		conn.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public static int miseajour(String sql) {
int nb=0;
	try {
	nb=st.executeUpdate(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return nb;
}

public static ResultSet select(String sql) {
	ResultSet rs=null;
	try {
		rs=st.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;

}
}
