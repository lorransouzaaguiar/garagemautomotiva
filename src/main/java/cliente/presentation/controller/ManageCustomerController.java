package cliente.presentation.controller;

import java.util.List;
import app.AppProvider;
import cliente.data.CustomerDAO;
import cliente.factory.CustomerFactory;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import cliente.presentation.util.CustomerMsg;
import shared.CustomTable;

public class ManageCustomerController {
	private CustomerDAO dao;
	private CustomerStore store = CustomerStore.getInstance();
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomTable table;

	public ManageCustomerController(CustomerDAO dao) {
		this.dao = dao;
		addListener();
	}

	public void setUiItem(CustomTable table) {
		this.table = table;
	}

	public void update() {
		store.setSelectedTableRow(table.getSelectedRow());
		if (table.lineIsSelected())
			CustomerFactory.updateCustomerView();
		else
			appProvider.showMessageUI(CustomerMsg.TABLE_WARNING.getMessage());
	}

	public void delete() {
		int selectedTableRow = table.getSelectedRow();
		
		if (table.lineIsSelected()) {
			String id = store.getCustomer().getId();
			store.setSelectedTableRow(selectedTableRow);
			
			if (dao.delete(id)) {
				table.removeRow(selectedTableRow);
				appProvider.showMessageUI(CustomerMsg.DELETE_SUCCESS.getMessage());
			} else
				appProvider.showMessageUI(CustomerMsg.DELETE_ERROR.getMessage());

		} else
			appProvider.showMessageUI(CustomerMsg.TABLE_WARNING.getMessage());
	}

	// search
	public void search(String name) {
		if (!name.isEmpty()) {
			List<Customer> customers = dao.searchByName(name);
			if (!customers.isEmpty()) {
				store.setCustomerList(customers);
				setCustomerOnTable(customers);
				appProvider.showMessageUI(CustomerMsg.SEARCH_SUCCESS.getMessage());
			} else
				appProvider.showMessageUI(CustomerMsg.SEARCH_ERROR.getMessage());
		}

		else
			appProvider.showMessageUI(CustomerMsg.SEARCHFIELD_EMPTY.getMessage());
	}

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
	// search
}
