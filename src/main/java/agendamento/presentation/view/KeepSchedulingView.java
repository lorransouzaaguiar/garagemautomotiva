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

public class KeepSchedulingView extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JPanel formPanel;
	private FormField fieldName;
	private JButton btn;
	private JButton btnCustomer;
	private FormBox formBox;
	Action action;

	public KeepSchedulingView(keepSchedulingController controller, Action action) {
		this.action = action;
		initComponents();
		changeUI();
		controller.setUIitems(fieldName, btnCustomer, formBox, btn, action);
	}
	
	private void changeUI() {
		this.fieldName.setTitle("Cliente");
		this.formBox.setTitle("Serviço");

		switch (action) {
		case NEW: {
			this.title.setText("Novo Agendamento");
			this.btn.setText("Salvar");
		}break;
		case EDIT: {
			this.title.setText("Alterar Agendamento");
			this.btn.setText("Alterar");
		}break;

		default:
			break;
		}
	}
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 442);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.title = new JLabel("Title Customer");
		this.title.setForeground(Color.WHITE);
		this.title.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		this.formPanel = new JPanel();
		this.btn = new JButton("New button");
		this.btn.setMinimumSize(new Dimension(100, 40));
		this.btn.setMaximumSize(new Dimension(100, 40));
		this.btn.setBackground(new Color(53,81,208));
		this.btn.setSize(new Dimension(100, 40));
		this.btn.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer = new JButton("Cliente");
		this.btnCustomer.setSize(new Dimension(100, 40));
		this.btnCustomer.setPreferredSize(new Dimension(100, 40));
		this.btnCustomer.setMinimumSize(new Dimension(100, 40));
		this.btnCustomer.setMaximumSize(new Dimension(100, 40));
		this.btnCustomer.setBackground(new Color(53, 81, 208));
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(this.title, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(548, Short.MAX_VALUE)
					.addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.formPanel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.btnCustomer, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(548, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(this.title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(this.btnCustomer, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(this.formPanel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		this.fieldName = new FormField();
		this.formBox = new FormBox();
		GroupLayout gl_formPanel = new GroupLayout(this.formPanel);
		gl_formPanel.setHorizontalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.fieldName, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(this.formBox, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_formPanel.setVerticalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.formBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.fieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		this.formPanel.setLayout(gl_formPanel);
		this.contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
}
