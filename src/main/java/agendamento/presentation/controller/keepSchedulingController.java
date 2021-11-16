package agendamento.presentation.controller;

import javax.swing.JButton;

import agendamento.data.SchedulingDAO;
import agendamento.factory.SearchCustomerFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.store.SchedulingStore;
import agendamento.presentation.view.SearchCustomerView;
import app.AppProvider;
import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormBox;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import cliente.data.CustomerDAOImpl;
import shared.Action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keepSchedulingController{
	
	private FormField fieldName;
	private JButton btnCustomer;
	private JButton btnScheduling;
	private FormBox formBox;
	private FormSwing formSwing;
	private Action action;
	private SchedulingDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private SchedulingStore store = SchedulingStore.getInstance();
	
	public keepSchedulingController(SchedulingDAO dao){
		this.dao = dao;
		this.formSwing = new FormSwing();
	}
	
	public void setUIitems(
			 FormField fieldName,
			 JButton btnCustomer,
			 FormBox formBox,
			 JButton btnScheduling,
			 Action action) 
	{
		this.fieldName = fieldName;
		this.formBox = formBox;
		this.btnScheduling = btnScheduling;
		this.btnCustomer = btnCustomer;
		this.action = action;
		
		addListener();
		this.btnScheduling.addActionListener(shedulingListener());
		this.btnCustomer.addActionListener(customerListener());
	}
	
	
	private ActionListener shedulingListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isValidForm()) {
					switch (action) {
						case NEW:{
							if(dao.insert(createModel()))
								appProvider.showMessageUI("Serviço salvo com sucesso!");
							else appProvider.showMessageUI("Falha ao salvar serviço!");
						}break;
						case EDIT:{
							if(dao.update(createModel()))
								appProvider.showMessageUI("Serviço atualizado com sucesso!");
							else appProvider.showMessageUI("Falha ao atualizar serviço!");
						}break;
					}
				}
			}
		};
	}
	
	private ActionListener customerListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomerFactory.searchCustomer();
			}
		};
	}	
	
	private void addListener() {
		if(action.equals(action.EDIT)) {
			store.addListener(e -> {
				if(e.getPropertyName().equals("getService")) {
					Scheduling sche = store.getScheduling();
					if(sche != null) {
						setDataOnFields(sche);
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
			.field("service", formBox)
			.attribute("service", v.string().isRequired(formBox.getText()), "Campo requerido");
			
		if(formSwing.isValid())
			return true;
		else {
			formSwing.showErrors();
			return false;
		}
	}
	
	private Scheduling createModel() {
		Scheduling scheduling = new Scheduling(null, null, null);
		return scheduling;
	}
	
	private void setDataOnFields(Scheduling scheduling) {
		
	}
	
	
}
