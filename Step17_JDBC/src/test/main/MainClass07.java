package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		//�߰��� ȸ���� ����
		String name="�ֵ���";
		String addr="��õ��";
		//ȸ�� �Ѹ��� ������ Member ��ü�� ��´�.
		Member m1=new Member();
		m1.name=name;
		m1.addr=addr;
		//�޼ҵ� ȣ���ϸ鼭 ȸ�� ������ ��� �ִ� Member ��ü�� �����Ѵ�.
		insert(m1);
	}
	
	//ȸ�� �Ѹ��� ������ �߰��ϴ� �޼ҵ�
	public static void insert(Member mem) {
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
			pstmt.setString(1, mem.name);
			pstmt.setString(2, mem.addr);
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







