package cliente.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cliente.presentation.controller.keepCustomerController;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;

public class UpdateCustomerView extends KeepCustomerView {
	
	private CustomerStore store = CustomerStore.getInstance();

	public UpdateCustomerView(keepCustomerController controller) {
		super(controller);
		changeUI();
		actionButton();
		addListener();
	}

	private void changeUI() {
		this.title.setText("Alterar Cliente");
		this.btn.setText("Alterar");
	}
	
	private void addListener() {
		store.addListener(e -> {
			if(e.getPropertyName().equals("getCustomer")) {
				Customer cus = store.getCustomer();
				if(cus != null) {
					setCustomerOnFields(cus);
				}
			}
		});
		
		store.actionSetCustomerOnFields();
	}
	
	
	private void setCustomerOnFields(Customer cus) {
		this.fieldName.setText(cus.getName());
		this.fieldNumber.setText(cus.getNumber());
		this.fieldEmail.setText(cus.getEmail());
		this.fieldCPF.setText(cus.getCpf());
	}

	private void actionButton() {
		this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					Customer customer = new Customer(store.getCustomer().getId(), fieldName.getText(),
							fieldNumber.getText(), fieldEmail.getText(), fieldCPF.getText());
					controller.update(customer, frame);
				}

			}
		});
	}

}
