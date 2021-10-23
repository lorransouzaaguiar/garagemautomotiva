package servico.presentation.controller;

import javax.swing.JButton;
import app.AppProvider;
import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import servico.data.ServiceDAO;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import shared.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keepServiceController implements ActionListener{
	
	private FormField fieldDescription;
	private FormField fieldPrice;
	private JButton btn;
	private FormSwing formSwing;
	private Action action;
	private ServiceDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private ServiceStore store = ServiceStore.getInstance();
	
	public keepServiceController(ServiceDAO dao){
		this.dao = dao;
		this.formSwing = new FormSwing();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isValidForm()) {
			switch (action) {
				case NEW:{
					if(dao.insert(createService()))
						appProvider.showMessageUI("Serviço salvo com sucesso!");
					else appProvider.showMessageUI("Falha ao salvar serviço!");
				}break;
				case EDIT:{
					if(dao.update(createService()))
						appProvider.showMessageUI("Serviço atualizado com sucesso!");
					else appProvider.showMessageUI("Falha ao atualizar serviço!");
				}break;
			}
		}
	}	
	
	private void addListener() {
		if(action.equals(action.EDIT)) {
			store.addListener(e -> {
				if(e.getPropertyName().equals("getService")) {
					Service serv = store.getService();
					if(serv != null) {
						setCustomerOnFields(serv);
					}
				}
			});
			
			store.setState();
		}
	}
	
	private boolean isValidForm() {
		FormValidation v = formSwing.formValidation();
		formSwing
			.field("description", fieldDescription)
			.attribute("description", v.string().isRequired(fieldDescription.getText()), "Campo requerido")
			.field("price", fieldPrice)
			.attribute("price", v.string().isRequired(fieldPrice.getText()), "Campo requerido");
			
		if(formSwing.isValid())
			return true;
		else {
			formSwing.showErrors();
			return false;
		}
	}
	
	private Service createService() {
		double price = Double.parseDouble(fieldPrice.getText().replace(",", "."));
		Service service = new Service(fieldDescription.getText(), price);
		
		return service;
	}
	
	private void setCustomerOnFields(Service service) {
		String price = String.valueOf(service.getPrice()).replace(".", ",");
		fieldDescription.setText(service.getDescription());
		fieldPrice.setText(price);
	}
	
	public void setUIitems(
			FormField fieldDescription,
			FormField fieldPrice,
			JButton btn, 
			Action action) 
	{
		this.fieldDescription = fieldDescription;
		this.fieldPrice = fieldPrice;
		this.btn = btn;
		this.action = action;
		addListener();
		this.btn.addActionListener(this);
	}
}
