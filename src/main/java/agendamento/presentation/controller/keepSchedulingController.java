package agendamento.presentation.controller;

import java.util.List;

import javax.swing.JFrame;

import agendamento.data.SchedulingDAO;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.util.SchedulingMsg;
import app.AppProvider;
import servico.data.ServiceDAO;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;

public class keepSchedulingController {
	
	private SchedulingDAO dao; 
	private ServiceDAO serviceDao;
	private ServiceStore serviceStore = ServiceStore.getInstance();
	private AppProvider appProvider = AppProvider.getInstance();
	
	public keepSchedulingController(SchedulingDAO dao, ServiceDAO serviceDao) {
		this.dao = dao;
		this.serviceDao = serviceDao;
	}
	
	public void serchServices() {
		List<Service> services = serviceDao.searchAll();
		if(!services.isEmpty()) {
			serviceStore.dispatchServicesToScheduling(services);
		}
	}
	
	public void insert(Scheduling scheduling, JFrame frame) {
		if(dao.insert(scheduling)) {
			appProvider.showMessageUI(SchedulingMsg.NEW_SUCCESS.getMessage());
			frame.dispose();
		} else appProvider.showMessageUI(SchedulingMsg.NEW_ERROR.getMessage());
	}
	

}
