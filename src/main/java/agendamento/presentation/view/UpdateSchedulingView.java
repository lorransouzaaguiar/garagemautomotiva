package agendamento.presentation.view;


import agendamento.presentation.controller.keepSchedulingController;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.store.SchedulingStore;

public class UpdateSchedulingView extends KeepSchedulingView {
	private SchedulingStore store = SchedulingStore.getInstance();
	
	public UpdateSchedulingView(keepSchedulingController controller) {
		super(controller);
		changeUI();
		setSchedulingOnFields();
	}
	
	private void changeUI() {
		this.remove(btnCustomer);
		this.title.setText("Alterar Agendamento");
		this.btnScheduling.setText("Alterar");
	}
	
	private void setSchedulingOnFields() {
		Scheduling scheduling = store.getScheduling();
		if (scheduling != null) {
			tfCustomer.setText(scheduling.getCustomer().getName());
			datePicker.setDate(scheduling.getDate());
			tfHour.setText(scheduling.getHour());
			scheduling.getServices().forEach(service -> {
				table.addRow(new Object[] {service.getDescription()});
			});
			
		}
		
	}
}
