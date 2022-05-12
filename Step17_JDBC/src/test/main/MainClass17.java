package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass17 {
	public static void main(String[] args) {
		//������ ȸ�� ������ �Է� �޾Ƽ� 
		Scanner scan=new Scanner(System.in);
		System.out.print("������ ȸ����ȣ:");
		int num=scan.nextInt();
		scan.nextLine(); //������ �Է��� �����ȣ ���ֱ�
		System.out.print("�̸� �Է�:");
		String name=scan.nextLine();
		System.out.print("�ּ� �Է�:");
		String addr=scan.nextLine();
		//ȸ�� ������ MemberDto ��ü�� ��� 
		MemberDto dto=new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		//�޼ҵ带 ȣ�� �ϸ鼭 �����ؼ� ȸ�� ������ ���� �ϰ� ���� ���θ� ���� �޴´�.
		boolean isSuccess=update(dto);
		if(isSuccess) {
			System.out.println(name+" �� ������ ���� �߽��ϴ�.");
		}else {
			System.out.println(name+" ���� ���� ����!");
		}
		
	}
	
	public static boolean update(MemberDto dto) {
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�. 
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql ��
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			// ? �� ���� ���ε��ؼ� �̿ϼ��� sql ���� �ϼ� ��Ų��.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
	        //sql �� �����ϱ�
			updatedRowCount=pstmt.executeUpdate();
	       
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








