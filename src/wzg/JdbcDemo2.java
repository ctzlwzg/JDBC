package wzg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* @author  作者: ctzl
* @date 创建时间：2017年6月17日 上午9:41:10 
* @version 1.0 
*/public class JdbcDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wzg","root","wzg29211");
			//执行sql语句
			String sql = "select teacher_id,teacher_name from teacher4 where teacher_id>?";
			ps = con.prepareStatement(sql);
			ps.setObject(1,2);
			rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			//String sql="insert into teacher2(teacher_name) values(?)";//?占位符
			//PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, 6);
//			ps.setString(2, "蛋蛋");
		
			
			
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
			if(ps!=null){
				try {
					ps.close();
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
