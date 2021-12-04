package servico.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import shared.ManageView;
import javax.swing.table.DefaultTableModel;

import app.AppProvider;
import servico.fatory.ServiceFactory;
import servico.presentation.controller.ManageServiceController;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import servico.presentation.util.ServiceMsg;

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
