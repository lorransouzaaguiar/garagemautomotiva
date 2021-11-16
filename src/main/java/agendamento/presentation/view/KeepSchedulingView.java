package agendamento.presentation.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import agendamento.presentation.controller.keepSchedulingController;
import br.com.formSwing.components.FormBox;
import br.com.formSwing.components.FormField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;

import shared.Action;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KeepSchedulingView extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JButton btnScheduling;
	private JButton btnCustomer;
	Action action;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCustomer_1;
	private JLabel lblNewLabel_2;

	public KeepSchedulingView(keepSchedulingController controller, Action action) {
		this.action = action;
		initComponents();
		changeUI();
	}
	
	private void changeUI() {

		switch (action) {
		case NEW: {
			this.title.setText("Novo Agendamento");
			this.btnScheduling.setText("Salvar");
		}break;
		case EDIT: {
			this.title.setText("Alterar Agendamento");
			this.btnScheduling.setText("Alterar");
		}break;

		default:
			break;
		}
	}
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 442);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.title = new JLabel("Title Customer");
		this.title.setForeground(Color.WHITE);
		this.title.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		this.btnScheduling = new JButton("Agendar");
		this.btnScheduling.setMinimumSize(new Dimension(100, 40));
		this.btnScheduling.setMaximumSize(new Dimension(100, 40));
		this.btnScheduling.setBackground(new Color(53,81,208));
		this.btnScheduling.setSize(new Dimension(100, 40));
		this.btnScheduling.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer = new JButton("Buscar Cliente");
		this.btnCustomer.setSize(new Dimension(100, 40));
		this.btnCustomer.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer.setMinimumSize(new Dimension(100, 40));
		this.btnCustomer.setMaximumSize(new Dimension(100, 40));
		this.btnCustomer.setBackground(new Color(53, 81, 208));
		
		this.lblNewLabel = new JLabel("Cliente");
		this.textField = new JTextField();
		this.textField.setEditable(false);
		this.textField.setColumns(10);
		this.lblNewLabel_1 = new JLabel("Servi\u00E7o");
		this.comboBox = new JComboBox();
		this.scrollPane = new JScrollPane();
		this.btnCustomer_1 = new JButton("Add");
		this.btnCustomer_1.setSize(new Dimension(100, 40));
		this.btnCustomer_1.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer_1.setMinimumSize(new Dimension(100, 40));
		this.btnCustomer_1.setMaximumSize(new Dimension(100, 40));
		this.btnCustomer_1.setBackground(new Color(53, 81, 208));
		
		this.lblNewLabel_2 = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(548, Short.MAX_VALUE)
							.addComponent(this.btnScheduling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(this.lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(this.comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(this.lblNewLabel)
											.addGap(170))
										.addComponent(this.textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(this.lblNewLabel_2)
										.addComponent(this.btnCustomer_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(this.title, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
							.addGap(33)
							.addComponent(this.btnCustomer, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(this.scrollPane, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(this.title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.btnCustomer, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(this.lblNewLabel)
						.addComponent(this.lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.textField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(this.lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(this.btnCustomer_1, 0, 0, Short.MAX_VALUE)
						.addComponent(this.comboBox))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.scrollPane, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(this.btnScheduling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		{
			this.table = new JTable();
			this.table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Servi\u00E7o", "Hora"
				}
			));
			this.scrollPane.setViewportView(this.table);
		}
		this.contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
}
