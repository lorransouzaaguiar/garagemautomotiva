package agendamento.presentation.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import agendamento.presentation.controller.keepSchedulingController;
import agendamento.presentation.model.Scheduling;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;
import shared.CustomTable;
import shared.cliente.SearchCustomerFactory;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JFormattedTextField;

public abstract class KeepSchedulingView extends JFrame {
	protected JFrame frame;
	protected JPanel contentPane;
	protected JLabel title;
	protected JButton btnScheduling;
	protected JButton btnCustomer;
	protected JLabel lblNewLabel;
	protected JTextField tfCustomer;
	protected JComboBox<String> cbService;
	protected JScrollPane scrollPane;
	protected CustomTable table;
	protected JButton btnAddService;
	protected JPanel panel;
	protected JPanel panel_1;
	protected JLabel lblServio;
	protected JPanel panel_2;
	protected JLabel lblNewLabel_1;
	protected JXDatePicker datePicker;
	protected JPanel panel_3;
	protected JLabel lblHora;
	protected JFormattedTextField tfHour;
	protected keepSchedulingController controller;
	
	protected CustomerStore customerStore = CustomerStore.getInstance();
	protected ServiceStore serviceStore = ServiceStore.getInstance();
	
	private List<Service> scheduledServices = new ArrayList<>();
	
	public KeepSchedulingView(keepSchedulingController controller) {
		this.controller = controller;
		this.frame = this;
		initComponents();
		setLocationRelativeTo(null);
		addEvent();
		actionButton();
		controller.serchServices();
	}

	protected MaskFormatter maskFormat() {
		try {
			return new MaskFormatter("##:##");
		} catch (ParseException error) {
			return null;
		}
	}
	
	private void addEvent() {
		serviceStore.addListener(e -> {
			if(e.getPropertyName().equals("getServicesFromSearch")) {
				List<Service> services = serviceStore.getServices();
				services.forEach(service -> cbService.addItem(service.getDescription()));
			}
		});
	}
	
	private void actionButton() {
		this.btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomerFactory.searchCustomer();
			}
		});

		this.btnAddService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbService.getSelectedIndex() != -1) {
					List<Service> services = serviceStore.getServices();
					int comboBoxIndex = cbService.getSelectedIndex();
					Service service = services.get(comboBoxIndex);
					scheduledServices.add(service);
					table.addRow(new String [] {service.getDescription()});
				}
				
			}
		});

		this.btnScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = customerStore.getCustomer();
				Date date = datePicker.getDate();
				String hour = tfHour.getText();
				Scheduling scheduling = new Scheduling(customer, scheduledServices, date, hour);
				controller.insert(scheduling, frame);
			}
		});
	}

	private void initComponents() {
		setMinimumSize(new Dimension(500, 650));
		setPreferredSize(new Dimension(500, 800));
		setSize(new Dimension(500, 800));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 442);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.title = new JLabel("Title Customer");
		this.title.setForeground(Color.WHITE);
		this.title.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		this.btnScheduling = new JButton("Agendar");
		this.btnScheduling.setMinimumSize(new Dimension(100, 40));
		this.btnScheduling.setMaximumSize(new Dimension(100, 40));
		this.btnScheduling.setBackground(new Color(53, 81, 208));
		this.btnScheduling.setSize(new Dimension(100, 40));
		this.btnScheduling.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer = new JButton("Buscar Cliente");
		this.btnCustomer.setSize(new Dimension(100, 40));
		this.btnCustomer.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer.setMinimumSize(new Dimension(100, 40));
		this.btnCustomer.setMaximumSize(new Dimension(100, 40));
		this.btnCustomer.setBackground(new Color(53, 81, 208));
		this.scrollPane = new JScrollPane();
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.lblServio = new JLabel("Serviços");
		this.cbService = new JComboBox();
		this.cbService.setPreferredSize(new Dimension(68, 26));
		this.cbService.setMinimumSize(new Dimension(68, 26));
		this.btnAddService = new JButton("Add");
		this.btnAddService.setSize(new Dimension(100, 40));
		this.btnAddService.setPreferredSize(new Dimension(100, 40));
		this.btnAddService.setMinimumSize(new Dimension(100, 40));
		this.btnAddService.setMaximumSize(new Dimension(100, 40));
		this.btnAddService.setBackground(new Color(53, 81, 208));
		GroupLayout gl_panel_1 = new GroupLayout(this.panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(this.lblServio)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(this.cbService, GroupLayout.PREFERRED_SIZE, 219,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnAddService,
												GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(this.lblServio)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(this.cbService, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(this.btnAddService, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.panel_1.setLayout(gl_panel_1);

		this.panel_2 = new JPanel();

		this.lblNewLabel_1 = new JLabel("Data");
		this.datePicker = new JXDatePicker();
		this.datePicker.getEditor().setEditable(false);
		GroupLayout gl_panel_2 = new GroupLayout(this.panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addComponent(this.lblNewLabel_1).addContainerGap(3,
						Short.MAX_VALUE))
				.addComponent(this.datePicker, GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(this.lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(this.datePicker, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.panel_2.setLayout(gl_panel_2);
		this.panel_3 = new JPanel();
		this.lblHora = new JLabel("Hora");
		tfHour = new JFormattedTextField(maskFormat());
		GroupLayout gl_panel_3 = new GroupLayout(this.panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(this.lblHora, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
				.addComponent(tfHour, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(this.lblHora)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfHour, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)));
		this.panel_3.setLayout(gl_panel_3);
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(this.scrollPane,
								GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
								this.btnScheduling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(6).addComponent(this.title,
								GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(this.panel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(this.panel_2, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(this.panel_3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
								this.btnCustomer, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(this.panel_1,
								GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(this.title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(12)
				.addComponent(this.btnCustomer, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(this.panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(this.panel_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(this.panel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addComponent(this.panel_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
				.addGap(8).addComponent(this.scrollPane, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.btnScheduling,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(27)));
		this.tfCustomer = new JTextField();
		tfCustomer.setEditable(false);
		this.tfCustomer.setColumns(10);

		this.lblNewLabel = new JLabel("Cliente");
		GroupLayout gl_panel = new GroupLayout(this.panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(this.tfCustomer, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
				.addComponent(this.lblNewLabel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(this.lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(this.tfCustomer, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.panel.setLayout(gl_panel);
		{
			this.table = new CustomTable();
			this.table.setModel(new String[] { "Serviços" });
			this.scrollPane.setViewportView(this.table);
		}
		this.contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
}
