package bao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Hashtable;

import javax.swing.*;

public class Chaxun extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField id,name,sex,zy,nj,cs;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2, jb3;
	private String jl1Value;
	private File file = null;
	private Hashtable<String, student> hasht = new Hashtable<String, student>();
	private student stu;

	Chaxun(File file) {
		this.file = file;
		id = new JTextField(15);
		name = new JTextField(15);
		sex = new JTextField(15);
		zy = new JTextField(15);
		nj = new JTextField(15);
		cs = new JTextField(15);
		
		name.setEditable(false);
		sex.setEditable(false);
		zy.setEditable(false);
		nj.setEditable(false);
		cs.setEditable(false);

		jl1 = new JLabel("������ѧ��:");
		jl2 = new JLabel("����:");
		jl3 = new JLabel("�Ա�:");
		jl4 = new JLabel("רҵ:");
		jl5 = new JLabel("����:");
		jl6 = new JLabel("����:");

		jb1 = new JButton("��ѯ");
		jb1.addActionListener(this);
		jb2 = new JButton("����");
		jb2.addActionListener(this);

		Box box1 = Box.createHorizontalBox();
		box1.add(jl1);
		box1.add(id);
		Box box2 = Box.createHorizontalBox();
		box2.add(jl2);
		box2.add(name);
		Box box3 = Box.createHorizontalBox();
		box3.add(jl3);
		box3.add(sex);
		Box box4 = Box.createHorizontalBox();
		box4.add(jl4);
		box4.add(zy);
		Box box5 = Box.createHorizontalBox();
		box5.add(jl5);
		box5.add(nj);
		Box box6 = Box.createHorizontalBox();
		box6.add(jl6);
		box6.add(cs);
		Box box7 = Box.createHorizontalBox();
		box7.add(jb1);
		box7.add(jb2);
		Box boxH = Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		boxH.add(Box.createVerticalGlue());
		this.add(boxH);
		this.setVisible(true);
		this.setTitle("��ѯѧ������");
		this.setSize(300, 400);
		this.setLayout(new FlowLayout());
	}
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb2) {
			textClose();
			showMessageDialog("���óɹ�");
		}
		if (e.getSource() == jb1) {
			textClose();
			if (!isIDValue())
			return;
			try {
				file=new File("aa.txt");
			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(fis);
			hasht = (Hashtable<String, student>) ois.readObject();
			stu = (student) hasht.get(jl1Value);
			if (stu == null) {
			showMessageDialog("δ�鵽����");
			return;
			}
			name.setText(stu.getName());
			sex.setText(stu.getSex());
			zy.setText(stu.getZy());
			nj.setText(stu.getNj());
			cs.setText(stu.getCs());
			showMessageDialog("��ѯ�ɹ�");
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("ClassNotFoundException");
			}
			}
		
		}
			public void textClose() {
			name.setText(null);
			sex.setText(null);
			zy.setText(null);
			nj.setText(null);
			cs.setText(null);
			}
			public boolean isIDValue() {
			jl1Value = id.getText();
			if (jl1Value.equals("")) {
			showMessageDialog("ѧ�Ų���Ϊ��");
			return false;
			}
			return true;
			}
			public void showMessageDialog(String message) {
			JOptionPane.showMessageDialog(this, message, " �� ʾ ", JOptionPane.INFORMATION_MESSAGE);
			} }