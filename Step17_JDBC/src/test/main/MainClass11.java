package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		//������ ȸ���� ��ȣ��� ����
		int num=4;
		
		delete(num);
	}
	
	public static void delete(int num) {
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�. 
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql ��
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
	        //sql �� �����ϱ�
	        pstmt.executeUpdate();
	        System.out.println("ȸ�� ������ �����߽��ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
	}
}
