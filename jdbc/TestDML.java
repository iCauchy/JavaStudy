import java.sql.*;
public class TestDML {

	public static void main(String[] args) {
		if (args.length !=3) {
			System.out.println("Parameter Error! Please Input Again");
			System.exit(-1);
		}
		int id = 0;
		try {
			id = Integer.parseInt(args[0]);
		}catch (NumberFormatException e)
		{
			System.out.println("Parameter Error! id Shoudle be number Format!");
			System.exit(-1);
		}
		
		String name = args[1];
		String sex = args[2];
		
		Connection conn = null;
		Statement ste = null;
		String sql = "insert into teacher_table values(" + id + ",'" + name + "','" + sex + "');";
		System.out.println(sql);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//new com.mysql.jdbc.Drive();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test", "root","password");
			ste = conn.createStatement();
			ste.executeUpdate(sql);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally
		{	try {
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

