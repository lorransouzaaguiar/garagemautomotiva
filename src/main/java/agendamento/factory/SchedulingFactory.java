package agendamento.factory;

import agendamento.data.SchedulingDAOImpl;
import agendamento.data.SchedulingItemDAO;
import agendamento.data.SchedulingItemDAOImpl;
import agendamento.presentation.controller.ManageSchedulingController;
import agendamento.presentation.controller.keepSchedulingController;
import agendamento.presentation.view.InsertSchedulingView;
import agendamento.presentation.view.KeepSchedulingView;
import agendamento.presentation.view.ManageSchedulingView;
import agendamento.presentation.view.UpdateSchedulingView;
import servico.data.ServiceDAOImpl;
import servico.presentation.view.InsertServiceView;

public class SchedulingFactory {
	
	private static keepSchedulingController keepSchedulingController() {
		SchedulingItemDAO itemDao = new SchedulingItemDAOImpl();
		SchedulingDAOImpl dao = new SchedulingDAOImpl(itemDao);
		ServiceDAOImpl serviceDao = new ServiceDAOImpl();
		return new keepSchedulingController(dao, serviceDao);
	}

	public static InsertSchedulingView insertScheduling() {
		return new InsertSchedulingView(keepSchedulingController());
	}
	
	public static UpdateSchedulingView updateScheduling() {
		return new UpdateSchedulingView(keepSchedulingController());
	}
	
	public static ManageSchedulingView manageService() {
		SchedulingItemDAO itemDao = new SchedulingItemDAOImpl();
		SchedulingDAOImpl dao = new SchedulingDAOImpl(itemDao);
		ManageSchedulingController controller = new ManageSchedulingController(dao);
		return new ManageSchedulingView(controller);
	}
}
