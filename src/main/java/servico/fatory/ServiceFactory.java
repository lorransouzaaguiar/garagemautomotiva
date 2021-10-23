package servico.fatory;

import servico.data.ServiceDAOImpl;
import servico.presentation.controller.ManageServiceController;
import servico.presentation.controller.keepServiceController;
import servico.presentation.view.KeepServiceView;
import servico.presentation.view.ManageServiceView;
import shared.Action;

public class ServiceFactory {
	
	public static KeepServiceView keepService(Action action) {
		ServiceDAOImpl dao = new ServiceDAOImpl();
		keepServiceController controller = new keepServiceController(dao);
		return new KeepServiceView(controller, action);
	}
	
	public static ManageServiceView manageService() {
		ServiceDAOImpl dao = new ServiceDAOImpl();
		ManageServiceController controller = new ManageServiceController(dao);
		return new ManageServiceView(controller);
	}
	
	
}
