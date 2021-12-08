package caixa.presentation.model;

import produto.presentation.model.Product;

public class CartProduct {
	private Product product;
	private int qty = 1;
	private double value = 0;
	
	public CartProduct(Product product) {
		super();
		this.product = product;
		this.value = product.getPrice();
	}
	
	public void calcValue() {
		this.value = product.getPrice() * qty;
	}

	public Product getProduct() {
		return product;
	}
	
	public void incrementQty() {
		this.qty++;
	}
	
	public void decrementQty() {
		this.qty--;
	}

	public int getQty() {
		return qty;
	}

	public double getValue() {
		return value;
	}
	
	
}
