import java.sql.*;
public class TestBatch {
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//new com.mysql.jdbc.Drive();
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root","password");
		Statement stmt = conn.createStatement();
		stmt.addBatch("insert into teacher_table values(1,'zhang','w')");
		stmt.addBatch("insert into teacher_table values(1,'zhang','m')");
		stmt.executeBatch();
		stmt.close();
	}
}

