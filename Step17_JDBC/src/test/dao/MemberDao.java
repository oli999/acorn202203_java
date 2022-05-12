package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	
	// ȸ�� �Ѹ��� ������ �̸����� �˻����ִ� �޼ҵ�
	public List<MemberDto> getDataByName(String name){
		List<MemberDto> list = new ArrayList<>();
      	MemberDto dto;
      
      	//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
      	Connection conn=null;
      	PreparedStatement pstmt=null;
      	ResultSet rs=null;
      	try {
      		conn = new DBConnect().getConn();
      		String sql = "SELECT * FROM member" + " WHERE name LIKE '%'||?||'%'" + " ORDER BY num ASC";
      		pstmt = conn.prepareStatement(sql);
      		pstmt.setString(1, name);
      		rs = pstmt.executeQuery();
         
         	while(rs.next()) {
	            dto = new MemberDto();
	            dto.setNum(rs.getInt("num"));
	            dto.setName(rs.getString("name"));
	            dto.setAddr(rs.getString("addr"));
	            list.add(dto);
         	}
      	} catch (SQLException e) {
      		e.printStackTrace();
      	}
      	return list;
   	}

	
	
	public boolean insert(MemberDto dto) {
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
	public boolean update(MemberDto dto) {
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
	public boolean delete(int num) {
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect ��ü�� �̿��ؼ� Connection ��ü�� �������� ���´�. 
			conn=new DBConnect().getConn();
			//������ �̿ϼ��� sql ��
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
	        //sql �� �����ϰ� ������(�߰�, ����, ����) row �� ���� ���� �ޱ� 
	        updatedRowCount=pstmt.executeUpdate();
	       
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(updatedRowCount > 0) {
        	//������ ���
        	return true;
        }else {
        	//������ ���
        	return false;
        }
	}
	//���ڷ� ���޵� ��ȣ�� �ش��ϴ� ȸ�� �Ѹ��� ������ �����ϴ� �޼ҵ� 
	public MemberDto getData(int num) {
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
	//��ü ȸ���� ����� �������ִ� �޼ҵ� 
	public  List<MemberDto> getList(){
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
				//ȸ�� ������ ������ MemberDto ��ü ����
				MemberDto dto=new MemberDto();
				//ȸ�� ������ MemberDto ��ü�� ��� 
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				//ArrayList ��ü�� ���� ��Ű��
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}





