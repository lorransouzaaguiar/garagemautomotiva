package servico.presentation.view;

import servico.presentation.controller.keepServiceController;
import servico.presentation.model.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertServiceView extends KeepServiceView {

	public InsertServiceView(keepServiceController controller) {
		super(controller);
		changeUI();
		actionButton();
	}

	private void changeUI() {
		this.title.setText("Novo Serviço");
		this.btn.setText("Salvar");
	}

	private void actionButton() {
		this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					Service service = new Service(fieldDescription.getText(), fieldPrice.getText());
					controller.insert(service, frame);
				}
			}

		});
	}
}
