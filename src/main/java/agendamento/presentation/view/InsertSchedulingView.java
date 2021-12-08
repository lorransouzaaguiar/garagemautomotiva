package agendamento.presentation.view;

import agendamento.presentation.controller.keepSchedulingController;
import cliente.presentation.model.Customer;


public class InsertSchedulingView extends KeepSchedulingView {

	public InsertSchedulingView(keepSchedulingController controller) {
		super(controller);
		changeUI();
		addEvent();
	}
	
	private void changeUI() {
		this.title.setText("Novo Agendamento");
		this.btnScheduling.setText("Salvar");
	}
	
	private void addEvent() {
		customerStore.addListener(e -> {
			if(e.getPropertyName().equals("getCustomerFromSearch")) {
				Customer customer = customerStore.getCustomer();
				tfCustomer.setText(customer.getName());
			}
		});
	}

}
