package test.main;

import java.util.Random;

/*   
 * 
 *  
 *   1. cherry, apple, banana, melon, 7
 *      5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
 *   
 *   2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
 *      예)  cherry | apple | cherry
 *           7 | apple | melon
 *           7 | 7 | 7
 *           
 *   - hint
 *   
 *   String[] items={"cherry", "apple", "banana", "melon", "7"};
 *   
 *   Random ran=new Random();
 *   int ranNum=ran.nextInt(5);
 *      
 */

public class MainClass07 {
	public static void main(String[] args) {
		String[] items={"cherry", "apple", "banana", "melon", "7"};
		
		Random ran=new Random();
		int ranNum=ran.nextInt(5);
		
		System.out.println(items[ranNum]);
		
		//-----------------------------------------
		
		// 0~4 사이의  정수중에서 랜덤한 정수 3개 얻어내기 
		int num1=ran.nextInt(5);
		int num2=ran.nextInt(5);
		int num3=ran.nextInt(5);
		
		//출력할 문자열을 구성하기
		String line=items[num1]+" | "+items[num2]+" | "+items[num3];
		
		//출력하기 
		System.out.println(line);
		
	}
}
















