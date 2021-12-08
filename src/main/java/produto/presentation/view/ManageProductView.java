package produto.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cliente.factory.CustomerFactory;
import produto.factory.ProductFactory;
import produto.presentation.controller.ManageProductController;
import shared.ManageView;

public class ManageProductView extends ManageView {
	
	private ManageProductController controller;
	
	public ManageProductView(ManageProductController controller) {
		this.controller = controller;
		table.setModel(new String[] {"Descrição", "Preço"});
		controller.setUiItem(table);
		actionButton();
	}
	
	private void actionButton() {
		this.btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductFactory.insertProductView();
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
				String description = tfSearch.getText();
				controller.search(description);
			}
		});

	}

}
