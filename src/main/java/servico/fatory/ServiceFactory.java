package servico.fatory;

import servico.data.ServiceDAOImpl;
import servico.presentation.controller.ManageServiceController;
import servico.presentation.controller.keepServiceController;
import servico.presentation.view.InsertServiceView;
import servico.presentation.view.KeepServiceView;
import servico.presentation.view.ManageServiceView;
import servico.presentation.view.UpdateServiceView;
import shared.Action;

public class ServiceFactory {
	
	private static keepServiceController keepServiceController() {
		ServiceDAOImpl dao = new ServiceDAOImpl();
		return new keepServiceController(dao);
	}
	
	public static InsertServiceView insertServiceView() {
		return new InsertServiceView(keepServiceController());
	}
	
	public static UpdateServiceView updateServiceView() {
		return new UpdateServiceView(keepServiceController());
	}
	
	public static ManageServiceView manageService() {
		ServiceDAOImpl dao = new ServiceDAOImpl();
		ManageServiceController controller = new ManageServiceController(dao);
		return new ManageServiceView(controller);
	}
	
}
