package cliente.presentation.controller;

import javax.swing.JButton;
import app.AppProvider;
import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import shared.Action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keepCustomerController implements ActionListener{
	
	private FormField fieldName;
	private FormField fieldEmail;
	private FormField fieldNumber;
	private FormField fieldCPF;
	private JButton btn;
	private FormSwing formSwing;
	private Action action;
	private CustomerDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerStore store = CustomerStore.getInstance();
	
	public keepCustomerController(CustomerDAO dao){
		this.dao = dao;
		this.formSwing = new FormSwing();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isValidForm()) {
			switch (action) {
				case NEW:{
					if(dao.insert(createCustomer()))
						appProvider.showMessageUI("Cliente salvo com sucesso!");
					else appProvider.showMessageUI("Falha ao salvar cliente!");
				}break;
				case EDIT:{
					if(dao.update(createCustomer()))
						appProvider.showMessageUI("Cliente atualizado com sucesso!");
					else appProvider.showMessageUI("Falha ao atualizar cliente!");
				}break;
			}
		}
	}	
	
	private void addListener() {
		if(action.equals(action.EDIT)) {
			store.addListener(e -> {
				if(e.getPropertyName().equals("getCustomer")) {
					Customer cus = store.getCustomer();
					if(cus != null) {
						setCustomerOnFields(cus);
					}
				}
			});
			
			store.setState();
		}
	}
	
	private boolean isValidForm() {
		FormValidation v = formSwing.formValidation();
		formSwing
			.field("name", fieldName)
			.attribute("name", v.string().isRequired(fieldName.getText()), "Campo requerido")
			.field("email", fieldEmail)
			.attribute("email", v.string().isEmail(fieldEmail.getText()), "Email inválido")
			.field("number", fieldNumber)
			.attribute("number", v.string().isRequired(fieldNumber.getText()), "Campo requerido");
		
		if(formSwing.isValid())
			return true;
		else {
			formSwing.showErrors();
			return false;
		}
	}
	
	private Customer createCustomer() {
		Customer customer = new Customer(
				fieldName.getText(), 
				fieldNumber.getText(), 
				fieldEmail.getText(), 
				fieldCPF.getText()
		);
		
		return customer;
	}
	
	private void setCustomerOnFields(Customer cus) {
		this.fieldName.setText(cus.getName());
		this.fieldNumber.setText(cus.getNumber());
		this.fieldEmail.setText(cus.getEmail());
		this.fieldCPF.setText(cus.getCpf());
	}
	
	public void setUIitems(
			FormField fieldName, 
			FormField fieldEmail, 
			FormField fieldNumber, 
			FormField fieldCPF,
			JButton btn, 
			Action action) 
	{
		this.fieldName = fieldName;
		this.fieldEmail = fieldEmail;
		this.fieldNumber = fieldNumber;
		this.fieldCPF = fieldCPF;
		this.btn = btn;
		this.action = action;
		addListener();
		this.btn.addActionListener(this);
	}
}
