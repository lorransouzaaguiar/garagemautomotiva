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
		addListener();
	}

	private void changeUI() {
		this.title.setText("Alterar Serviço");
		this.btn.setText("Alterar");
	}

	private void addListener() {
		store.addListener(e -> {
			if (e.getPropertyName().equals("getService")) {
				Service serv = store.getService();
				if (serv != null) {
					setServiceOnFields(serv);
				}
			}
		});

		store.actionSetServiceOnFields();
	}

	private void setServiceOnFields(Service service) {
		String price = String.valueOf(service.getPrice()).replace(".", ",");
		fieldDescription.setText(service.getDescription());
		fieldPrice.setText(price);
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
