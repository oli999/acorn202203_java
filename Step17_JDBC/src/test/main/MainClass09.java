package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass09 {
	public static void main(String[] args) {
		//�߰��� ȸ���� ����
		String name1="���";
		String addr1="�󵵵�";
		
		//MemberDto ��ü�� �����ؼ� 
		MemberDto dto=new MemberDto();
		//setter �޼ҵ带 �̿��ؼ� ȸ�������� ��� 
		dto.setName(name1);
		dto.setAddr(addr1);
		//�޼ҵ� ȣ���ϸ鼭 MemberDto ��ü�� ������ �����ϱ� 
		insert(dto);

	}
	
	//ȸ�� �Ѹ��� ������ �߰��ϴ� �޼ҵ�
	public static void insert(MemberDto dto) {
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
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
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







