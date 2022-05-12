package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.util.DBConnect;
/*
 *  - hint
 *  
 *  SELECT num, name, addr
 *  FROM member
 *  WHERE num=?
 *  
 *  .setInt(1, num)
 */
public class MainClass14 {
	public static void main(String[] args) {
		//�޼ҵ带 ȣ���ؼ� ���ڷ� ������ ��ȣ�� �ش��ϴ� ȸ�� ������ ���ͼ�
		MemberDto dto=getData(4);
		if(dto!=null) {
			//����ϱ�
			System.out.println("��ȣ:"+dto.getNum()+" �̸�:"+dto.getName()+" �ּ�:"+dto.getAddr());
		}else {
			System.out.println("�ش� ȸ���� ���� ���� �ʽ��ϴ�.");
		}
		
	}
	//���ڷ� ���޵� ��ȣ�� �ش��ϴ� ȸ�� �Ѹ��� ������ �����ϴ� �޼ҵ� 
	public static MemberDto getData(int num) {
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//MemberDto ��ü�� ���� ���� ������ �̸� �����. 
		MemberDto dto=null;
		try {
			conn=new DBConnect().getConn();
			//������ sql ��
			String sql="SELECT name, addr"
					+ " FROM member"
					+ " WHERE num=?";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			// �̿ϼ��� ? �� ���ε� �Ұ� ������ �ϱ�
			pstmt.setInt(1, num);
			
			//PreparedStatement ��ü�� �̿��ؼ� query �� �����ϰ� ����� 
			//ResultSet ��ü�� �޾ƿ���
			rs=pstmt.executeQuery();
			
			//���� select �� row �� �ִٸ� 
			if(rs.next()) {
				//select �� ������ MemberDto ��ü�� ��´�. 
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return dto;
	}
}







