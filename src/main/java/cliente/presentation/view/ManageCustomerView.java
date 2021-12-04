package cliente.presentation.view;

import cliente.factory.CustomerFactory;
import cliente.presentation.controller.ManageCustomerController;
import shared.ManageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManageCustomerView extends ManageView {
	private ManageCustomerController controller;

	public ManageCustomerView(ManageCustomerController controller) {
		super();
		this.controller = controller;
		controller.setUiItem(table);
		actionButton();
		table.setModel(new String[] { "Nome", "Celular", "Email", "CPF" });
	}

	
	private void actionButton() {
		this.btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFactory.insertCustomerView();
			}
		});

		this.btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.update();
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete();
			}
		});

		this.btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfSearch.getText();
				controller.search(name);
			}
		});

	}

}
