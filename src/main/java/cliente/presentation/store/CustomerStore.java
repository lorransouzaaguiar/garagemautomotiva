package cliente.presentation.store;

import java.util.ArrayList;
import java.util.List;

import cliente.presentation.model.Customer;
import shared.Observable;

public class CustomerStore extends Observable{

	private static CustomerStore instance = null;
	private List<Customer> customers;
	private String idCustomer = null;
	private int selectedTableRow = -1;
	private boolean state = false;
	
	private CustomerStore() {
		this.customers = new ArrayList<>();
	}

	public static CustomerStore getInstance() {
		if (instance == null) {
			instance = new CustomerStore();
		}

		return instance;
	}
	
	public void setCustomerList(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void setSelectedTableRow(int index) {
		this.selectedTableRow = index;
	}
	
	public void actionSetCustomerOnFields() {
		boolean oldValue = this.state;
		boolean newValue = true;
		this.support.firePropertyChange("getCustomer", oldValue, newValue);
		this.state = false;
	}
	
	public void actionSetChangedCustomer(Customer cus) {
		this.customers.set(selectedTableRow, cus);
		String oldValue = this.idCustomer;
		String newValue = cus.getId();
		this.support.firePropertyChange("changedCustomer", oldValue, newValue);
		this.idCustomer = null;
	}
	
	public Customer getCustomer() {
		if(selectedTableRow != -1) {
			Customer cus = customers.get(selectedTableRow);
			return cus;
		}
		return null;
	}
	
	public void removeCustomer() {
		this.customers.remove(selectedTableRow);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	

}
