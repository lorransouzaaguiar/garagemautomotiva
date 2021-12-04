package cliente.presentation.controller;

import java.util.List;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;

public class ManageCustomerController {
	private CustomerDAO dao;
	private CustomerStore store = CustomerStore.getInstance();
	
	public ManageCustomerController(CustomerDAO dao) {
		this.dao = dao;
	}
	
	public boolean delete() {
		String id = store.getCustomer().getId();
		
		if(dao.delete(id)) {
			store.removeCustomer();
			return true;
		}
		
		return false;
	}
	
	public List<Customer> search(String name) {
		List<Customer> customers = dao.searchByName(name);
		
		if(!customers.isEmpty()) {
			store.setCustomerList(customers);
			return customers;
		}
		
		return null;
	}
}
