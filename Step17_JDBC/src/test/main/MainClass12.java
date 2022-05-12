package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass12 {
	public static void main(String[] args) {
		//�޼ҵ尡 �������ִ� ��ü ȸ���� ����� main �޼ҵ� �ȿ��� ����ϰ� �ʹٸ�?
		List<MemberDto> list=getList(); //�޼ҵ带 ȣ���ؼ� ��ü ȸ������� �޾ƿ´�.
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getName()+"|"+tmp.getAddr());
		}
	}
	//��ü ȸ���� ����� �������ִ� �޼ҵ� 
	public static List<MemberDto> getList(){
		//ȸ�� ����� ���� ArrayList ��ü ����
		List<MemberDto> list=new ArrayList<>();
		
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			//������ sql ��
			String sql="SELECT num,name,addr FROM member"
					+ " ORDER BY num ASC";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement ��ü�� �̿��ؼ� query �� �����ϰ� ����� 
			//ResultSet ��ü�� �޾ƿ���
			rs=pstmt.executeQuery();
			/*
			 *  ResultSet ��ü�� .next() �޼ҵ�� cursor �ؿ� row �� �����ϴ��� Ȯ���ؼ�
			 *  ���� �����ϸ� true �� �����ϰ� cursor �� ��ĭ ������ �̵��Ѵ�.
			 *  ���� �������� ������ false �� �����Ѵ�. 
			 */
			
			while(rs.next()) {
				//���� cursor �� ��ġ�� ������ num �̶�� Į���� ���� ����
				int num=rs.getInt("num");
				//���� cursor �� ��ġ�� ������ name �̶�� Į���� ���ڿ� ����
				String name=rs.getString("name");
				//���� cursor �� ��ġ�� ������ addr �̶�� Į���� ���ڿ� ����
				String addr=rs.getString("addr");
				//ȸ�� ������ ������ MemberDto ��ü ����
				MemberDto dto=new MemberDto();
				//ȸ�� ������ MemberDto ��ü�� ��� 
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				//ArrayList ��ü�� ���� ��Ű��
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}









