package test.frame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/*
 *  //1. ���õ� row  �ε����� �о�´�.
	int selectedIndex=table.getSelectedRow();
	
	//2. ���õ� row �� ù��°(0��°) Į���� ���ڸ� �о�´� (������ ȸ���� ��ȣ)
	int num=(int)model.getValueAt(selectedIndex, 0);
	
	
	-------------------------------------
	
	List<MemberDto>  list=dao.getList();
	
	for(MemberDto tmp:list){
		Object[] row={tmp.getNum(), tmp.getName(), tmp.getAddr()};
		model.addRow(row);
	}
 * 
 */
public class TestFrame extends JFrame{
	//�ʵ�
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;
	
	//������
	public TestFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("�̸�");
		inputName=new JTextField(10);
		
		JLabel label2=new JLabel("�ּ�");
		inputAddr=new JTextField(10);
		
		JButton saveBtn=new JButton("����");
		saveBtn.setActionCommand("save");
		
		//���� ��ư �߰�
		JButton deleteBtn=new JButton("����");
		deleteBtn.setActionCommand("delete");
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		//ǥ�������� ������ ����ϱ� ���� JTable
		table=new JTable();
		//Į������ String[] �� ������� �غ�
		String[] colNames= {"��ȣ", "�̸�", "�ּ�"};
		//���̺� ����� ������ ������ �ִ� �� ��ü (Į����, row ����)
		model=new DefaultTableModel(colNames, 0);
		//���� ���̺� �����Ѵ�.
		table.setModel(model);
		//��ũ���� ���� �ϵ��� ���̺��� JScrollPane �� ���Ѵ�.
		JScrollPane scroll=new JScrollPane(table);
		//JScrollPane  �� �������� ����� ��ġ�ϱ� 
		add(scroll, BorderLayout.CENTER);
		
		displayMember();
	}
	
	//���̺� ������ ����ϴ� �޼ҵ�
	public void displayMember() {
		
		//model.setRowCount(0); //���̺� ��µ� ������ reset 
		
		Object[] row1= {1, "�豸��", "�뷮��"};
		model.addRow(row1);
		
		Object[] row2= {2, "�ذ�", "��ŵ�"};
		model.addRow(row2);
		
		Object[] row3= {3, "������", "�󵵵�"};
		model.addRow(row3);
		
	}
	
	
	//main  �޼ҵ�
	public static void main(String[] args) {
		TestFrame f=new TestFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
}









