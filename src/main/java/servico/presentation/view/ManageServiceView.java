package servico.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shared.ManageView;
import servico.fatory.ServiceFactory;
import servico.presentation.controller.ManageServiceController;

public class ManageServiceView extends ManageView {
	private ManageServiceController controller;

	public ManageServiceView(ManageServiceController controller) {
		this.controller = controller;
		controller.setUiItem(table);
		actionButton();
		table.setModel(new String[] { "Descrição", "Preço" });
	}
	

	private void actionButton() {
		this.btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceFactory.insertServiceView();
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
