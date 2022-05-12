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
	
	// 회원 한명의 정보를 이름으로 검색해주는 메소드
	public List<MemberDto> getDataByName(String name){
		List<MemberDto> list = new ArrayList<>();
      	MemberDto dto;
      
      	//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
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
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다. 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값을 바인딩해서 미완성의 sql 문을 완성 시킨다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
	        //sql 문 실행하기
			updatedRowCount=pstmt.executeUpdate();
	        System.out.println("회원 정보를 저장했습니다.");
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
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다. 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값을 바인딩해서 미완성의 sql 문을 완성 시킨다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
	        //sql 문 실행하기
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
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다. 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
	        //sql 문 실행하고 수정된(추가, 수정, 삭제) row 의 갯수 리턴 받기 
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
        	//성공인 경우
        	return true;
        }else {
        	//실패인 경우
        	return false;
        }
	}
	//인자로 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드 
	public MemberDto getData(int num) {
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//MemberDto 객체를 담을 지역 변수를 미리 만든다. 
		MemberDto dto=null;
		try {
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="SELECT name, addr"
					+ " FROM member"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// 미완성인 ? 에 바인딩 할게 있으면 하기
			pstmt.setInt(1, num);
			
			//PreparedStatement 객체를 이용해서 query 문 수행하고 결과를 
			//ResultSet 객체로 받아오기
			rs=pstmt.executeQuery();
			
			//만일 select 된 row 가 있다면 
			if(rs.next()) {
				//select 된 정보를 MemberDto 객체에 담는다. 
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
	//전체 회원의 목록을 리턴해주는 메소드 
	public  List<MemberDto> getList(){
		//회원 목록을 담을 ArrayList 객체 생성
		List<MemberDto> list=new ArrayList<>();
		
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="SELECT num,name,addr FROM member"
					+ " ORDER BY num ASC";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체를 이용해서 query 문 수행하고 결과를 
			//ResultSet 객체로 받아오기
			rs=pstmt.executeQuery();
			/*
			 *  ResultSet 객체의 .next() 메소드는 cursor 밑에 row 가 존재하는지 확인해서
			 *  만일 존재하면 true 를 리턴하고 cursor 가 한칸 밑으로 이동한다.
			 *  만일 존재하지 않으면 false 를 리턴한다. 
			 */
			
			while(rs.next()) {
				//회원 정보를 저장할 MemberDto 객체 생성
				MemberDto dto=new MemberDto();
				//회원 정보를 MemberDto 객체에 담고 
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				//ArrayList 객체에 누적 시키기
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}





