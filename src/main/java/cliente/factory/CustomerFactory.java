package cliente.factory;
import cliente.data.CustomerDAO;
import cliente.data.CustomerDAOImpl;
import cliente.presentation.controller.ManageCustomerController;
import cliente.presentation.controller.keepCustomerController;
import cliente.presentation.view.KeepCustomerView;
import cliente.presentation.view.ManageCustomerView;
import shared.Action;

public class CustomerFactory {
	
	public static ManageCustomerView manageCustomer() {
		CustomerDAO dao = new CustomerDAOImpl();
		ManageCustomerController controller = new ManageCustomerController(dao);
		return new ManageCustomerView(controller);
	}
	
	public static KeepCustomerView keepCustomer(Action action) {
		CustomerDAO dao = new CustomerDAOImpl();
		keepCustomerController controller = new keepCustomerController(dao);
		return new KeepCustomerView(controller, action);
	}
}
