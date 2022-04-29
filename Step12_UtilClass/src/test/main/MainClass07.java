package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass07 {
	public static void main(String[] args) {
		final Map<String, Object> map1=new HashMap<>();
		
		/*
		 *  HashMap<key 값의 type, value 값의 type>
		 *  
		 *  key 의 generic class 는 String 으로 지정하는것이 일반적이다.
		 *  value 의 generic class 는 담을 데이터 type 을 지정하면된다.
		 *  여러개의 type 을 섞어서 담을거면 Object 로 지정하면 된다.  
		 */
		/*
		 *  위에서 생성한 HashMap 객체에 다음과 같은 정보 3 가지를 담아 보세요.
		 *  
		 *  번호 : 1
		 *  이름 : 김구라
		 *  남자인지 여부 : true
		 */
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("isMan", true);
		/*
		 *  value 의 Generic 클래스가 Object 로 지정 되어 있기때문에
		 *  리턴되는 Object type 을 원래 type 으로 casting 해야 한다. 
		 */
		// map1 에 담긴  번호는 num, 이름은 name, 남자인지 여부는 isMan 이라는 지역 변수에 담아 보세요.
		int num=(int)map1.get("num");
		String name=(String)map1.get("name");
		boolean isMan=(boolean)map1.get("isMan");
		
		//동일한 key 값으로 다시 담으면 수정
		map1.put("name", "에이콘");
		
		//특정 key 값으로 담긴 내용 삭제, 성공하면 true, 실패하면 false 리턴
		map1.remove("isMan");
		
		//모두 삭제 
		map1.clear();
	}
}

















