package wzg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
* @author  作者: ctzl
* @date 创建时间：2017年6月17日 上午9:41:10 
* @version 1.0 
* 批处理方法
* 记住要先设置手动提交
*/public class JdbcDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wzg","root","wzg29211");

			//设置不自动提交
			con.setAutoCommit(false);
			
			long start = System.currentTimeMillis();
			stmt1 = con.createStatement();
			for(int i = 0;i < 20000;i++){
				stmt1.addBatch("insert into teacher3 (teacher_id,teacher_name) values ("+i+",'蛋"+i+"')");
			}
			stmt1.executeBatch();
			con.commit();
			long end = System.currentTimeMillis();
			System.out.println("插入20000条数据耗时："+(end-start));
			
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
			if(stmt1!=null){
				try {
					stmt1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
