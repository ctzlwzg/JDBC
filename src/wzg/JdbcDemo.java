package wzg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接很耗时。
			//真正开发中会使用连接池来管理连接对象
			//获取数据库连接对象
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/wzg","root","1111");
			//获得数据库连接
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from teacher4;");
			
			while(rs.next()){
				//获取当前行，指定列的值，此时第一列为int类型的数据，第二列为String类型的数据，下面的1,2表示列
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
}
