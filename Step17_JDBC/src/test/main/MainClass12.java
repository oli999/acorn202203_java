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
		//메소드가 리턴해주는 전체 회원의 목록을 main 메소드 안에서 사용하고 싶다면?
		List<MemberDto> list=getList(); //메소드를 호출해서 전체 회원목록을 받아온다.
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getName()+"|"+tmp.getAddr());
		}
	}
	//전체 회원의 목록을 리턴해주는 메소드 
	public static List<MemberDto> getList(){
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
				//현재 cursor 가 위치한 곳에서 num 이라는 칼럼의 정수 얻어내기
				int num=rs.getInt("num");
				//현재 cursor 가 위치한 곳에서 name 이라는 칼럼의 문자열 얻어내기
				String name=rs.getString("name");
				//현재 cursor 가 위치한 곳에서 addr 이라는 칼럼의 문자열 얻어내기
				String addr=rs.getString("addr");
				//회원 정보를 저장할 MemberDto 객체 생성
				MemberDto dto=new MemberDto();
				//회원 정보를 MemberDto 객체에 담고 
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				//ArrayList 객체에 누적 시키기
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}









