package produto.presentation.controller;

import javax.swing.JFrame;

import app.AppProvider;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.util.CustomerMsg;
import produto.data.ProductDAO;
import produto.presentation.model.Product;
import produto.presentation.store.ProductStore;
import produto.presentation.util.ProductMsg;

public class KeepProductController {
	
	private ProductDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private ProductStore store = ProductStore.getInstance();
	
	public KeepProductController(ProductDAO dao){
		this.dao = dao;
	}
	
	public void insert(Product product, JFrame frame) {
		if(dao.insert(product)) {
			appProvider.showMessageUI(ProductMsg.NEW_SUCCESS.getMessage());
			frame.dispose();
		}	
		else {
			appProvider.showMessageUI(ProductMsg.NEW_ERROR.getMessage());
		}
	}
	
	public void update(Product product, JFrame frame) {
		if(dao.update(product)) {
			store.dispatchChangedProduct(product);
			appProvider.showMessageUI(ProductMsg.EDIT_SUCCESS.getMessage());
			frame.dispose();
		}
		else {
			appProvider.showMessageUI(ProductMsg.EDIT_ERROR.getMessage());
		}
	}
}
