package produto.presentation.controller;

import java.util.List;

import app.AppProvider;
import cliente.presentation.util.CustomerMsg;
import produto.data.ProductDAO;
import produto.factory.ProductFactory;
import produto.presentation.model.Product;
import produto.presentation.store.ProductStore;
import produto.presentation.util.ProductMsg;
import servico.fatory.ServiceFactory;
import servico.presentation.util.ServiceMsg;
import shared.CustomTable;

public class ManageProductController {
	private ProductDAO dao;
	private ProductStore store = ProductStore.getInstance();
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomTable table;

	public ManageProductController(ProductDAO dao) {
		this.dao = dao;
		addEvent();
	}

	public void setUiItem(CustomTable table) {
		this.table = table;
	}
	
	public void update() {
		if (table.lineIsSelected()) {
			store.setSelectedTableRow(table.getSelectedRow());
			ProductFactory.updateProductView();
		}
		else
			appProvider.showMessageUI(ProductMsg.TABLE_WARNING.getMessage());
	}

	public void delete() {
		int selectedTableRow = table.getSelectedRow();
		
		if (table.lineIsSelected()) {
			store.setSelectedTableRow(selectedTableRow);
			String id = store.getProduct().getId();
			if (dao.delete(id)) {
				table.removeRow(selectedTableRow);
				appProvider.showMessageUI(ProductMsg.DELETE_SUCCESS.getMessage());
			} else
				appProvider.showMessageUI(ProductMsg.DELETE_ERROR.getMessage());

		} else
			appProvider.showMessageUI(ProductMsg.TABLE_WARNING.getMessage());
	}

	public void search(String description) {
		if (!description.isEmpty()) {
			List<Product> products = dao.searchByDescription(description);

			if (!products.isEmpty()) {
				store.setProductList(products);
				setProductOnTable(products);
				appProvider.showMessageUI(ProductMsg.SEARCH_SUCCESS.getMessage());

			} else
				appProvider.showMessageUI(ProductMsg.SEARCH_ERROR.getMessage());

		} else
			appProvider.showMessageUI(ProductMsg.SEARCHFIELD_EMPTY.getMessage());
	}

	/* Search */
	public void addEvent() {
		store.addListener(e -> {
			if (e.getPropertyName().equals("changedProduct")) {
				table.removeAllData();
				List<Product> updatedProducts = store.getProducts();
				setProductOnTable(updatedProducts);
			}
		});
	}

	public void setProductOnTable(List<Product> products) {
		table.removeAllData();
		products.forEach(prod -> {
			String price = String.valueOf(prod.getPrice());
			table.addRow(new Object[] { prod.getDescription(), price });
		});
	}
	/* Search */
}
