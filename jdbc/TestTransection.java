import java.sql.*;
public class TestTransaction {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//new com.mysql.jdbc.Drive();
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root","password");
		Statement stmt = conn.createStatement();
		conn.setAutoCommit(false);
		stmt.addBatch("insert into teacher_table values(1,'zhang','w')");
		stmt.addBatch("insert into teacher_table values(1,'zhang','m')");
		stmt.executeBatch();
		conn.commit();
		conn.setAutoCommit(true);
		stmt.close();
		conn.close();
	}
	
}
