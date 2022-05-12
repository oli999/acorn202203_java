package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass18 {
	public static void main(String[] args) {
		//1 번 회원의 정보를 얻어와야 한다면?
		/*
		 *  DB 에 어떻게 접속을 해야하는지 알 필요가 없다.
		 *  PreparedStatement, ResultSet 등의 객체 활용법을 알 필요도 없다.
		 */
		
		MemberDao dao=new MemberDao();
		MemberDto dto=dao.getData(1);
		
		//모든 회원의 목록을 얻어와야 한다면?
		List<MemberDto> list=dao.getList();
		
	}
}











