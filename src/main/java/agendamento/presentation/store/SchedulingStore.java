package agendamento.presentation.store;

import java.util.ArrayList;
import java.util.List;

import agendamento.presentation.model.Scheduling;
import servico.presentation.model.Service;
import shared.Observable;

public class SchedulingStore extends Observable{

	private static SchedulingStore instance = null;
	private List<Scheduling> scheduling;
	private int selectedTableRow = -1;
	private boolean state = false;
	
	private SchedulingStore() {
		this.scheduling = new ArrayList<>();
	}

	public static SchedulingStore getInstance() {
		if (instance == null) {
			instance = new SchedulingStore();
		}

		return instance;
	}
	
	public void setSchedulingList(List<Scheduling> scheduling) {
		this.scheduling = scheduling;
	}
	
	public void setSelectedTableRow(int index) {
		this.selectedTableRow = index;
	}
	
	public void setState() {
		boolean oldValue = this.state;
		boolean newValue = true;
		this.support.firePropertyChange("getScheduling", oldValue, newValue);
		this.state = false;
	}
	
	public Scheduling getScheduling() {
		if(selectedTableRow != -1) {
			Scheduling cus = scheduling.get(selectedTableRow);
			return cus;
			
		}
		return null;
	}
	
	public void removeScheduling() {
		this.scheduling.remove(selectedTableRow);
	}

}
