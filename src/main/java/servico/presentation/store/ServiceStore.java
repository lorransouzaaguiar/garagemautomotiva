package servico.presentation.store;

import java.util.ArrayList;
import java.util.List;

import cliente.presentation.model.Customer;
import servico.presentation.model.Service;
import shared.Observable;

public class ServiceStore extends Observable{

	private static ServiceStore instance = null;
	private List<Service> services;
	private String idService = null;
	private int selectedTableRow = -1;
	private boolean state = false;
	
	private ServiceStore() {
		this.services = new ArrayList<>();
	}

	public static ServiceStore getInstance() {
		if (instance == null) {
			instance = new ServiceStore();
		}

		return instance;
	}
	
	public void setServiceList(List<Service> services) {
		this.services = services;
	}
	
	public void setSelectedTableRow(int index) {
		this.selectedTableRow = index;
	}
	
	public void actionSetServiceOnFields() {
		boolean oldValue = this.state;
		boolean newValue = true;
		this.support.firePropertyChange("getService", oldValue, newValue);
		this.state = false;
	}
	
	public void actionSetChangedService(Service service) {
		this.services.set(selectedTableRow, service);
		String oldValue = this.idService;
		String newValue = service.getId();
		this.support.firePropertyChange("changedService", oldValue, newValue);
		this.idService = null;
	}
	
	public Service getService() {
		if(selectedTableRow != -1) {
			Service cus = services.get(selectedTableRow);
			return cus;
			
		}
		return null;
	}
	
	public void removeService() {
		this.services.remove(selectedTableRow);
	}
	
	public List<Service> getServices() {
		return this.services;
	}

}
