package agendamento.presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import agendamento.presentation.controller.SearchCustomerController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchCustomerView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JTable table;
	private SearchCustomerController controller;

	
	public SearchCustomerView(SearchCustomerController controller) {
		initComponents();
		setVisible(true);
		this.controller = controller;
		this.controller.setUIitems(textField, btnSearch, btnOk, table);
	}
	
	private void initComponents() {
		setTitle("Buscar Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 310);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.textField = new JTextField();
		this.textField.setColumns(10);
		this.btnSearch = new JButton("Buscar");
		this.scrollPane = new JScrollPane();
		this.btnOk = new JButton("OK");
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(this.scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(this.textField, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(this.btnSearch))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(502, Short.MAX_VALUE)
							.addComponent(this.btnOk)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(this.textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.btnSearch))
					.addGap(29)
					.addComponent(this.scrollPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(this.btnOk)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		{
			this.table = new JTable();
			this.table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome"
				}
			));
			this.scrollPane.setViewportView(this.table);
		}
		this.contentPane.setLayout(gl_contentPane);
	}
}