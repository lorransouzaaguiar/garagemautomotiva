package agendamento.factory;

import agendamento.presentation.controller.SearchCustomerController;
import agendamento.presentation.view.SearchCustomerView;
import cliente.data.CustomerDAOImpl;

public class SearchCustomerFactory {
	
	public static SearchCustomerView searchCustomer() {
		CustomerDAOImpl dao = new CustomerDAOImpl();
		SearchCustomerController controller = new SearchCustomerController(dao);
		return new SearchCustomerView(controller);
	}
	
}	
