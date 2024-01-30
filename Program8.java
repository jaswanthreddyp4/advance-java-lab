import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Program8 implements ActionListener {

	JFrame jf = new JFrame("swing data");

	// text fields and labels for entering repository information
	JLabel jlb1 = new JLabel("rep no : ");
	JTextField jtf1 = new JTextField("", 20);

	JLabel jlb2 = new JLabel("rep name : ");
	JTextField jtf2 = new JTextField("", 20);

	JLabel jlb3 = new JLabel("state : ");
	JTextField jtf3 = new JTextField("", 20);

	JLabel jlb4 = new JLabel("commission : ");
	JTextField jtf4 = new JTextField("", 20);

	JLabel jlb5 = new JLabel("rate : ");
	JTextField jtf5 = new JTextField("", 20);

	// text fields and labels for entering customer information
	JLabel jlb6 = new JLabel("cust number : ");
	JTextField jtf6 = new JTextField("", 20);

	JLabel jlb7 = new JLabel("cust name : ");
	JTextField jtf7 = new JTextField("", 20);

	JLabel jlb8 = new JLabel("cust state : ");
	JTextField jtf8 = new JTextField("", 20);

	JLabel jlb9 = new JLabel("cust credit limit : ");
	JTextField jtf9 = new JTextField("", 20);

	JLabel jlb10 = new JLabel("rep number : ");
	JTextField jtf10 = new JTextField("", 20);

	JButton jbtn1 = new JButton("repository store");
	JButton jbtn2 = new JButton("customer store");
	JButton jbtn3 = new JButton("display");

	Program8() {

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
		jf.add(jlb9);
		jf.add(jtf9);
		jf.add(jlb10);
		jf.add(jtf10);

		jf.add(jbtn1);
		jf.add(jbtn2);
		jf.add(jbtn3);

		jf.setSize(500, 500);
		jf.setVisible(true);

		jf.setLayout(new GridLayout(0, 2));

		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		jbtn3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn1) {
			String repNo = jtf1.getText();
			String repName = jtf2.getText();
			String state = jtf3.getText();
			String commission = jtf4.getText();
			String rate = jtf5.getText();

			Connection myConnection = null;
			PreparedStatement myStatement = null;
			ResultSet myReultSet = null;

			String dburl = "jdbc:mysql://localhost:3306/java";
			String username = "springstudent";
			String password = "springstudent";

			try {
				myConnection = DriverManager.getConnection(dburl, username, password);

				myStatement = myConnection.prepareStatement("insert into rep values (?,?,?,?,?)");
				myStatement.setString(1, repNo);
				myStatement.setString(2, repName);
				myStatement.setString(3, state);
				myStatement.setString(4, commission);
				myStatement.setString(5, rate);

				int numberOfRowsEffected = myStatement.executeUpdate();
				if (numberOfRowsEffected > 0) {
					JOptionPane.showMessageDialog(jf, "succesfully entered");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		if (e.getSource() == jbtn2) {

			String custNo = jtf6.getText();
			String custName = jtf7.getText();
			String state = jtf8.getText();
			String custLimit = jtf9.getText();
			String repNo = jtf10.getText();

			Connection myConnection = null;
			PreparedStatement myStatement = null;
			ResultSet myResultSet = null;

			String dburl = "jdbc:mysql://localhost:3306/java";
			String username = "springstudent";
			String password = "springstudent";

			try {
				myConnection = DriverManager.getConnection(dburl, username, password);

				myStatement = myConnection.prepareStatement("insert into customer values (?,?,?,?,?)");
				myStatement.setString(1, custNo);
				myStatement.setString(2, custName);
				myStatement.setString(3, state);
				myStatement.setString(4, custLimit);
				myStatement.setString(5, repNo);

				int numberOfRowsEffected = myStatement.executeUpdate();
				if (numberOfRowsEffected > 0) {
					JOptionPane.showMessageDialog(jf, "succesfully entered");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		if (e.getSource() == jbtn3) {

			Connection conn = null;
			PreparedStatement stmnt = null;
			ResultSet rs = null;

			String dburl = "jdbc:mysql://localhost:3306/java";
			String userName = "springstudent";
			String password = "springstudent";

			try {
				conn = DriverManager.getConnection(dburl, userName, password);

				stmnt=conn.prepareStatement("select c.cust_name , r.rep_name , c.state from customer c join rep r on c.state=r.state");
				rs=stmnt.executeQuery();

				StringBuilder sb = new StringBuilder();
				while (rs.next()) {
					sb.append("repository name: " + rs.getString(1) + "\n");
					sb.append("customer name : " + rs.getString(2) + "\n");
					sb.append("state : " + rs.getString(3) + "\n");
					
				}
				
				JOptionPane.showMessageDialog(jf,sb.toString());
			} catch (SQLException ex) {
				ex.printStackTrace();
			}


		}
	}

	public static void main(String[] args) {
		new Program8();

	}

}
