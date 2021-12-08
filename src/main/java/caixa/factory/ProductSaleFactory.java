package caixa.factory;

import caixa.presentation.controller.ProductSaleController;
import caixa.presentation.view.ProductSaleView;

public class ProductSaleFactory {
	
	public static ProductSaleView productSaleView() {
		ProductSaleController controller = new ProductSaleController();
		return new ProductSaleView(controller);
	}
	
	
}
