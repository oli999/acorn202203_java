package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *  JDBC ( Java DataBase Connectivity )
 *  
 *  DataBase �� �����ؼ� SELECT, INSERT, UPDATE, DELETE �۾��ϱ�
 *  
 *  Oracle �� �����ϱ� ���ؼ��� ����̹� Ŭ������ ����ִ� ojdbc6.jar ������
 *  ����Ҽ� �ֵ��� �����ؾ� �Ѵ�.
 */
public class MainClass04 {
	public static void main(String[] args) {
		/*
		 *  1 �� ȸ���� �̸��� ����ȣ �ּҸ� ������ ���� ������ ������.
		 */
		int num = 1;
      	String name="����ȣ";
      	String addr="������";
      	
		//DB ���ᰴü�� ���� ���� ���� �����
		Connection conn=null;
		
		try {
			//����Ŭ ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//������ DB �� ���� @�������ּ�:port��ȣ:db�̸�
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//���� ��й�ȣ�� �̿��ؼ� Connection ��ü�� ������ ������
			conn=DriverManager.getConnection(url, "scott", "tiger");
			//���ܰ� �߻����� �ʰ� ������� ��������� �������� ���� �����̴�.
			System.out.println("Oracle DB ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//SELECT �۾��� ���ؼ� �ʿ��� ��ü�� �������� ���� �������� �̸� ����� 
		PreparedStatement pstmt=null;
		try {
			//������ �̿ϼ��� sql ��
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			//PreparedStatement ��ü�� ������ ������
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, num);
			//sql �� �����ϱ� 
			pstmt.executeUpdate();
			System.out.println("ȸ�� ������ ���� �߽��ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main �޼ҵ尡 ���� �˴ϴ�.");
		
	}
}















