package cliente.presentation.model;

import java.util.UUID;

public class Customer {
	
	private String id;
	private String name;
	private String number;
	private String email;
	private String cpf;
	
	public Customer(String id, String name, String number, String email, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.cpf = cpf;
	}

	public Customer(String name, String number, String email, String cpf) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.number = number;
		this.email = email;
		this.cpf = cpf;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", cpf=" + cpf
				+ "]";
	}
	
	
	
}
