package agendamento.presentation.model;

import java.util.UUID;

public class SchedulingItem {
	private String id;
	private String schedulingId;
	private String serviceId;
	
	public SchedulingItem(String schedulingId, String serviceId) {
		super();
		this.id = UUID.randomUUID().toString();
		this.schedulingId = schedulingId;
		this.serviceId = serviceId;
	}

	public String getId() {
		return id;
	}

	public String getSchedulingId() {
		return schedulingId;
	}

	public String getServiceId() {
		return serviceId;
	}
	
}
