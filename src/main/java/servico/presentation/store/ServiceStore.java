package servico.presentation.store;

import java.util.ArrayList;
import java.util.List;

import servico.presentation.model.Service;
import shared.Observable;

public class ServiceStore extends Observable{

	private static ServiceStore instance = null;
	private List<Service> services;
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
	
	public void setState() {
		boolean oldValue = this.state;
		boolean newValue = true;
		this.support.firePropertyChange("getService", oldValue, newValue);
		this.state = false;
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

}
