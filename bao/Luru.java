package bao;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;

import javax.swing.*;

public class Luru extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField id,name,sex,zy,nj,cs;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2, jb3;
	private String jl1Value, jl2Value, jl3Value, jl4Value, jl5Value, jl6Value;
	private File file = null;
	private Hashtable<String, student> hasht = new Hashtable<String, student>();
	private student stu;

	Luru(File file) {
		this.file = file;
		new File("aa.txt");
		id = new JTextField(15);
		name = new JTextField(15);
		sex = new JTextField(15);
		zy = new JTextField(15);
		nj = new JTextField(15);
		cs = new JTextField(15);

		jl1 = new JLabel("ѧ��:");
		jl2 = new JLabel("����:");
		jl3 = new JLabel("�Ա�:");
		jl4 = new JLabel("רҵ:");
		jl5 = new JLabel("����:");
		jl6 = new JLabel("����:");

		jb1 = new JButton("¼��");
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			if (!isIDValue())
				return;
			stu = new student(jl1Value, jl2Value, jl3Value, jl4Value, jl5Value, jl6Value);
			int ok = JOptionPane.showConfirmDialog(this, "��Ҫ¼������,ȷ�ϣ�", "��ʾ", JOptionPane.YES_NO_OPTION);
			if (ok == JOptionPane.YES_OPTION) {
				try {
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);// ������
					hasht.put(jl1Value, stu);
					oos.writeObject(hasht);
					fos.close();
					oos.close();
					// ���
					textClose();
					showMessageDialog("¼��ɹ�");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("IOException");
				}
			} else {
				showMessageDialog("ȡ������");
			}
		}
		if (e.getSource() == jb2) {
			textClose();
			showMessageDialog("���óɹ�");
		}
	}
	public void textClose() {
		name.setText(null);
		sex.setText(null);
		zy.setText(null);
		nj.setText(null);
		cs.setText(null);
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public boolean isIDValue() {
		jl1Value = id.getText();
		jl2Value = name.getText();
		jl3Value = sex.getText();
		jl4Value = zy.getText();
		jl5Value = nj.getText();
		jl6Value = cs.getText();
		if (jl1Value.equals("")) {
			showMessageDialog("ѧ�Ų���Ϊ��");
			return false;
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			hasht = (Hashtable<String, student>) ois.readObject();
		} catch (IOException e1) {
			System.out.println("IOException");
		}
		 catch (Exception e) {
			System.out.println("ClassNotFoundException");
			}
		if (hasht.containsKey(jl1Value)) {
			showMessageDialog("��ѧ���Ѵ���");
			return false;
		}
		return true;
	}
	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(this, message, " �� ʾ ", JOptionPane.INFORMATION_MESSAGE);
	}
}