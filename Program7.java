//add jar file my sql connector to build path and change url  , name and password of your databses accordingly

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Program7 implements ActionListener {

	JFrame jf = new JFrame("login page");

	JLabel jlb1 = new JLabel("login id : ");
	JTextField jtf1 = new JTextField("", 20);

	JLabel jlb2 = new JLabel("user name : ");
	JTextField jtf2 = new JTextField("", 20);

	JLabel jlb3 = new JLabel("password : ");
	JTextField jtf3 = new JTextField("", 20);

	JButton jbtn = new JButton("insert");

	Program7() {
		jf.add(jlb1);
		jf.add(jtf1);
		jf.add(jlb2);
		jf.add(jtf2);
		jf.add(jlb3);
		jf.add(jtf3);

		jf.add(jbtn);
		jf.setSize(500, 500);

		jf.setLayout(new GridLayout(0, 2));

		jf.setVisible(true);

		jbtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String id = jtf1.getText();
		String name = jtf2.getText();
		String password = jtf3.getText();

		Connection myConnection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;

		String dburl = "jdbc:mysql://localhost:3306/java?useSSL=false";
		String username = "springstudent";
		String pasword = "springstudent";
		try {
			myConnection = DriverManager.getConnection(dburl, username, pasword);
			myStatement = myConnection.prepareStatement("insert into login values (?,?,?)");
			myStatement.setString(1, id);
			myStatement.setString(2, name);
			myStatement.setString(3, password);

			int numberOfRowsEffected = myStatement.executeUpdate();
			if (numberOfRowsEffected > 0) {
				JOptionPane.showMessageDialog(jf, "inserted succesfully");
			} else {
				JOptionPane.showMessageDialog(jf, "insert carefully");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Program7();

	}
}
