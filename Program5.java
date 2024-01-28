import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.*;

import javax.swing.*;

class Product {

	String name;
	float price;

	Product(String name, float price) {
		this.name = name;
		this.price = price;
	}
}

public class Program5 implements ActionListener {

	static HashMap<Integer, String> cust = new HashMap<>();

	static HashMap<Integer, Product> produ = new HashMap<>();

	static int id = 2;

	JFrame jf = new JFrame("Title");

	JLabel jl1 = new JLabel("Phone Number");
	JTextField jt1 = new JTextField("", 10);

	JButton jb1 = new JButton("Submit");

	JLabel jl2 = new JLabel("Select Products:");
	String[] Products = { "1-Brush", "2-Paste" };
	JComboBox jcb1 = new JComboBox<>(Products);

	JLabel jl3 = new JLabel("Quantity");
	JTextField jt2 = new JTextField("", 10);

	JButton jb2 = new JButton("Select");

	JLabel jl4 = new JLabel("Select Discount:");
	Integer[] disc = { 5, 10 };
	JComboBox jcb2 = new JComboBox<>(disc);

	JButton jb3 = new JButton("Apply");

	float cost = 0;

	String prod;

	Program5() {

		jf.add(jl1);

		jf.add(jt1);

		jf.add(jb1);

		jf.add(jl2);

		jf.add(jcb1);

		jf.add(jl3);

		jf.add(jt2);

		jf.add(jb2);

		jf.add(jl4);

		jf.add(jcb2);

		jf.add(jb3);

		jf.setSize(500, 300);

		jf.setLayout(new GridLayout(0, 3));

		jf.setVisible(true);

		jb1.addActionListener(this);

		jb2.addActionListener(this);

		jb3.addActionListener(this);

	}

	public static void main(String[] args) {

		Product p1 = new Product("1-Brush", 50);

		Product p2 = new Product("2-Paste", 50);

		produ.put(1, p1);

		produ.put(2, p2);

		cust.put(1, "8660676432");

		cust.put(2, "9353620448");

		new Program5();

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		if (e.getSource() == jb1) {

			String phno = jt1.getText();

			if (cust.containsValue(phno)) {

				JOptionPane.showMessageDialog(jf, "Welcome " + phno);

			} else {

				cust.put(id++, phno);

				JOptionPane.showMessageDialog(jb1, "Your number added Happy Shopping");

			}

		}

		if (e.getSource() == jb2) {

			Integer qty = Integer.parseInt(jt2.getText());

			prod = (String) jcb1.getSelectedItem();

			for (Map.Entry<Integer, Product> m : produ.entrySet()) {

				if (prod.equals(m.getValue().name)) {

					cost = qty * m.getValue().price;
				}
			}
			JOptionPane.showMessageDialog(jf, "Prod:" + prod + "\nTotal Cost:" + cost);
		}

		if (e.getSource() == jb3) {

			Integer disc = (Integer) jcb2.getSelectedItem();

			float discount = 100 - disc;

			float finalp = (discount * cost) / 100;

			JOptionPane.showMessageDialog(jf, "After Discount:\n" + "Prod:" + prod + "\nTotal Cost:" + finalp);

		}
	}
}
