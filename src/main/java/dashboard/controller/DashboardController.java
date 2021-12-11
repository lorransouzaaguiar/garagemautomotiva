package dashboard.controller;

import agendamento.data.SchedulingDAO;
import app.AppProvider;
import cliente.data.CustomerDAO;
import dashboard.model.Dashboard;
import produto.data.ProductDAO;

public class DashboardController {
	private ProductDAO pDao;
	private CustomerDAO cDao;
	private SchedulingDAO sDao;
	private AppProvider appProvider = AppProvider.getInstance();
	
	public DashboardController(ProductDAO pDao, CustomerDAO cDao, SchedulingDAO sDao) {
		this.pDao = pDao;
		this.cDao = cDao;
		this.sDao = sDao;
	}
	
	public Dashboard getData() {
		String prodCount = pDao.count();
		String cusCount = cDao.count();
		String scheCount = sDao.count();
		
		if(prodCount.isEmpty()) {
			appProvider.showMessageUI("Erro ao buscar quantidade de produtos");
		}
		
		if(cusCount.isEmpty()) {
			appProvider.showMessageUI("Erro ao buscar quantidade de clientes");
		}
		
		if(scheCount.isEmpty()) {
			appProvider.showMessageUI("Erro ao buscar quantidade de agendamentos");
		}
		
		return new Dashboard(prodCount, cusCount, scheCount);
	}
}
