package dashboard.factory;

import agendamento.data.SchedulingDAOImpl;
import agendamento.data.SchedulingItemDAOImpl;
import cliente.data.CustomerDAOImpl;
import dashboard.controller.DashboardController;
import dashboard.view.DashboardView;
import produto.data.ProductDAOImpl;

public class DashboardFactory {
	
	public static DashboardView dashboardView() {
		ProductDAOImpl pDao = new ProductDAOImpl();
		CustomerDAOImpl cDao = new CustomerDAOImpl();
		SchedulingItemDAOImpl sdaoItem = new SchedulingItemDAOImpl();
		SchedulingDAOImpl sDao = new  SchedulingDAOImpl(sdaoItem);
		DashboardController controller = new DashboardController(pDao, cDao, sDao);
		return new DashboardView(controller);
	}
}
