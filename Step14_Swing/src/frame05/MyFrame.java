package frame05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	//생성자
	public MyFrame(String title) {
		super(title);
		//MyFrame 의 레이아웃 메니저 지정하기
		setLayout(new FlowLayout());
		//버튼
		JButton sendBtn=new JButton("전송");
		JButton removeBtn=new JButton("삭제");
		//프레임에 버튼 추가하기 ( FlowLayout 의 영향을 받는다 )
		add(sendBtn);
		add(removeBtn);
		
		ActionListener listener=new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전송?");
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다~");
			}
		};
		
		sendBtn.addActionListener(listener);
		removeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(MyFrame.this, "삭제 합니다.");
			}
		});
	}
	
	public static void main(String[] args) {
		JFrame f=new MyFrame("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,  100, 500, 500);
		f.setVisible(true);
	}
	
}




