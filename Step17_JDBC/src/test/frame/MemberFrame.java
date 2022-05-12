package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;
/*
 *  //1. 선택된 row  인덱스를 읽어온다.
	int selectedIndex=table.getSelectedRow();
	
	//2. 선택된 row 의 첫번째(0번째) 칼럼의 숫자를 읽어온다 (삭제할 회원의 번호)
	int num=(int)model.getValueAt(selectedIndex, 0);
	
	
	-------------------------------------
	
	List<MemberDto>  list=dao.getList();
	
	for(MemberDto tmp:list){
		Object[] row={tmp.getNum(), tmp.getName(), tmp.getAddr()};
		model.addRow(row);
	}
 * 
 */
public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{
	//필드
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;
	
	
	//생성자
	public MemberFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("이름");
		inputName=new JTextField(10);
		
		JLabel label2=new JLabel("주소");
		inputAddr=new JTextField(10);
		
		JButton saveBtn=new JButton("저장");
		saveBtn.setActionCommand("save");
		
		//삭제 버튼 추가
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		//표형식으로 정보를 출력하기 위한 JTable
		table=new JTable();
		//칼럼명을 String[] 에 순서대로 준비
		String[] colNames= {"번호", "이름", "주소"};
		//테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 갯수)
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+" | "+column);
				
				if(column==0) { // 0번째 칼럼은 
					return false; //수정 불가하게 false 를 리턴해 준다.
				}else { //다른 경우는 
					return true; //모두 수정 가능하게 true 를 리턴해 준다. 
				}
			}
		};
		
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
		JScrollPane scroll=new JScrollPane(table);
		//JScrollPane  을 프레임의 가운데에 배치하기 
		add(scroll, BorderLayout.CENTER);
		
		displayMember();
		
		//버튼에 액션리스너 등록
		saveBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		//테이블에 값이 바뀌었는지 감시할 리스너 등록
		table.addPropertyChangeListener(this);
	}
	
	//테이블에 데이터 출력하는 메소드
	public void displayMember() {
		
		model.setRowCount(0); //테이블에 출력된 데이터 reset 
		
		//실제 DB 에 저장된 데이터
		MemberDao dao=new MemberDao();
		List<MemberDto> list=dao.getList();
		
		for(MemberDto tmp:list) {
			//MemberDto 객체에 있는 회원 정보를 이용해서  Object 배열을 만든다 
			Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			//row 를 추가한다.
			model.addRow(row);
		}
		
	}
	
	
	//main  메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 값을 읽어와서 
		String command=e.getActionCommand();
		//분기한다. 
		if(command.equals("save")) {
			//1. 입력한 이름과, 주소를 읽어온다.
			String name=inputName.getText();
			String addr=inputAddr.getText();
			//2. 읽어온 이름과 주소를 MemberDto 객체를 생성해서 담는다.
			MemberDto dto=new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			//3. MemberDao 객체를 이용해서 DB 에 저장을 한다. 
			MemberDao dao=new MemberDao();
			dao.insert(dto);
			//4. refresh ! 
			displayMember();
		}else if(command.equals("delete")) {
			//1. 선택한 row 가 있는지 , 있다면 어떤 row 를 선택했는지 알아내기
			//int selectedIndex=table.getSelectedRow();
			int[] rows=table.getSelectedRows();
			if(rows.length == 0) {
				//선택된 row 가 없다고 알려준다.
				JOptionPane.showMessageDialog(this, "선택된 row 가 없습니다.");
				//프레임아 밑에 코드는 실행하지마!
				return; 
			}
			
			for(int tmp:rows) {
				//2.선택한 row 의 가장 첫번째 칼럼에 있는 숫자를 읽어내기
				int num=(int)model.getValueAt(tmp, 0);
				//3. MemberDao 객체를 이용해서 DB 에서 삭제
				MemberDao dao=new MemberDao();
				dao.delete(num);
			}
			
			//4. refresh
			displayMember();
		}
	}

	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("property change!");
		System.out.println("property name:"+evt.getPropertyName());
		
		System.out.println("isEditing:"+table.isEditing());
		/*
		 *  property name 이 "tableCellEditor" 이고
		 *  table 이 수정중이 아닐때 
		 *  현재 포커스가 있는 곳의 정보를 모두 읽어와서 DB 에 수정반영하기 
		 */
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
			//현재 포커스가 있는 row 의 정보를 DB 에 수정 반영 한다. 
			//변화된 값을 읽어와서 DB 에 반영한다. 
			//수정된 칼럼에 있는 row  전체의 값을 읽어온다. 
			int selectedIndex=table.getSelectedRow();
			int num=(int)model.getValueAt(selectedIndex, 0);
			String name=(String)model.getValueAt(selectedIndex, 1);
			String addr=(String)model.getValueAt(selectedIndex, 2);
			//수정할 회원의 정보를 MemberDto 객체에 담고 
			MemberDto dto=new MemberDto(num, name, addr);
			//DB에 저장하기 
			new MemberDao().update(dto);
			//선택된 포커스 clear
			table.clearSelection();
		}
	
	}
}









