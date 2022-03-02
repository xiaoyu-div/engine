package bao;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.util.Hashtable;
import javax.swing.*;

public class Xiugai extends JPanel implements ActionListener{
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

	Xiugai(File file) {
		this.file = file;
		new File("aa.txt");
		id = new JTextField(15);
		name = new JTextField(15);
		sex = new JTextField(15);
		zy = new JTextField(15);
		nj = new JTextField(15);
		cs = new JTextField(15);

		jl1 = new JLabel("学号:");
		jl2 = new JLabel("姓名:");
		jl3 = new JLabel("性别:");
		jl4 = new JLabel("专业:");
		jl5 = new JLabel("年龄:");
		jl6 = new JLabel("出生:");
		jb1 = new JButton("查询");
		jb1.addActionListener(this);
		jb2 = new JButton("修改");
		jb2.addActionListener(this);
		jb3= new JButton("重置");
		jb3.addActionListener(this);

		Box box1 = Box.createHorizontalBox();
		box1.add(jl1);
		box1.add(id);
		box1.add(jb1);
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
		box7.add(jb2);
		box7.add(jb3);
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
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == jb2) {
			if (!yanZheng())
				return;
			stu = new student(jl1Value, jl2Value, jl3Value, jl4Value, jl5Value, jl6Value);
			int ok = JOptionPane.showConfirmDialog(this, "将要修改数据,确认？", "提示", JOptionPane.YES_NO_OPTION);
			if (ok == JOptionPane.YES_OPTION) {
				try {
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);// 对象流
					hasht.put(jl1Value, stu);
					oos.writeObject(hasht);
					fos.close();
					oos.close();
					// 清空
					textClose();
					showMessageDialog("修改成功");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("IOException");
				}
			} else {
				showMessageDialog("取消操作");
			}
		} if (e.getSource() == jb3) {
			textClose();
			showMessageDialog("重置成功");
		}
		if (e.getSource() == jb1) {
			textClose();
			if (!isIDValue())
			return;
			try {
				
			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(fis);
			hasht = (Hashtable<String, student>) ois.readObject();
			stu = (student) hasht.get(jl1Value);
			if (stu == null) {
			showMessageDialog("未查到数据");
			return;
			}
			name.setText(stu.getName());
			sex.setText(stu.getSex());
			zy.setText(stu.getZy());
			nj.setText(stu.getNj());
			cs.setText(stu.getCs());
			showMessageDialog("查询成功");
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
			showMessageDialog("学号不能为空");
			return false;
			}
			return true;
			}
			public void showMessageDialog(String message) {
			JOptionPane.showMessageDialog(this, message, " 提 示 ", JOptionPane.INFORMATION_MESSAGE);
			}
			@SuppressWarnings("unlikely-arg-type")
			public boolean yanZheng() {
				jl1Value = id.getText();
				jl2Value = name.getText();
				jl3Value = sex.getText();
				jl4Value = zy.getText();
				jl5Value = nj.getText();
				jl6Value = cs.getText();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(this, "学号不能为空", "提示",JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
				return true;
			}
			}