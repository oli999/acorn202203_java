package test.main;

import test.mypac.Member;
import test.mypac.Student;

public class MainClass01 {
	
	public static void main(String[] args) {
		
		Student s1=new Student();
		s1.study();
		
		new Student().study();
		new Student().goSchool();
		
		Member m1=new Member(1, "김구라", "노량진");
		Member m2=new Member(2, "해골", "행신동");
		Member m3=new Member();
	}
}








