package shared.cliente;

import cliente.data.CustomerDAOImpl;

public class SearchCustomerFactory {
	
	public static SearchCustomerView searchCustomer() {
		CustomerDAOImpl dao = new CustomerDAOImpl();
		SearchCustomerController controller = new SearchCustomerController(dao);
		return new SearchCustomerView(controller);
	}
	
}	
