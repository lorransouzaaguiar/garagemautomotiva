package servico.presentation.model;

import java.util.UUID;

public class Service {
	
	private String id;
	private String description;
	private	double price;
	
	public Service(String id, String description, double price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}
	
	public Service(String id, String description, String price) {
		super();
		this.id = id;
		this.description = description;
		this.price = Double.parseDouble(price.replace(",", "."));
	}


	public Service(String description, String price) {
		super();
		this.id = UUID.randomUUID().toString();
		this.description = description;
		this.price = Double.parseDouble(price.replace(",", "."));
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

	
	
}
