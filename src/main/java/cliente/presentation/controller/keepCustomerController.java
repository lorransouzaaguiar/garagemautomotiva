package cliente.presentation.controller;
import javax.swing.JFrame;

import app.AppProvider;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import cliente.presentation.util.CustomerMsg;

public class keepCustomerController{
	
	private CustomerDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerStore store = CustomerStore.getInstance();
	
	public keepCustomerController(CustomerDAO dao){
		this.dao = dao;
	}
	
	public void insert(Customer customer, JFrame frame) {
		if(dao.insert(customer)) {
			appProvider.showMessageUI(CustomerMsg.NEW_SUCCESS.getMessage());
			frame.dispose();
		}	
		else {
			appProvider.showMessageUI(CustomerMsg.NEW_ERROR.getMessage());
		}
	}
	
	public void update(Customer customer, JFrame frame) {
		if(dao.update(customer)) {
			store.actionSetChangedCustomer(customer);
			appProvider.showMessageUI(CustomerMsg.EDIT_SUCCESS.getMessage());
			frame.dispose();
		}
		else {
			appProvider.showMessageUI(CustomerMsg.EDIT_ERROR.getMessage());
		}
	}
	
}
