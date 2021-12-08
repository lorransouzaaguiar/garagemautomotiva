package caixa.presentation.model;

import java.util.Date;
import java.util.UUID;

public class Sale {
	private String id;
	private String customerId;
	private Date date;
	private double totalValue;
	
	public Sale(String id, String customerId, Date date, double totalValue) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Sale(String customerId, double totalValue) {
		super();
		this.id = UUID.randomUUID().toString();
		this.customerId = customerId;
		this.date = new Date();
		this.totalValue = totalValue;
	}

	public String getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Date getDate() {
		return date;
	}

	public double getTotalValue() {
		return totalValue;
	}
}
