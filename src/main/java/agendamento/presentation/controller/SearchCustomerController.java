package agendamento.presentation.controller;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.AppProvider;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import cliente.presentation.util.CustomerMsg;
import shared.CustomTable;

public class SearchCustomerController {
	private JFrame frame;
	private CustomTable table;
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerDAO dao;
	private CustomerStore customerStore = CustomerStore.getInstance();

	public SearchCustomerController(CustomerDAO dao) {
		this.dao = dao;
	}

	public void setUiItem(JFrame frame, CustomTable table) {
		this.frame = frame;
		this.table = table;
	}

	public void searchCustomer(String customerName) {
		
		if (!customerName.isEmpty()) {
			List<Customer> customers = dao.searchByName(customerName);
			if (!customers.isEmpty()) {
				customerStore.setCustomerList(customers);
				setCustomerOnTable(customers);
				appProvider.showMessageUI(CustomerMsg.SEARCH_SUCCESS.getMessage());
			} else
				appProvider.showMessageUI(CustomerMsg.SEARCH_ERROR.getMessage());
		}
	}

	public void close() {
		customerStore.setSelectedTableRow(table.getSelectedRow());
		customerStore.dispatchCustomerToSheduling();
		frame.dispose();
	}

	private void setCustomerOnTable(List<Customer> customers) {
		table.removeAllData();
		customers.forEach(cus -> {
			table.addRow(new Object[] { cus.getName() });
		});
	}

}
