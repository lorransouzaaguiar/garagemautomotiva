package servico.data;

import java.util.ArrayList;
import java.util.List;

import servico.presentation.model.Service;

public class ServiceDAOImpl implements ServiceDAO{

	@Override
	public boolean insert(Service customer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean update(Service customer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Service> searchByName(String name) {
		Service ser1 = new Service("motor", 25);
		Service ser2 = new Service("carro", 32);
		List<Service> services = new ArrayList<>();
		services.add(ser1);
		services.add(ser2);
		return services;
	}

	@Override
	public List<Service> searchAll() {
		
		return null;
	}

	
}
