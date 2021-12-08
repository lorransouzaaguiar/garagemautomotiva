package caixa.factory;

import caixa.data.ProductSaleDAOImpl;
import caixa.presentation.controller.ProductSaleController;
import caixa.presentation.view.ProductSaleView;
import produto.data.ProductDAOImpl;

public class ProductSaleFactory {
	
	public static ProductSaleView productSaleView() {
		ProductSaleDAOImpl dao = new ProductSaleDAOImpl();
		ProductDAOImpl productDao = new ProductDAOImpl();
		ProductSaleController controller = new ProductSaleController(dao, productDao);
		return new ProductSaleView(controller);
	}
	
	
}
