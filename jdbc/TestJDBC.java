import java.sql.*;
public class TestJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement ste = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//new com.mysql.jdbc.Drive();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root","password");
			ste = conn.createStatement();
			rs = ste.executeQuery("select * from teacher_table");
			while(rs.next())
			{
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getString("sex"));
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally
		{	try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if(ste!=null) {
				ste.close();
				ste = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}
			
		}		
	}

}

