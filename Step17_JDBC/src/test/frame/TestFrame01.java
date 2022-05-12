package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TestFrame01 extends JFrame implements ActionListener, PropertyChangeListener {
   // �ʵ�
   JTextField inputName, inputAddr, inputSearch;
   DefaultTableModel model;
   JTable table;
   JComboBox selectType;
   
   // ������
   public TestFrame01() {
      setLayout(new BorderLayout());

      JLabel label1 = new JLabel("�̸�");
      inputName = new JTextField(10);

      JLabel label2 = new JLabel("�ּ�");
      inputAddr = new JTextField(10);

      JButton saveBtn = new JButton("����");
      saveBtn.setActionCommand("save");

      // ���� ��ư �߰�
      JButton deleteBtn = new JButton("����");
      deleteBtn.setActionCommand("delete");

      JPanel panel = new JPanel();
      panel.add(label1);
      panel.add(inputName);
      panel.add(label2);
      panel.add(inputAddr);
      panel.add(saveBtn);
      panel.add(deleteBtn);

      add(panel, BorderLayout.NORTH);
      
      //panel �� �߰��� ���
      String[] type = {"��ü", "��ȣ", "�̸�"};
      //�˻������ �����ϴµ� �ʿ��� UI �� �����ؼ� 
      selectType = new JComboBox(type);
      inputSearch = new JTextField(10);
      JButton searchBtn = new JButton("�˻�");
      searchBtn.setActionCommand("search");
      //�гο� �߰��ϰ� 
      JPanel panel2 = new JPanel();
      panel2.add(selectType);
      panel2.add(inputSearch);
      panel2.add(searchBtn);
      //�г�°�� �������� ���ʿ� ��ġ�ϱ� 
      add(panel2, BorderLayout.SOUTH);
      

      // ǥ�������� ������ ����ϱ� ���� JTable
      table = new JTable();
      // Į������ String[] �� ������� �غ�
      String[] colNames = { "��ȣ", "�̸�", "�ּ�" };
      // ���̺� ����� ������ ������ �ִ� �� ��ü (Į����, row ����)
      model=new DefaultTableModel(colNames, 0) {
         @Override
         public boolean isCellEditable(int row, int column) {
            System.out.println(row + " | " + column);

            if (column == 0) { // 0��° Į����
               return false; // ���� �Ұ��ϰ� false �� ������ �ش�.
            } else { // �ٸ� ����
               return true; // ��� ���� �����ϰ� true �� ������ �ش�.
            }
         }
      };
      // ���� ���̺� �����Ѵ�.
      table.setModel(model);
      // ��ũ���� ���� �ϵ��� ���̺��� JScrollPane �� ���Ѵ�.
      JScrollPane scroll = new JScrollPane(table);
      // JScrollPane �� �������� ����� ��ġ�ϱ�
      add(scroll, BorderLayout.CENTER);
      Map<String, Object>map = new HashMap<>();
      map.put("Member", null);
      displayMember(map);

      // ��ư�� �׼Ǹ����� ���
      saveBtn.addActionListener(this);
      deleteBtn.addActionListener(this);
      searchBtn.addActionListener(this);

      // ���̺� ���� �ٲ������ ������ ������ ���
      table.addPropertyChangeListener(this);
   }

   // ���̺� ������ ����ϴ� �޼ҵ�
   public void displayMember(Map<String, Object> map) {
      
      if(map.containsKey("Member")) {
         model.setRowCount(0); // ���̺� ��µ� ������ reset
         
         // ���� DB �� ����� ������
         MemberDao dao = new MemberDao();
         List<MemberDto> list = dao.getList();
         
         for (MemberDto tmp : list) {
            // MemberDto ��ü�� �ִ� ȸ�� ������ �̿��ؼ� Object �迭�� �����
            Object[] row = { tmp.getNum(), tmp.getName(), tmp.getAddr() };
            // row �� �߰��Ѵ�.
            model.addRow(row);
         }
      }else if(map.containsKey("MemberByNum")) {
         MemberDto dto = (MemberDto) map.get("MemberByNum");
         model.setRowCount(0);
         model.addRow(new Object[] {dto.getNum(), dto.getName(), dto.getAddr()});
      }else if(map.containsKey("MemberByName")) {
    	 List<MemberDto> list = (List<MemberDto>) map.get("MemberByName");
         model.setRowCount(0);
         for(MemberDto tmp : list) {
            model.addRow(new Object[] {tmp.getNum(), tmp.getName(), tmp.getAddr()});
         }
      }
   }
   
   // main �޼ҵ�
   public static void main(String[] args) {
      TestFrame01 f = new TestFrame01();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBounds(100, 100, 800, 500);
      f.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	  //��ü ����� ������� �ϴ���, �ƴϸ� �˻�� �ִٸ� �(��ȣ, �̸�) �˻��� �ߴ���, �˻� ��� �����͵� ��´�.  
      Map<String, Object> map = new HashMap<>();
      
      // ������ ��ư�� action command ���� �о�ͼ�
      String command = e.getActionCommand();
      // �б��Ѵ�.
      if (command.equals("save")) {
         // 1. �Է��� �̸���, �ּҸ� �о�´�.
         String name = inputName.getText();
         String addr = inputAddr.getText();
         // 2. �о�� �̸��� �ּҸ� MemberDto ��ü�� �����ؼ� ��´�.
         MemberDto dto = new MemberDto();
         dto.setName(name);
         dto.setAddr(addr);
         // 3. MemberDao ��ü�� �̿��ؼ� DB �� ������ �Ѵ�.
         MemberDao dao = new MemberDao();
         dao.insert(dto);
         // 4. refresh !
         inputName.setText("");
         inputAddr.setText("");
         map.put("Member", null);
         displayMember(map);
      } else if (command.equals("delete")) {
         // 1. ������ row �� �ִ��� , �ִٸ� � row �� �����ߴ��� �˾Ƴ���
         // int selectedIndex=table.getSelectedRow();
         int[] rows = table.getSelectedRows();
         if (rows.length == 0) {
            // ���õ� row �� ���ٰ� �˷��ش�.
            JOptionPane.showMessageDialog(this, "���õ� row �� �����ϴ�.");
            inputName.setText("");
            inputAddr.setText("");
            // �����Ӿ� �ؿ� �ڵ�� ����������!
            return;
         }

         for (int tmp : rows) {
            // 2.������ row �� ���� ù��° Į���� �ִ� ���ڸ� �о��
            int num = (int) model.getValueAt(tmp, 0);
            // 3. MemberDao ��ü�� �̿��ؼ� DB ���� ����
            MemberDao dao = new MemberDao();
            dao.delete(num);
         }

         // 4. refresh
         map.put("Member", null);
         displayMember(map);
      } else if (command.equals("search")) {
         
         MemberDao dao = new MemberDao();
         MemberDto dto = new MemberDto();
         //�Է��� �˻�� �о�´�.
         String target = inputSearch.getText();
         
         //�����ڽ��� ���� ���õ� �������� �о�ͼ� �б� �ϱ� 
         if(selectType.getSelectedItem().equals("��ȣ")) {
        	//���� �˻�� �Է����� �ʾ�����
            if(target.isBlank()) {
               JOptionPane.showMessageDialog(this, "�˻�� �Է��ϼ��� !");
               return;
            }
            dto = dao.getData(Integer.parseInt(inputSearch.getText()));
            //���� �˻��� ȸ�� ������ ������ 
            if(dto == null) {
               JOptionPane.showMessageDialog(this, "�ش� ��ȣ�� ȸ���� �����ϴ�.");
               inputSearch.setText("");
               return;
            }
            //Map ��ü�� MemberByNum �̶�� Ű������ �˻���� MemberDto ��ü�� ��� 
            map.put("MemberByNum", dto);
            //�޼ҵ� ȣ���ϸ鼭 Map ��ü�� ���� 
            displayMember(map);
            inputSearch.setText("");
         }else if(selectType.getSelectedItem().equals("�̸�")) {
            if(target.isBlank()) {
               JOptionPane.showMessageDialog(this, "�˻�� �Է��ϼ��� !");
               return;
            }
            List<MemberDto> list = dao.getDataByName(target);
            if(list.size() == 0) {
               JOptionPane.showMessageDialog(this, "�ش� �̸��� ȸ���� �����ϴ�.");
               inputSearch.setText("");
               return;
            }
            map.put("MemberByName", list);
            displayMember(map);
            inputSearch.setText("");
         }else if(selectType.getSelectedItem().equals("��ü")) {
            map.put("Member", "");
            displayMember(map);
            inputSearch.setText("");
         }
      }
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      // TODO Auto-generated method stub
      System.out.println("property change!");
      System.out.println("oldValue:" + evt.getOldValue());
      System.out.println("newValue:" + evt.getNewValue());
      System.out.println("property name:" + evt.getPropertyName());
      
      if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
         //���� ��Ŀ���� �ִ� row �� ������ DB �� ���� �ݿ� �Ѵ�.
         //��ȭ�� ���� �о�ͼ� DB �� �ݿ��Ѵ�. 
            //������ Į���� �ִ� row  ��ü�� ���� �о�´�. 
            int selectedIndex=table.getSelectedRow();
            int num=(int)model.getValueAt(selectedIndex, 0);
            String name=(String)model.getValueAt(selectedIndex, 1);
            String addr=(String)model.getValueAt(selectedIndex, 2);
            //������ ȸ���� ������ MemberDto ��ü�� ��� 
            MemberDto dto=new MemberDto(num, name, addr);
            //DB�� �����ϱ� 
            new MemberDao().update(dto);
            //���õ� ��Ŀ�� clear
            table.clearSelection();
      }
   }
}