package produto.presentation.store;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import cliente.presentation.model.Customer;
import produto.presentation.model.Product;
import shared.Observable;

public class ProductStore extends Observable{
	private static ProductStore instance = null;
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	private List<Product> products;
	private int selectedTableRow = -1;
	
	public ProductStore() {
		this.products = new ArrayList<Product>();
	}
	
	public static ProductStore getInstance() {
		if(instance == null)
			instance = new ProductStore();
		
		return instance;
	}
	
	public void setProductList(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}
	
	public Product getProduct() {
		if(selectedTableRow != -1) {
			Product prod = products.get(selectedTableRow);
			return prod;
		}
		return null;
	}
	
	public void setSelectedTableRow(int index) {
		this.selectedTableRow = index;
	}
	
	public void dispatchChangedProduct(Product product) {
		this.products.set(selectedTableRow, product);
		this.support.firePropertyChange("changedProduct", false, true);
	}
	
}
