package agendamento.presentation.controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;
import agendamento.data.SchedulingDAO;
import agendamento.factory.SearchCustomerFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.store.SchedulingStore;
import app.AppProvider;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import servico.data.ServiceDAOImpl;
import servico.presentation.model.Service;
import shared.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class keepSchedulingController {

	private JTextField tfCustomer;
	private JButton btnCustomer;
	private JButton btnScheduling;
	private JComboBox<String> cbService;
	private JFormattedTextField tfHour;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnAddService;
	private JXDatePicker datePicker;
	private Action action;

	private SchedulingDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private SchedulingStore store = SchedulingStore.getInstance();
	private CustomerStore customerStore = CustomerStore.getInstance();

	private ServiceDAOImpl serviceDao;
	private List<Service> services;
	private List<Service> requestedServices = new ArrayList<>();

	public keepSchedulingController(SchedulingDAO dao) {
		this.dao = dao;
		this.serviceDao = new ServiceDAOImpl();
		this.services = serviceDao.searchAll();
	}

	public void setUIitems(JTextField tfCustomer, JButton btnCustomer, JButton btnScheduling,
			JComboBox<String> cbService, JFormattedTextField tfHour, JTable table, JButton btnAddService,
			JXDatePicker datePicker, Action action) {
		
		this.tfCustomer = tfCustomer;
		this.btnCustomer = btnCustomer;
		this.btnScheduling = btnScheduling;
		this.tfHour = tfHour;
		this.cbService = cbService;
		this.table = table;
		this.tableModel = (DefaultTableModel) table.getModel();
		this.btnAddService = btnAddService;
		this.datePicker = datePicker;
		this.action = action;

		addListener();
		setServiceOnView();
		this.btnScheduling.addActionListener(shedulingListener());
		this.btnCustomer.addActionListener(customerListener());
		this.btnAddService.addActionListener(addServiceListener());
	}

	private ActionListener shedulingListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = customerStore.getCustomer();
				Date date = datePicker.getDate();
				String hour = tfHour.getText();
				Scheduling scheduling = new Scheduling(customer, requestedServices, date, hour);
				
				if(dao.insert(scheduling))
					appProvider.showMessageUI("Agendamento cadastrado com sucesso");
				else appProvider.showMessageUI("Falha ao cadastrar agendamento");
			}
		};
	}

	private void setServiceOnView() {
		cbService.addItem("");
		if (services != null)
			services.forEach(service -> cbService.addItem(service.getDescription()));
	}

	private ActionListener customerListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomerFactory.searchCustomer();
			}
		};
	}

	private ActionListener addServiceListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cbService.getSelectedItem().equals("")) {
					Service service = services.get(cbService.getSelectedIndex());
					tableModel.addRow(new Object[] { cbService.getSelectedItem() });
					requestedServices.add(service);
				} else
					appProvider.showMessageUI("Selecione um serviço");
			}
		};
	}

	private void addListener() {
		if (action.equals(action.EDIT)) {
			store.addListener(e -> {
				if (e.getPropertyName().equals("getService")) {
					Scheduling sche = store.getScheduling();
					if (sche != null) {
						setDataOnFields(sche);
					}
				}
			});

			store.setState();
		}

		customerStore.addListener(e -> {
			if (e.getPropertyName().equals("getCustomerFromSearch")) {
				Customer customer = customerStore.getCustomer();
				this.tfCustomer.setText(customer.getName());
			}
		});

		store.setState();

	}

	private void setDataOnFields(Scheduling scheduling) {

	}

}
