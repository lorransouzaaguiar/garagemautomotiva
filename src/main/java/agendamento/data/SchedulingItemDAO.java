package agendamento.data;

import java.util.List;

import agendamento.presentation.model.Scheduling;
import servico.presentation.model.Service;

public interface SchedulingItemDAO {
	public boolean insert(Scheduling scheduling);
	public List<Service> searchServicesByScheduling(String schedulingId);
}
