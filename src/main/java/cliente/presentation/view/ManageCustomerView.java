package cliente.presentation.view;

import cliente.factory.CustomerFactory;
import cliente.presentation.controller.ManageCustomerController;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import cliente.presentation.util.CustomerMsg;
import shared.ManageView;
import javax.swing.table.DefaultTableModel;

import app.AppProvider;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ManageCustomerView extends ManageView {
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerStore store = CustomerStore.getInstance();
	private ManageCustomerController controller;

	public ManageCustomerView(ManageCustomerController controller) {
		super();
		this.controller = controller;
		actionButton();
		table.setModel(new String[] { "Nome", "Celular", "Email", "CPF" });
		addListener();
	}

	// search
	private void setCustomerOnTable(List<Customer> customers) {
		table.removeAllData();
		customers.forEach(cus -> {
			table.addRow(new Object[] { cus.getName(), cus.getNumber(), cus.getEmail(), cus.getCpf() });
		});
	}
	
	public void addListener() {
		store.addListener(e -> {
			if (e.getPropertyName().equals("changedCustomer")) {
				table.removeAllData();
				List<Customer> updatedCustomers = store.getCustomers();
				setCustomerOnTable(updatedCustomers);
			}
		});
	}

	private void actionButton() {
		this.btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFactory.insertCustomerView();
			}
		});

		this.btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.setSelectedTableRow(table.getSelectedRow());
				if (table.lineIsSelected())
					CustomerFactory.updateCustomerView();
				else
					appProvider.showMessageUI(CustomerMsg.TABLE_WARNING.getMessage());
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.lineIsSelected()) {
					if (controller.delete()) {
						table.removeRow(table.getSelectedRow());
						appProvider.showMessageUI(CustomerMsg.DELETE_SUCCESS.getMessage());
					} else
						appProvider.showMessageUI(CustomerMsg.DELETE_ERROR.getMessage());
				} else
					appProvider.showMessageUI(CustomerMsg.TABLE_WARNING.getMessage());
			}
		});

		this.btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfSearch.getText();

				if (!name.isEmpty()) {
					List<Customer> customers = controller.search(name);
					if (customers != null) {
						setCustomerOnTable(customers);
						appProvider.showMessageUI(CustomerMsg.SEARCH_SUCCESS.getMessage());
					} else
						appProvider.showMessageUI(CustomerMsg.SEARCH_ERROR.getMessage());
				}

				else
					appProvider.showMessageUI(CustomerMsg.SEARCHFIELD_EMPTY.getMessage());
			}
		});

	}

}
