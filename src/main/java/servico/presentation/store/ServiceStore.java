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
	
	public void dispatchServicesToScheduling(List<Service> services) {
		setServiceList(services);
		this.support.firePropertyChange("getServicesFromSearch", false, true);
	}
	
	public void dispatchChangedService(Service service) {
		this.services.set(selectedTableRow, service);
		this.support.firePropertyChange("changedService", false, true);
	}
	
	public Service getService() {
		if(selectedTableRow != -1) {
			Service serv = services.get(selectedTableRow);
			return serv;
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
