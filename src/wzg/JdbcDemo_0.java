package wzg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo_0 {
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String driver = null;
		String url = null;
		String user = null;
		String password = null;
		//String paramFile = "resource/db.properties";
		
		ClassLoader classLoader = JdbcDemo_0.class.getClassLoader();
		InputStream f = classLoader.getResourceAsStream("db.properties");
		Properties p = new Properties();
		p.load(f);
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
		
			//加载驱动类
			Class.forName(driver);
			//建立连接很耗时。
			//真正开发中会使用连接池来管理连接对象
			//获取数据库连接对象
			conn= DriverManager.getConnection(url,user,password);
			//获得数据库连接
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from teacher4;");
			
			while(rs.next()){
				//获取当前行，指定列的值，此时第一列为int类型的数据，第二列为String类型的数据，下面的1,2表示列
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
