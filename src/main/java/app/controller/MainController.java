package app.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import agendamento.factory.SchedulingFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.view.ManageSchedulingView;
import caixa.factory.ProductSaleFactory;
import caixa.presentation.view.ProductSaleView;
import cliente.presentation.controller.ManageCustomerController;
import cliente.presentation.view.ManageCustomerView;
import dashboard.factory.DashboardFactory;
import dashboard.view.DashboardView;
import produto.factory.ProductFactory;
import produto.presentation.view.ManageProductView;
import servico.fatory.ServiceFactory;
import servico.presentation.view.ManageServiceView;
import cliente.data.CustomerDAOImpl;
import cliente.factory.CustomerFactory;


public class MainController {
	private JPanel mainPanel;
	private JLabel pageTitle;
	
	private DashboardView dashboardView;
	private ManageCustomerView manageCustomer;
	private ManageSchedulingView manageScheduling;
	private ManageServiceView manageService;
	private ManageProductView manageProductView;
	private ProductSaleView productSaleView;
	
	public MainController(JPanel mainPanel, JLabel pageTitle) {
		this.mainPanel = mainPanel;
		this.pageTitle = pageTitle;
		
		this.dashboardView = DashboardFactory.dashboardView();
		this.manageCustomer = CustomerFactory.manageCustomer();
		this.manageScheduling = SchedulingFactory.manageService();
		this.manageService = ServiceFactory.manageService();
		this.manageProductView = ProductFactory.manageProductView();
		this.productSaleView = ProductSaleFactory.productSaleView();
		changeView(dashboardView);
	}
	
	private void changeView(JPanel manageView) {
		this.mainPanel.removeAll();
		this.mainPanel.add(manageView);
		this.mainPanel.updateUI();
	}
	
	public ActionListener dashboardListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeView(dashboardView);
				pageTitle.setText("Dashboard");
			}
		};
	}

	public ActionListener customerListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeView(manageCustomer);
				pageTitle.setText("Gerenciar Cliente");
			}
		};
	}
	
	public ActionListener schedulingListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeView(manageScheduling);
				pageTitle.setText("Gerenciar Agendamento");
			}
		};
	}
	
	public ActionListener serviceListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeView(manageService);
				pageTitle.setText("Gerenciar Serviço");
			}
		};
	}
	
	public ActionListener productListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeView(manageProductView);
				pageTitle.setText("Gerenciar Produto");
			}
		};
	}
	
	public ActionListener saleListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeView(productSaleView);
				pageTitle.setText("Caixa");
			}
		};
	}
}
