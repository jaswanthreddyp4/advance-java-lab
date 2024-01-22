import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Pgm10 implements ActionListener {

	JFrame jf = new JFrame("patient medi info");

	JLabel jlb1 = new JLabel("patientId");
	JTextField jtf1 = new JTextField("", 20);

	JLabel jlb2 = new JLabel("patient name");
	JTextField jtf2 = new JTextField("", 20);

	JLabel jlb3 = new JLabel("patient age");
	JTextField jtf3 = new JTextField("", 20);

	JLabel jlb5 = new JLabel("medicine id");
	JTextField jtf5 = new JTextField("", 20);

	JLabel jlb6 = new JLabel("medicine name");
	JTextField jtf6 = new JTextField("", 20);

	JLabel jlb7 = new JLabel("purpose");
	JTextField jtf7 = new JTextField("", 20);

	JLabel jlb8 = new JLabel("enter medicine name");
	JTextField jtf8 = new JTextField("", 20);

	JLabel jlb9 = new JLabel("enter type of treatment");
	JTextField jtf9 = new JTextField("", 20);

	JButton jbtn1 = new JButton("patient entry");
	JButton jbtn2 = new JButton("medicine entry");
	JButton jbtn3 = new JButton("retrive");

	Pgm10() {
		jf.add(jlb1);
		jf.add(jtf1);
		jf.add(jlb2);
		jf.add(jtf2);
		jf.add(jlb3);
		jf.add(jtf3);
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

		jf.add(jbtn1);
		jf.add(jbtn2);
		jf.add(jbtn3);

		jf.setSize(500, 500);
		jf.setLayout(new GridLayout(0, 2));

		jf.setVisible(true);

		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		jbtn3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn1) {
			String patId = jtf1.getText();
			String patName = jtf2.getText();
			String patAge = jtf3.getText();

			String dburl = "jdbc:mysql://localhost:3306/java";
			String username = "springstudent";
			String password = "springstudent";

			Connection myConn = null;
			PreparedStatement myStmnt = null;
			ResultSet rs = null;

			try {
				myConn = DriverManager.getConnection(dburl, username, password);

				myStmnt = myConn.prepareStatement("insert into patient values (?,?,?)");
				myStmnt.setString(1, patId);
				myStmnt.setString(2, patName);
				myStmnt.setString(3, patAge);

				int noOfRowsEffected = myStmnt.executeUpdate();
				if (noOfRowsEffected > 0) {
					JOptionPane.showMessageDialog(jf, "patient details entered nanba");
				} else {
					JOptionPane.showMessageDialog(jf, "give ccorrect details");
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		if (e.getSource() == jbtn2) {
			String medId = jtf5.getText();
			String medName = jtf6.getText();
			String medPurpose = jtf7.getText();

			String dburl = "jdbc:mysql://localhost:3306/java";
			String username = "springstudent";
			String password = "springstudent";

			Connection myConn = null;
			PreparedStatement myStmnt = null;
			ResultSet rs = null;

			try {
				myConn = DriverManager.getConnection(dburl, username, password);

				myStmnt = myConn.prepareStatement("insert into medicine values (?,?,?)");
				myStmnt.setString(1, medId);
				myStmnt.setString(2, medName);
				myStmnt.setString(3, medPurpose);

				int noOfRowsEffected = myStmnt.executeUpdate();
				if (noOfRowsEffected > 0) {
					JOptionPane.showMessageDialog(jf, "medicine details entered nanba");
				} else {
					JOptionPane.showMessageDialog(jf, "give ccorrect details");
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		if (e.getSource() == jbtn3) {
			String mediName = jtf8.getText();
			String treatment = jtf9.getText();

			String dburl = "jdbc:mysql://localhost:3306/java";
			String username = "springstudent";
			String password = "springstudent";

			Connection myConn = null;
			PreparedStatement myStmnt = null;
			ResultSet rs = null;

			try {
				myConn = DriverManager.getConnection(dburl, username, password);

				myStmnt = myConn.prepareStatement(
						"select * from patient where pid in(select pid from patientmedicine where mid in (select mid from medicine where medicine_name=?) and treatment=?)");
				myStmnt.setString(1, mediName);
				myStmnt.setString(2, treatment);

				rs = myStmnt.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new Pgm10();
	}

}
