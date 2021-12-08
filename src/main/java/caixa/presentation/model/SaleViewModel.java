package caixa.presentation.model;

import java.util.ArrayList;
import java.util.List;
import produto.presentation.model.Product;

public class SaleViewModel {
	private List<Product> products;
	private List<CartProduct> cartProducts;
	private double total = 0;
	private double back = 0;

	public SaleViewModel() {
		this.products = new ArrayList<>();
		this.cartProducts = new ArrayList<>();
	}

	public void addProductOnCart(int index) {
		Product prod = this.products.get(index);

		int indexProdOnCart = cartProductIndexOf(prod);

		if (indexProdOnCart != -1) {
			CartProduct cartProd = this.cartProducts.get(indexProdOnCart);
			cartProd.incrementQty();
			cartProd.calcValue();
			cartProducts.set(indexProdOnCart, cartProd);
		} else {
			CartProduct cartProd = new CartProduct(prod);
			cartProducts.add(cartProd);
		}

	}
	
	public void removeProductOnCart(int index) {
		Product prod = this.products.get(index);
		int indexProdOnCart = cartProductIndexOf(prod);
		CartProduct cartProd = null;
		
		if (indexProdOnCart != -1) {
			cartProd = this.cartProducts.get(indexProdOnCart);
			cartProd.decrementQty();
			cartProd.calcValue();
			cartProducts.set(indexProdOnCart, cartProd);
		} 
		
		if(cartProd != null && cartProd.getQty() == 0) {
			cartProducts.remove(cartProd);
		}
			
	}
	
	public double getTotal() {
		double total = 0;
		for (CartProduct cartProduct : cartProducts) {
			 total += cartProduct.getValue();
		}
		
		this.total = total;
		return this.total;
	}
	
	public double getBack(double received) {
		double total = getTotal();
		if(received > total)
			this.back = received - getTotal();
		else this.back = -1;
		return this.back;
	}
	
	private int cartProductIndexOf(Product prod) {
		for (CartProduct cartProduct : cartProducts) {
			if (cartProduct.getProduct().getId().equals(prod.getId())) {
				return cartProducts.indexOf(cartProduct);
			}
		}

		return -1;
	}
	
	
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public List<CartProduct> getCartProducts() {
		return this.cartProducts;
	}
	
	

}
