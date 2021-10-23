package agendamento.presentation.model;

import java.util.Date;

import cliente.presentation.model.Customer;
import servico.presentation.model.Service;

public class Scheduling {
	private String id;
	private Customer customer;
	private Service service;
	private Date date;
	
	public Scheduling(String id, Customer customer, Service service, Date date) {
		super();
		this.id = id;
		this.customer = customer;
		this.service = service;
		this.date = date;
	}

	public Scheduling(Customer customer, Service service, Date date) {
		super();
		this.customer = customer;
		this.service = service;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Service getService() {
		return service;
	}

	public Date getDate() {
		return date;
	}
	
}
