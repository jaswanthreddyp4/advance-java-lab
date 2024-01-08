package javaSwing;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class RetailSystem {

	private static Map<String, String> users = new HashMap<>();
	private static Map<String, String> customers = new HashMap<>();
	private static Map<String, String> items = new HashMap<>();

	static {
		// Sample users for login validation
		users.put("jaswanth", "stu123");
		users.put("swatantra", "stu999");

		// Sample items (itemID, itemName)
		items.put("1", "punugulu");
		items.put("2", "rava dosa");

		// Sample customers (mobileNumber, customerID)
		customers.put("9490136745", "C001");
		customers.put("8309455634", "C002");
	}

	public static void main(String[] args) {
		// Login Dialog
		String username = JOptionPane.showInputDialog("Enter Username:");
		String password = JOptionPane.showInputDialog("Enter Password:");

		if (validateLogin(username, password)) {
			processCustomerDetails();
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
		}
	}

	private static boolean validateLogin(String username, String password) {
		return users.containsKey(username) && users.get(username).equals(password);
	}

	private static void processCustomerDetails() {
		String customerId = JOptionPane.showInputDialog("Enter Customer ID or Mobile Number:");
		if (!customers.containsKey(customerId)) {
			JOptionPane.showMessageDialog(null, "New Customer. Adding to system.");
			customers.put(customerId, "C" + (customers.size() + 1));
		}

		String itemId = JOptionPane.showInputDialog("Enter Item ID:");
		String quantityStr = JOptionPane.showInputDialog("Enter Quantity:");
		int quantity = Integer.parseInt(quantityStr);

		if (items.containsKey(itemId)) {
			String itemName = items.get(itemId);
			int totalCost = calculateCost(itemId, quantity); // Implement this method based on your pricing logic

			JOptionPane.showMessageDialog(null, "Item: " + itemName + "\nTotal Cost: " + totalCost);

			String[] discounts = { "Discount 1", "Discount 2", "Discount 3" };
			int discountType = JOptionPane.showOptionDialog(null, "Select a discount type", "Discount",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, discounts, discounts[0]);

			JOptionPane.showMessageDialog(null, "Print Receipt\nCustomer ID: " + customerId + "\nItem: " + itemName
					+ "\nTotal Cost: " + totalCost + "\nDiscount: " + discounts[discountType]);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Item ID");
		}
	}

	private static int calculateCost(String itemId, int quantity) {
		// Sample pricing logic
		return 100 * quantity; // Assuming each item costs 100
	}
}
