package cliente.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cliente.presentation.controller.keepCustomerController;
import cliente.presentation.model.Customer;

public class InsertCustomerView extends KeepCustomerView {

	public InsertCustomerView(keepCustomerController controller) {
		super(controller);
		changeUI();
		actionButton();
	}

	private void changeUI() {
		this.title.setText("Novo Cliente");
		this.btn.setText("Salvar");
	}

	private void actionButton() {
		this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					Customer customer = new Customer(fieldName.getText(), fieldNumber.getText(), fieldEmail.getText(),
							fieldCPF.getText());
					controller.insert(customer, frame);
				}
			}
		});
	}

}
