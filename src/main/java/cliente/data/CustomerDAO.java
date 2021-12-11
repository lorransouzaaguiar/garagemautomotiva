package cliente.data;
import java.util.List;

import cliente.presentation.model.Customer;

public interface CustomerDAO {
	public boolean insert(Customer customer);
	public boolean update(Customer customer);
	public boolean delete(String id);
	public String count();
	public List<Customer> searchByName(String name);
	public List<Customer> searchAll();
}
