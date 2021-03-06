package servico.presentation.view;

import servico.presentation.controller.keepServiceController;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateServiceView extends KeepServiceView {
	private ServiceStore store = ServiceStore.getInstance();

	public UpdateServiceView(keepServiceController controller) {
		super(controller);
		actionButton();
		changeUI();
		setServiceOnFields();
	}

	private void changeUI() {
		this.title.setText("Alterar Servi?o");
		this.btn.setText("Alterar");
	}

	private void setServiceOnFields() {
		Service service = store.getService();
		if (service != null) {
			String price = String.valueOf(service.getPrice()).replace(".", ",");
			fieldDescription.setText(service.getDescription());
			fieldPrice.setText(price);
		}
		
	}

	private void actionButton() {
		this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					Service service = new Service(store.getService().getId(), fieldDescription.getText(),
							fieldPrice.getText());
					controller.update(service, frame);
				}
			}

		});
	}
}
