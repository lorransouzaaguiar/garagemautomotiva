package agendamento.presentation.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import cliente.presentation.model.Customer;
import servico.presentation.model.Service;

public class Scheduling {
	private String id;
	private Customer customer;
	private List<Service> services;
	private Date date;
	private String hour;
	
	public Scheduling(String id, Customer customer, List<Service> services, Date date, String hour) {
		super();
		this.id = id;
		this.customer = customer;
		this.services = services;
		this.date = date;
		this.hour = hour;
	}

	public Scheduling(Customer customer, List<Service> services, Date date, String hour) {
		super();
		this.id = UUID.randomUUID().toString();
		this.customer = customer;
		this.services = services;
		this.date = date;
		this.hour = hour;
	}

	public String getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Service> getServices() {
		return services;
	}

	public Date getDate() {
		return date;
	}

	public String getHour() {
		return hour;
	}

	@Override
	public String toString() {
		return "Scheduling [id=" + id + ", customer=" + customer + ", services=" + services + ", date=" + date
				+ ", hour=" + hour + "]";
	}
	
	
}
