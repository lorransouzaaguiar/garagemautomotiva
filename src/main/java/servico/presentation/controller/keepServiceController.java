package servico.presentation.controller;

import javax.swing.JFrame;
import app.AppProvider;
import servico.data.ServiceDAO;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import servico.presentation.util.ServiceMsg;

public class keepServiceController {
	
	private ServiceDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private ServiceStore store = ServiceStore.getInstance();
	
	public keepServiceController(ServiceDAO dao){
		this.dao = dao;
	}
	
	public void insert(Service service, JFrame frame) {
		if(dao.insert(service)) {
			appProvider.showMessageUI(ServiceMsg.NEW_SUCCESS.getMessage());
			frame.dispose();
		}else appProvider.showMessageUI(ServiceMsg.NEW_ERROR.getMessage());
	}
	
	public void update(Service service, JFrame frame) {
		if(dao.update(service)) {
			store.actionSetChangedService(service);
			appProvider.showMessageUI(ServiceMsg.EDIT_SUCCESS.getMessage());
			frame.dispose();
		}
		else appProvider.showMessageUI(ServiceMsg.EDIT_ERROR.getMessage());
	}
	
}
