package agendamento.data;

import java.util.List;

import agendamento.presentation.model.Scheduling;

public interface SchedulingDAO {
	public boolean insert(Scheduling service);
	public boolean update(Scheduling service);
	public boolean delete(String id);
	public List<Scheduling> searchByName(String name);
	public List<Scheduling> searchAll();
}
