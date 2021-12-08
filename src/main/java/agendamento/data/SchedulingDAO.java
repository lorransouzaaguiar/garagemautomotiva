package agendamento.data;

import java.util.Date;
import java.util.List;

import agendamento.presentation.model.Scheduling;

public interface SchedulingDAO {
	public boolean insert(Scheduling scheduling);
	public boolean update(Scheduling scheduling);
	public boolean delete(String id);
	public List<Scheduling> searchByDate(Date date);
	public List<Scheduling> searchAll();
}
