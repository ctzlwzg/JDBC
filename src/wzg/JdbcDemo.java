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
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//�������Ӻܺ�ʱ��
			//���������л�ʹ�����ӳ����������Ӷ���
			//��ȡ���ݿ����Ӷ���
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/wzg","root","1111");
			//������ݿ�����
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from teacher4;");
			
			while(rs.next()){
				//��ȡ��ǰ�У�ָ���е�ֵ����ʱ��һ��Ϊint���͵����ݣ��ڶ���ΪString���͵����ݣ������1,2��ʾ��
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
