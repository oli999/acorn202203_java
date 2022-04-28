package test.mypac;
/*
 *  T 는 type 파라미터 이다
 *  
 *  저기에 전달된 클래스를 포괄 클래스(Generic 클래스) 라고 한다.
 */
public class FruitBox<T> {
	//필드
	private T item;
	//필드에 값을 넣는 메소드 
	public void setItem(T item) {
		this.item=item;
	}
	
	//필드에 저장된 값을 리턴하는 메소드
	public T getItem() {
		return item;
	}
}
