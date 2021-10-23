package agendamento.factory;

import agendamento.data.SchedulingDAOImpl;
import agendamento.presentation.controller.ManageSchedulingController;
import agendamento.presentation.controller.keepSchedulingController;
import agendamento.presentation.view.KeepSchedulingView;
import agendamento.presentation.view.ManageSchedulingView;
import shared.Action;

public class SchedulingFactory {

	public static KeepSchedulingView keepScheduling(Action action) {
		SchedulingDAOImpl dao = new SchedulingDAOImpl();
		keepSchedulingController controller = new keepSchedulingController(dao);
		return new KeepSchedulingView(controller, action);
	}
	
	public static ManageSchedulingView manageService() {
		SchedulingDAOImpl dao = new SchedulingDAOImpl();
		ManageSchedulingController controller = new ManageSchedulingController(dao);
		return new ManageSchedulingView(controller);
	}
}
