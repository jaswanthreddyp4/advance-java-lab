
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

class Employee {

    String empName;
    int empAge;
    int noOfFamilyMembers;
    String address;

    public Employee(String empName, int empAge, int noOfFamilyMembers, String address) {
        super();
        this.empName = empName;
        this.empAge = empAge;
        this.noOfFamilyMembers = noOfFamilyMembers;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empAge=" + empAge + ", noOfFamilyMembers=" + noOfFamilyMembers
                + ", address=" + address + "]";
    }

}

public class Program6 implements ActionListener {

    List<Employee> empList = new ArrayList<>();

    JFrame jf = new JFrame("employee details taker");

    JButton jbtn = new JButton("store");

    JLabel jlb1 = new JLabel("name : ");
    JTextField jtf1 = new JTextField("", 20);

    JLabel jlb2 = new JLabel("age : ");
    JTextField jtf2 = new JTextField("", 20);

    JLabel jlb3 = new JLabel("address : ");
    JTextField jtf3 = new JTextField("", 20);

    JLabel jlb4 = new JLabel("size : ");
    JTextField jtf4 = new JTextField("", 20);

    JLabel jlb5 = new JLabel("pay scale : ");
    JComboBox<String> jcmb1 = new JComboBox<>(new String[]{"100000", "200000", "300000", "400000"});

    JLabel jlb6 = new JLabel("gender : ");
    JComboBox<String> jcmb2 = new JComboBox<>(new String[]{"male", "female", "other"});

    Program6() {

        jf.add(jlb1);
        jf.add(jtf1);
        jf.add(jlb2);
        jf.add(jtf2);
        jf.add(jlb3);
        jf.add(jtf3);
        jf.add(jlb4);
        jf.add(jtf4);
        jf.add(jlb5);
        jf.add(jcmb1);
        jf.add(jlb6);
        jf.add(jcmb2);

        jf.add(jbtn);

        jf.setSize(500, 500);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));

        jf.setVisible(true);

        jbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbtn) {
            String employeeName = jtf1.getText();
            String age = jtf2.getText();
            int employeeAge = Integer.parseInt(age);
            String employeeAddress = jtf3.getText();
            String size = jtf4.getText();
            int employeeFamilysize = Integer.parseInt(size);

            String payment = (String) jcmb1.getSelectedItem();
            double empPmt = Double.parseDouble(payment);

            String gender = (String) jcmb2.getSelectedItem();

            if (employeeAge > 22 && employeeAge < 60) {

                empList.add(new Employee(employeeName, employeeAge, employeeFamilysize, employeeAddress));
            } else {
                JOptionPane.showMessageDialog(jf, "please enter valid age for faculty");
            }

            for (Employee emp : empList) {
                JOptionPane.showMessageDialog(jf, emp + " " + payment + " " + gender);
            }

        }

    }

    public static void main(String[] args) {
        new Program6();
    }

}
