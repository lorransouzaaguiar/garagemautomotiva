package app.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import agendamento.factory.SchedulingFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.view.ManageSchedulingView;
import cliente.presentation.controller.ManageCustomerController;
import cliente.presentation.view.ManageCustomerView;
import servico.fatory.ServiceFactory;
import servico.presentation.view.ManageServiceView;
import cliente.data.CustomerDAOImpl;
import cliente.factory.CustomerFactory;


public class MainController {
	private JPanel mainPanel;
	private JLabel pageTitle;
	
	public MainController(JPanel mainPanel, JLabel pageTitle) {
		this.mainPanel = mainPanel;
		this.pageTitle = pageTitle;
	}
	
	private void changeView(JPanel manageView) {
		this.mainPanel.removeAll();
		this.mainPanel.add(manageView);
		this.mainPanel.updateUI();
	}

	public ActionListener customerListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageCustomerView manageCustomer = CustomerFactory.manageCustomer();
				changeView(manageCustomer);
				pageTitle.setText("Gerenciar Cliente");
			}
		};
	}
	
	public ActionListener schedulingListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSchedulingView manageScheduling = SchedulingFactory.manageService();
				changeView(manageScheduling);
				pageTitle.setText("Gerenciar Agendamento");
			}
		};
	}
	
	public ActionListener serviceListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageServiceView manageService = ServiceFactory.manageService();
				changeView(manageService);
				pageTitle.setText("Gerenciar Serviço");
			}
		};
	}
}
