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

public class SearchCustomerController {
	private JFrame frame;
	private JTextField fieldName;
	private JButton btnSearch;
	private JButton btnOk;
	private JTable table;
	private DefaultTableModel tableModel;
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerDAO dao;
	private CustomerStore customerStore = CustomerStore.getInstance();

	public SearchCustomerController(CustomerDAO dao) {
		this.dao = dao;
	}

	public void setUIitems(JFrame frame, JTextField fieldName, JButton btnSearch, JButton btnOk, JTable table) {
		this.frame = frame;
		this.fieldName = fieldName;
		this.btnSearch = btnSearch;
		this.btnOk = btnOk;
		this.table = table;
		this.tableModel = (DefaultTableModel) table.getModel();

		this.btnSearch.addActionListener(btnSearchListener());
		this.btnOk.addActionListener(btnOkListener());
		this.table.addMouseListener(tableListener());
	}

	private ActionListener btnSearchListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerName = fieldName.getText();
				if (!customerName.isEmpty()) {
					List<Customer> customers = dao.searchByName(customerName);
					if (customers != null) {
						appProvider.showMessageUI(CustomerMsg.SEARCH_SUCCESS.getMessage());
						customerStore.setCustomerList(customers);
						setCustomerOnTable(customers);
					} else
						appProvider.showMessageUI(CustomerMsg.SEARCH_ERROR.getMessage());
				}
			}
		};
	}

	private ActionListener btnOkListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerStore.dispatchCustomerToSheduling();
				frame.dispose();
			}
		};
	}

	private MouseAdapter tableListener() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customerStore.setSelectedTableRow(table.getSelectedRow());
			}
		};
	}

	private void setCustomerOnTable(List<Customer> customers) {
		clearDataOnTable();
		customers.forEach(cus -> {
			tableModel.addRow(new Object[] { cus.getName() });
		});
	}

	private void clearDataOnTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

}
