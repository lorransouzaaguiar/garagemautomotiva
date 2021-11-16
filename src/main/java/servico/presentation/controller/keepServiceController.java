package servico.presentation.controller;

import javax.swing.JButton;
import javax.swing.JFrame;

import app.AppProvider;
import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import servico.data.ServiceDAO;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import servico.presentation.util.ServiceMsg;
import shared.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keepServiceController implements ActionListener{
	private JFrame frame;
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
	
	public void setUIitems(
			JFrame frame,
			FormField fieldDescription,
			FormField fieldPrice,
			JButton btn, 
			Action action) 
	{
		this.frame = frame;
		this.fieldDescription = fieldDescription;
		this.fieldPrice = fieldPrice;
		this.btn = btn;
		this.action = action;
		addListener();
		this.btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isValidForm()) {
			switch (action) {
				case NEW:{
					if(dao.insert(createNewService())) {
						appProvider.showMessageUI(ServiceMsg.NEW_SUCCESS.getMessage());
						frame.dispose();
					}else appProvider.showMessageUI(ServiceMsg.NEW_ERROR.getMessage());
				}break;
				case EDIT:{
					Service editedService = createEditedService();
					if(dao.update(editedService)) {
						store.actionSetChangedService(editedService);
						appProvider.showMessageUI(ServiceMsg.EDIT_SUCCESS.getMessage());
						frame.dispose();
					}
					else appProvider.showMessageUI(ServiceMsg.EDIT_ERROR.getMessage());
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
						setServiceOnFields(serv);
					}
				}
			});
			
			store.actionSetServiceOnFields();
		}
	}
	
	private boolean isValidForm() {
		FormValidation v = formSwing.formValidation();
		formSwing
			.field("description", fieldDescription)
			.attribute("description", v.string().isRequired(fieldDescription.getText()), 
					"A descrição é requerido")
			.field("price", fieldPrice)
			.attribute("price", v.string().isRequired(fieldPrice.getText()), 
					"O preço é requerido");
			
		if(formSwing.isValid())
			return true;
	
		formSwing.showErrors();
		return false;
	}
	
	private Service createNewService() {
		double price = Double.parseDouble(fieldPrice.getText().replace(",", "."));
		Service service = new Service(fieldDescription.getText(), price);
		
		return service;
	}
	
	private Service createEditedService() {
		double price = Double.parseDouble(fieldPrice.getText().replace(",", "."));
		Service service = new Service(
				store.getService().getId(), 
				fieldDescription.getText(), 
				price);
		
		return service;
	}
	
	private void setServiceOnFields(Service service) {
		String price = String.valueOf(service.getPrice()).replace(".", ",");
		fieldDescription.setText(service.getDescription());
		fieldPrice.setText(price);
	}
	
	
}
