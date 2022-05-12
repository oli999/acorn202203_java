package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass17 {
	public static void main(String[] args) {
		//수정할 회원 정보를 입력 받아서 
		Scanner scan=new Scanner(System.in);
		System.out.print("수정할 회원번호:");
		int num=scan.nextInt();
		scan.nextLine(); //위에서 입력한 개행기호 없애기
		System.out.print("이름 입력:");
		String name=scan.nextLine();
		System.out.print("주소 입력:");
		String addr=scan.nextLine();
		//회원 정보를 MemberDto 객체에 담고 
		MemberDto dto=new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		//메소드를 호출 하면서 전달해서 회원 정보를 수정 하고 성공 여부를 리턴 받는다.
		boolean isSuccess=update(dto);
		if(isSuccess) {
			System.out.println(name+" 의 정보를 수정 했습니다.");
		}else {
			System.out.println(name+" 정보 수정 실패!");
		}
		
	}
	
	public static boolean update(MemberDto dto) {
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
}








