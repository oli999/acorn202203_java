package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass18 {
	public static void main(String[] args) {
		//1 �� ȸ���� ������ ���;� �Ѵٸ�?
		/*
		 *  DB �� ��� ������ �ؾ��ϴ��� �� �ʿ䰡 ����.
		 *  PreparedStatement, ResultSet ���� ��ü Ȱ����� �� �ʿ䵵 ����.
		 */
		
		MemberDao dao=new MemberDao();
		MemberDto dto=dao.getData(1);
		
		//��� ȸ���� ����� ���;� �Ѵٸ�?
		List<MemberDto> list=dao.getList();
		
	}
}











