package servico.data;

import java.util.List;

import servico.presentation.model.Service;

public interface ServiceDAO {
	public boolean insert(Service service);
	public boolean update(Service service);
	public boolean delete(String id);
	public List<Service> searchByName(String name);
	public List<Service> searchAll();
}
