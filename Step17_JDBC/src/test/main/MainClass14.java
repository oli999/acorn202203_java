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
		//메소드를 호출해서 인자로 전달한 번호에 해당하는 회원 정보를 얻어와서
		MemberDto dto=getData(4);
		if(dto!=null) {
			//사용하기
			System.out.println("번호:"+dto.getNum()+" 이름:"+dto.getName()+" 주소:"+dto.getAddr());
		}else {
			System.out.println("해당 회원은 존재 하지 않습니다.");
		}
		
	}
	//인자로 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드 
	public static MemberDto getData(int num) {
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
}







