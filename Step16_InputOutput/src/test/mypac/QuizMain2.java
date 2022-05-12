package test.mypac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 1. JTextField�� ���ڿ��� �Է��ϰ� �߰� ��ư�� ������
 * �Է��� ���ڿ��� myFolder/memo.txt ���Ͽ� append �ǵ��� �غ�����.
 * 
 * 2. �ҷ����� ��ư�� ������ myFolder/memo.txt ���Ͽ� �ִ� ��� ���ڿ���
 * JTextArea�� ����ϵ��� �غ�����.
 * 
 */

public class QuizMain2 extends JFrame implements ActionListener{
   //�ʵ�
   JTextField tf_msg;
   JTextArea area;
   JButton appendBtn;
   JButton loadBtn;
   //������
   public QuizMain2() {
      setTitle("���� ������");
      setLayout(new BorderLayout());
      
      JPanel topPanel=new JPanel();
      //JTextField ��ü�� �������� �ʵ忡 ���� 
      tf_msg=new JTextField(10);
      
      appendBtn=new JButton("�߰��ϱ�");
      loadBtn=new JButton("�ҷ�����");
      appendBtn.setActionCommand("append");
      loadBtn.setActionCommand("load");
      
      
      topPanel.add(tf_msg);
      topPanel.add(appendBtn);
      topPanel.add(loadBtn);
      
      appendBtn.addActionListener(this);
      loadBtn.addActionListener(this);
      
      add(topPanel, BorderLayout.NORTH);
      topPanel.setBackground(Color.YELLOW);
      
      //JTextArea
      area=new JTextArea();
      //�������� ����� JTextArea  ��ġ�ϱ�
      add(area, BorderLayout.CENTER);
   
   }
   
    public static void main(String[] args) {
      QuizMain2 f=new QuizMain2();
      f.setBounds(100, 100, 500, 500);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();
      String data = tf_msg.getText(); 
            
      FileWriter fw=null;
      if (o==appendBtn) {
         try {
            fw=new FileWriter("c:/acorn202203/myFolder/memo.txt",true);
            fw.write("\r\n");
            fw.write(data);
            fw.flush();
            System.out.println("���Ͽ� �߰��߽��ϴ�.");
         } catch (IOException e1) {
            e1.printStackTrace();
         }finally {
            try {
               fw.close();
            } catch (Exception e1) {
               
            }
         }
         
      }else {
         File f1 = new File("c:/acorn202203/myFolder/memo.txt");
         FileReader fr = null;
         BufferedReader bfr = null;
         
         try {
            fr = new FileReader(f1);
             bfr = new BufferedReader(fr);
             
             while(true) {
                String line = bfr.readLine();
                if(line==null) {
                   break;
                }
                area.setText(line);
             }
            
         } catch (IOException e1) {
            e1.printStackTrace();
         }finally {
            try {
               if(fr!=null)fr.close();
               if(bfr!=null)bfr.close();
            } catch (Exception e2) {
               e2.printStackTrace();
            }
         }
      }
   
   }
   }