package agendamento.presentation.view;

import shared.Action;
import shared.ManageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import agendamento.factory.SchedulingFactory;
import agendamento.presentation.controller.ManageSchedulingController;

public class ManageSchedulingView extends ManageView {
	
	private ManageSchedulingController controller;

	public ManageSchedulingView(ManageSchedulingController controller) {
		this.controller = controller;
		controller.setUiItem(table);
		actionButton();
		
		table.setModel(new String[] {"Cliente", "Serviço", "Data" });
	}
	
	private void actionButton() {
		this.btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SchedulingFactory.keepScheduling(Action.NEW);
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
