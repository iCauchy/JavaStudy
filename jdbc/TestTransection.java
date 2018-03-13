import java.sql.*;
public class TestTransaction {
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try{Class.forName("com.mysql.jdbc.Driver");
		//new com.mysql.jdbc.Drive();
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root","password");
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		stmt.addBatch("insert into teacher_table values(1,'zhang','w')");
		stmt.addBatch("insert into teacher_table values(1,'zhang','m')");
		stmt.executeBatch();
		conn.commit();
		conn.setAutoCommit(true);
	}catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		try {
			if(conn != null)
			{
				conn.rollback();
				conn.setAutoCommit(true);
			}
		}catch(SQLException e1){
				e1.printStackTrace();
		}
		
	}finally {
		try {
			if(stmt != null) {
			stmt.close();
			}
			if(conn != null)
			{
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	}	
}
}
