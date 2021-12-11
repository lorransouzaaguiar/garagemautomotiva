package produto.data;

import java.util.List;

import produto.presentation.model.Product;

public interface ProductDAO {
	public boolean insert(Product product);
	public boolean update(Product product);
	public boolean delete(String id);
	public String count();
	public List<Product> searchByDescription(String description);
}
