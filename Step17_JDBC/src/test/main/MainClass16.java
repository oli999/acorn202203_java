package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass16 {
	public static void main(String[] args) {
		//�߰��� ȸ�� ������ �Է� �޾Ƽ� 
		Scanner scan=new Scanner(System.in);
		System.out.print("�̸� �Է�:");
		String name=scan.nextLine();
		System.out.print("�ּ� �Է�:");
		String addr=scan.nextLine();
		//ȸ�� ������ MemberDto ��ü�� ��� 
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//�޼ҵ带 ȣ�� �ϸ鼭 �����ؼ� ȸ�� ������ �߰� �ϰ� ���� ���θ� ���� �޴´�.
		boolean isSuccess=insert(dto);
		if(isSuccess) {
			System.out.println(name+" �� ������ �߰� �߽��ϴ�.");
		}else {
			System.out.println(name+" ���� �߰� ����!");
		}
		
	}
	
	public static boolean insert(MemberDto dto) {
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
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
			updatedRowCount=pstmt.executeUpdate();
	        System.out.println("ȸ�� ������ �����߽��ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(updatedRowCount>0) {
			return true;
		}else {
			return false;
		}
	}
}








