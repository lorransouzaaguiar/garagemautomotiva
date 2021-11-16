package cliente.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import app.AppProvider;
import cliente.data.CustomerDAO;
import cliente.factory.CustomerFactory;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import cliente.presentation.util.CustomerMsg;
import shared.Action;

public class ManageCustomerController {
	private JTextField tfSearch;
	private JTable table;
	private DefaultTableModel tableModel;
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerDAO dao;
	private CustomerStore store = CustomerStore.getInstance();
	
	public ManageCustomerController(CustomerDAO dao) {
		this.dao = dao;
	}
	
	public ActionListener btnNewListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFactory.keepCustomer(Action.NEW);
			}
		};
	}
	
	public ActionListener btnEditListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1)
					CustomerFactory.keepCustomer(Action.EDIT);
				else appProvider.showMessageUI(CustomerMsg.TABLE_WARNING.getMessage());
			}
		};
	}
	
	public ActionListener btnDeleteListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTableRow = table.getSelectedRow();
				if(selectedTableRow != -1) {
					String id = store.getCustomer().getId();
					if(dao.delete(id)) {
						store.removeCustomer();
						tableModel.removeRow(selectedTableRow);
						appProvider.showMessageUI(CustomerMsg.DELETE_SUCCESS.getMessage());
					}
					else appProvider.showMessageUI(CustomerMsg.DELETE_ERROR.getMessage());
				}
				else appProvider.showMessageUI(CustomerMsg.TABLE_WARNING.getMessage());
			}
		};
	}
	
	public ActionListener btnSearchListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfSearch.getText();
				if(!name.isEmpty()) {
					List<Customer> customers = dao.searchByName(name);
					if(!customers.isEmpty()) {
						store.setCustomerList(customers);
						setCustomerOnTable(customers);
						appProvider.showMessageUI(CustomerMsg.SEARCH_SUCCESS.getMessage());
					}else appProvider.showMessageUI(CustomerMsg.SEARCH_ERROR.getMessage());	
				}else appProvider.showMessageUI(CustomerMsg.SEARCHFIELD_EMPTY.getMessage());
			}
		};
	}
	
	public MouseAdapter tableListener() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				store.setSelectedTableRow(table.getSelectedRow());
			}
		};
	}
	
	public void addListener() {
		store.addListener(e -> {
			if(e.getPropertyName().equals("changedCustomer")) {
				clearDataOnTable();
				List<Customer> updatedCustomers = store.getCustomers();
				setCustomerOnTable(updatedCustomers);
			}
		});
	}
	
	private void setCustomerOnTable(List<Customer> customers) {
		clearDataOnTable();
		customers.forEach(cus -> {
			tableModel.addRow(new Object [] {
					cus.getName(), 
					cus.getNumber(), 
					cus.getEmail(), 
					cus.getCpf()});
		});
	}
	
	private void clearDataOnTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}
	
	
	public void setUIitems(
			JTextField tfSearch, 
			JTable table) 
	{
		this.tfSearch = tfSearch;
		this.table = table;
		this.tableModel = (DefaultTableModel) table.getModel();
		addListener();
	
	}
}
