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
		fl = new JMenu("����ѡ��");
		jmb.add(fl);
		help = new JMenu("����");
		jmb.add(help);
		fl.add(jz = new JMenuItem("¼��ѧ��������Ϣ"));
		jz.addActionListener(this);
		fl.add(jx = new JMenuItem("�޸�ѧ��������Ϣ"));
		jx.addActionListener(this);
		fl.add(jc = new JMenuItem("��ѯѧ��������Ϣ"));
		jc.addActionListener(this);
		fl.add(js = new JMenuItem("ɾ��ѧ��������Ϣ"));
		js.addActionListener(this);
		help.add(jmiback = new JMenuItem("��ҳ"));
		jmiback.addActionListener(this);
		c = new CardLayout();
		jp1 = new JPanel();
		jp1 = new JPanel();
		jp1.setLayout(c);
		JLabel jlab = new JLabel("��ӭʹ��ѧ��������Ϣ����ϵͳ", JLabel.CENTER);
		f1 = new Font("΢���ź�", Font.BOLD, 30);
		jlab.setFont(f1);
		jp1.add("a1", jlab);
		jp1.add("Zongjia", new Luru(file));
		jp1.add("Xiugai", new Xiugai(file));
		jp1.add("Shanchu", new Shanchu(file));
		this.add(jp1);

		setTitle("ѧ������ϵͳ");
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