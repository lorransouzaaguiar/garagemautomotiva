package produto.presentation.model;

import java.util.UUID;

public class Product {
	private String id;
	private String description;
	private double price;
	private int qtyStock;
	
	public Product(String id, String description, double price, int qtyStock) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.qtyStock = qtyStock;
	}
	
	public Product(String description, double price, int qtyStock) {
		super();
		this.id = UUID.randomUUID().toString();
		this.description = description;
		this.price = price;
		this.qtyStock = qtyStock;
	}
	
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public int getQtyStock() {
		return qtyStock;
	}
	
}
