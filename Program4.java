import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

class Student {
	String name;
	String usn;
	int age;
	String address;

	public Student(String name, String usn, int age, String address) {
		super();
		this.name = name;
		this.usn = usn;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", usn=" + usn + ", age=" + age + ", address=" + address + "]";
	}

}

public class Program4 implements ActionListener {

	int i = 1;

	Map<Integer, Student> map = new HashMap<>();

	JFrame jf = new JFrame("student information portal");

	JButton jb1 = new JButton("store");
	JButton jb2 = new JButton("compute");
	JButton jb3 = new JButton("display");

	JLabel jlb1 = new JLabel("name : ");
	JTextField jtf1 = new JTextField("", 20);

	JLabel jlb2 = new JLabel("usn : ");
	JTextField jtf2 = new JTextField("", 20);

	JLabel jlb3 = new JLabel("age : ");
	JTextField jtf3 = new JTextField("", 20);

	JLabel jlb4 = new JLabel("address : ");
	JTextField jtf4 = new JTextField("", 20);

	JLabel jlb5 = new JLabel("sem 1 sgpa : ");
	JTextField jtf5 = new JTextField("", 20);

	JLabel jlb6 = new JLabel("sem 2 sgpa : ");
	JTextField jtf6 = new JTextField("", 20);

	JLabel jlb7 = new JLabel("sem 3 sgpa : ");
	JTextField jtf7 = new JTextField("", 20);

	JLabel jlb8 = new JLabel("sem 4 sgpa : ");
	JTextField jtf8 = new JTextField("", 20);

	Program4() {
		jf.add(jlb1);
		jf.add(jtf1);
		jf.add(jlb2);
		jf.add(jtf2);
		jf.add(jlb3);
		jf.add(jtf3);
		jf.add(jlb4);
		jf.add(jtf4);
		jf.add(jlb5);
		jf.add(jtf5);
		jf.add(jlb6);
		jf.add(jtf6);
		jf.add(jlb7);
		jf.add(jtf7);
		jf.add(jlb8);
		jf.add(jtf8);

		jf.add(jb1);
		jf.add(jb2);
		jf.add(jb3);

		jf.setSize(500, 500);
		jf.setLayout(new FlowLayout(FlowLayout.LEFT));

		jf.setVisible(true);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// to store students info into map
		if (e.getSource() == jb1) {
			String name = jtf1.getText();
			String usn = jtf2.getText();
			String oldAge = jtf3.getText();
			int newAge = Integer.parseInt(oldAge);
			String address = jtf4.getText();

			map.putIfAbsent(i, new Student(name, usn, newAge, address));
			i++;
			JOptionPane.showMessageDialog(jf, "student values entered");

		}

		// to display student details in messagepane
		if (e.getSource() == jb3) {
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<Integer, Student> en : map.entrySet()) {
				sb.append(en);
			}
			JOptionPane.showMessageDialog(jf, sb.toString() + "\n");
			
		}
		
		// cgpa and stuff
		if(e.getSource()== jb2) {
			
			String oldAge=jtf3.getText();
			int newAge=Integer.parseInt(oldAge);
			if(newAge < 18 || newAge>=30) {
				JOptionPane.showMessageDialog(jf, "invalid age , please enter correct age");
			}

			double sgp1=Double.parseDouble(jtf5.getText());
			double sgp2=Double.parseDouble(jtf6.getText());
			double sgp3=Double.parseDouble(jtf7.getText());
			double sgp4=Double.parseDouble(jtf8.getText());
			
			if(sgp1 >10 || sgp2>10 || sgp3>10 || sgp4>10) {
				JOptionPane.showMessageDialog(jf," enter valid sgpa");
			}
			
			double cgpa=(sgp1+sgp2+sgp3+sgp4)/4;
			
			JOptionPane.showMessageDialog(jf,"cgpa : "+cgpa);
			
		}

	}

	public static void main(String[] args) {
		new Program4();
	}

}
