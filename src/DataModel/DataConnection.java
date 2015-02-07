package DataModel;
import java.sql.*;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DataConnection {
	protected Connection conn=null;
	protected Statement stmt=null;
	protected ResultSet rs=null;
	
	public static final int SQL_SELECT=1;
	public static final int SQL_INSERT=2;
	public static final int SQL_UPDATE=3;
	public static final int SQL_DELETE=4;
	
	public DataConnection()
	{
		createConn();
	}
	
	public DataConnection(String conn,String sql)
	{
		setDataConnection(conn);
		setResultSet(sql);	
	}
	
	public DataConnection(String conn,String sql,int option)
	{
		setDataConnection(conn);
		if(option==SQL_SELECT)
		{
			setResultSet(sql);
		}
		else
		{
            int count=setUpdateStatement(sql);
		}
	}
	
	public void createConn()
	{	
		setDataConnection("jdbc:odbc:HotelBookingSystem");
	}
	
	//Set data connection  
	private void setDataConnection(String conn_str)
	{
		try
		{
			System.out.println("Start connecting...");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		try {
	        //DriverManager.setLoginTimeout(360);	  
			conn=DriverManager.getConnection(conn_str);
			//conn=DriverManager.getConnection("jdbc:mysql://61.191.191.213:3306/sqlcnobel","cnobel","pijian2008");
			//conn=DriverManager.getConnection("jdbc:sqlserver://222.186.191.184:1433;databaseName=pike0002","pike0002","pike0825");
			System.out.println("Connection established");
		} catch (SQLException e) {
			e.printStackTrace();		
			System.out.println("Connection error.");
		}
	}
	
	public void setResultSet(String sql)
	{
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Return the result set
	public ResultSet getResultSet()
	{		
		return rs;
	}
	
	//Return the resultset with parameters
	//Set the result set
	public ResultSet getResultSet(String sql)
	{
		ResultSet result_set=null;
		try {
			Statement stmt=conn.createStatement();
			result_set=stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return result_set;
	}
	
	//Set insert statement
	public int setUpdateStatement(String update_sql)
	{
		int rows_affected=0;
		try {
			Statement stmt=conn.createStatement();
			rows_affected=stmt.executeUpdate(update_sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows_affected;
	}
	
	//Close connection
	public void CloseConn()
	{
		try
		{
			//stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
