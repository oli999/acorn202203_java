package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		//�߰��� ȸ���� ����
		String name1="���";
		String addr1="�󵵵�";
		
		//HashMap ��ü�� �����ؼ� 
		Map<String, String> m1=new HashMap<>();
		//�߰��� ȸ�������� ��´�.
		
		m1.put("name", name1);
		m1.put("addr", addr1);
		
		//�޼ҵ� ȣ���ϸ鼭 ����
		insert(m1);
	}
	
	//ȸ�� �Ѹ��� ������ �߰��ϴ� �޼ҵ�
	public static void insert(Map<String, String> map) {
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�. 
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql ��
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			// ? �� ���� ���ε��ؼ� �̿ϼ��� sql ���� �ϼ� ��Ų��.
			pstmt.setString(1, map.get("babo"));
			pstmt.setString(2, map.get("merong"));
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







