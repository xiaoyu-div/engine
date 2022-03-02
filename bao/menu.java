package bao;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class menu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem jz, jx, jc, js, jmiback;
	JPanel jp1, jp2;
	CardLayout c;
	JMenuBar jmb;
	JMenu fl, help;
	Font f1;
	private File file=null;

	menu() {
		File file=new File("aa.txt");
		jmb = new JMenuBar();
		setJMenuBar(jmb);
		fl = new JMenu("功能选择");
		jmb.add(fl);
		help = new JMenu("帮助");
		jmb.add(help);
		fl.add(jz = new JMenuItem("录入学生基本信息"));
		jz.addActionListener(this);
		fl.add(jx = new JMenuItem("修改学生基本信息"));
		jx.addActionListener(this);
		fl.add(jc = new JMenuItem("查询学生基本信息"));
		jc.addActionListener(this);
		fl.add(js = new JMenuItem("删除学生基本信息"));
		js.addActionListener(this);
		help.add(jmiback = new JMenuItem("首页"));
		jmiback.addActionListener(this);
		c = new CardLayout();
		jp1 = new JPanel();
		jp1 = new JPanel();
		jp1.setLayout(c);
		JLabel jlab = new JLabel("欢迎使用学生基本信息管理系统", JLabel.CENTER);
		f1 = new Font("微软雅黑", Font.BOLD, 30);
		jlab.setFont(f1);
		jp1.add("a1", jlab);
		jp1.add("Zongjia", new Luru(file));
		jp1.add("Xiugai", new Xiugai(file));
		jp1.add("Shanchu", new Shanchu(file));
		this.add(jp1);

		setTitle("学生管理系统");
		setSize(500, 500);
		setLocation(450, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new menu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jz) {
			c.show(jp1, "Zongjia");
		}
		if (e.getSource() == jx) {
			c.show(jp1, "Xiugai");
		}
		if (e.getSource() == js) {
			c.show(jp1, "Shanchu");
		}
		if (e.getSource() == jc) {
			new Chaxun(file);
		}
		if (e.getSource() == jmiback) {
			c.show(jp1, "a1");
		}
	}
}