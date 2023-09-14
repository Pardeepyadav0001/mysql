package mysqlconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysql1 {
	

	public static void update() {
		Connection conn = null; // always surrounded with try and catch block
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "pardeep";
			String username = "root";
			String password = "YP@rd55p";
			conn = DriverManager.getConnection(url + db, username, password);
			conn.close();
			String query = "update  student set rollno =? where name =?";

			PreparedStatement pstm = conn.prepareStatement(query); // prepared is
			// interface and prepare is method
			pstm.setInt(1, 12); // (index,value)
			pstm.setString(2, "pardeep");
			// pstm.setString(3, "pardeep@gmail.com");
			pstm.execute(); // ptsm.excuteupdate for updaing or adding new value
			System.out.println("data update succesfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readdata() {
		Connection conn = null; // always surrounded with try and catch block
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "pardeep";
			String username = "root";
			String password = "YP@rd55p";
			conn = DriverManager.getConnection(url + db, username, password);
			conn.close();
			String query = "select*from student";

			Statement stm = conn.createStatement(); // prepared is interface and prepare is method

			ResultSet rs = stm.executeQuery(query); // ptsm.excuteupdate for updaing or adding new value

			while (rs.next()) {
				System.out.println("id=" + rs.getInt(1));
				System.out.println("name=" + rs.getString(2));
				System.out.println("email=" + rs.getString(3));
			}

			System.out.println("read data  succesfully");
			conn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void createdata() {
		Connection conn = null; // always surrounded with try and catch block
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "pardeep";
			String username = "root";
			String password = "YP@rd55p";
			conn = DriverManager.getConnection(url + db, username, password);
			conn.close();
			String query = "insert into student (rollno,name,email) values (?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(query); // prepared is interface and prepare is method

			pstm.setInt(1, 10); // (index,value)
			pstm.setString(2, "pardeep");
			pstm.setString(3, "pardeep@gmail.com");
			pstm.execute(); // ptsm.excuteupdate for updaing or adding new value
			System.out.println("data entered succesfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void createtable() {
		Connection conn = null; // always surrounded with try and catch block
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "pardeep";
			String username = "root";
			String password = "YP@rd55p";
			conn = DriverManager.getConnection(url + db, username, password);
			conn.close();
			Statement stm = (Statement) conn.createStatement();

			String query = "create table student12 (rollno int(3),name varchar(20),email varchar(50))";
			stm.execute(query);
			System.out.println("table  created  succesfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createdatabase() {
		// connection establish
		// statement create
		// execute the query
		// conection close
		Connection conn = null; // always surrounded with try and catch block
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "pardeep";
			String username = "root";
			String password = "YP@rd55p";
			conn = DriverManager.getConnection(url + db, username, password);
			conn.close();
			Statement stm = (Statement) conn.createStatement();

			String query = "create table sampletable12 (rollno int(3) primary key ,name varchar(20),email varchar(50))";
			stm.execute(query);
			stm.close();
			System.out.println("table  created  succesfully");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String folderpath = args[0];
		createdatabase(); // methods are calling 
		createtable(); // methods are calling 
		createdata(); // methods are calling 
		readdata(); // methods are calling 
	}
}
