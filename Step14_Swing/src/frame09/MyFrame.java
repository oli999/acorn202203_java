package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener, KeyListener{
	JTextField inputMsg;
	JLabel lab1;
	//생성자
	public MyFrame(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		inputMsg=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		lab1=new JLabel("JLabel 입니다.");
		
		add(inputMsg);
		add(sendBtn);
		add(lab1);
		//버튼에 리스너 등록하기 
		sendBtn.addActionListener(this);
		//키리스너 등록하기 
		inputMsg.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		JFrame f=new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,  100, 500, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		send();
	}
	
	//메소드 추가
	public void send() {
		//1. JTextField 에 입력한 문자열 읽어오기 
		String msg=inputMsg.getText();
		//2. 읽어온 문자열을 JLable 에 출력하기 
		lab1.setText(msg);
		//3. 입력창 삭제
		inputMsg.setText("");
		//4. 포커스 주기
		inputMsg.grabFocus();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		System.out.println("이것도 되나");
		System.out.println(e.getKeyCode());
		//만일 눌러진 키의 코드값이 엔터키의 코드값이라면 
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			send();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}





