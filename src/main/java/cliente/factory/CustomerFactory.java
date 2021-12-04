package cliente.factory;
import cliente.data.CustomerDAO;
import cliente.data.CustomerDAOImpl;
import cliente.presentation.controller.ManageCustomerController;
import cliente.presentation.controller.keepCustomerController;
import cliente.presentation.view.InsertCustomerView;
import cliente.presentation.view.ManageCustomerView;
import cliente.presentation.view.UpdateCustomerView;

public class CustomerFactory {
	
	public static ManageCustomerView manageCustomer() {
		CustomerDAO dao = new CustomerDAOImpl();
		ManageCustomerController controller = new ManageCustomerController(dao);
		return new ManageCustomerView(controller);
	}
	
	private static keepCustomerController keepCustomerController() {
		CustomerDAO dao = new CustomerDAOImpl();
		return new keepCustomerController(dao);
	}
	
	public static InsertCustomerView insertCustomerView() {
		keepCustomerController controller = keepCustomerController();
		return new InsertCustomerView(controller);
	}
	
	public static UpdateCustomerView updateCustomerView() {
		keepCustomerController controller = keepCustomerController();
		return new UpdateCustomerView(controller);
	}
}
