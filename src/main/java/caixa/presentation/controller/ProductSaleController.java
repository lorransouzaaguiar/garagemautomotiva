package caixa.presentation.controller;

import java.util.List;
import app.AppProvider;
import caixa.data.ProductSaleDAO;
import caixa.presentation.model.Sale;
import caixa.presentation.model.SaleViewModel;
import cliente.presentation.model.Customer;
import produto.data.ProductDAO;
import produto.presentation.model.Product;


public class ProductSaleController {

	private ProductSaleDAO dao;
	private ProductDAO productDAO;
	private AppProvider appProvider = AppProvider.getInstance();
	private SaleViewModel saleViewModel;
	private Customer customer;
	
	public ProductSaleController(ProductSaleDAO dao, ProductDAO productDAO) {
		this.dao = dao;
		this.productDAO = productDAO;
		this.saleViewModel = new SaleViewModel();
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public SaleViewModel searchProduct(String description) {
		if (!description.isEmpty()) {
			List<Product> products = productDAO.searchByDescription(description);
			if (!products.isEmpty()) {
				saleViewModel.setProducts(products);
				appProvider.showMessageUI("Produto obtido com sucesso");
			} else
				appProvider.showMessageUI("Falha ao obter produto");
		} else
			appProvider.showMessageUI("Insira a descrição do produto");
		
		return saleViewModel;
	}

	public SaleViewModel addProductOnCart(int index) {
		if(index != -1) {
			saleViewModel.addProductOnCart(index);
		} else appProvider.showMessageUI("Selecione uma Linha na tabela de produtos");
		
		return saleViewModel;
	}
	
	public SaleViewModel removeProductOnCart(int index) {
		if(index != -1) {
			saleViewModel.removeProductOnCart(index);
		} else appProvider.showMessageUI("Selecione uma Linha na tabela de produtos");
		
		return saleViewModel;
	}
	
	public String getTotal() {
		String total = String.valueOf(saleViewModel.getTotal());
		return "R$ " + total;
	}
	
	public String getBack(String received) {
		if(!received.isEmpty()) {
			double r = Double.parseDouble(received);
			double back = saleViewModel.getBack(r);
			
			if(back != - 1) {
				String backString = String.valueOf(back);
				return "R$ " + backString;
			}
		}
		return "R$ 0.00";
	}
	
	public void checkout() {
		if(customer == null) {
			appProvider.showMessageUI("Adicione o cliente referente a compra!");
		}
		if(saleViewModel.getCartProducts().isEmpty()) {
			appProvider.showMessageUI("Adicione produtos no carrinho antes de finalizar");
		}
		
		Sale sale = new Sale(customer.getId(), saleViewModel.getTotal());
		if(dao.insert(sale)) {
			appProvider.showMessageUI("Venda realizada com sucesso!");
		}else appProvider.showMessageUI("Falha ao realizar venda!");
	}

}
