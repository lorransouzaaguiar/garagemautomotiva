package cliente.presentation.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import cliente.presentation.controller.keepCustomerController;
import shared.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class KeepCustomerView extends JFrame {
	
	protected JFrame frame;
	protected JPanel contentPane;
	protected JLabel title;
	protected JPanel formPanel;
	protected FormField fieldName;
	protected FormField fieldEmail;
	protected FormField fieldNumber;
	protected FormField fieldCPF;
	protected JButton btn;
	protected keepCustomerController controller;
	private FormSwing formSwing;
	
	public KeepCustomerView(keepCustomerController controller) {
		this.formSwing = new FormSwing();
		this.frame = this;
		this.controller = controller;
		
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
		
		this.fieldName.setTitle("Nome");
		this.fieldNumber.setTitle("Celular");
		this.fieldEmail.setTitle("Email");
		this.fieldCPF.setTitle("CPF");
		
	}
	
	protected boolean isValidForm() {
		FormValidation v = formSwing.formValidation();
		
		String name = fieldName.getText();
		String email = fieldEmail.getText();
		String number = fieldNumber.getText();
		
		formSwing
			.field("name", fieldName)
			.field("email", fieldEmail)
			.field("number", fieldNumber)
			.attribute("name", v.string().isRequired(name), "O nome é requerido")
			.attribute("email", v.string().isEmail(email), "O email precisa ser válido")
			.attribute("number", v.string().isDigit(number), "O número precisa ser um digito");
		
		if(formSwing.isValid())
			return true;
		else {
			formSwing.showErrors();
			return false;
		}
	}
	

	protected void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 359);
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
		this.btn.setBackground(new Color(53, 81, 208));
		this.btn.setSize(new Dimension(100, 40));
		this.btn.setPreferredSize(new Dimension(100, 40));
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(this.title, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addComponent(this.formPanel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap(551, Short.MAX_VALUE).addComponent(this.btn,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(this.title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(this.formPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(72, Short.MAX_VALUE)));
		this.fieldName = new FormField();
		this.fieldEmail = new FormField();
		this.fieldNumber = new FormField();
		this.fieldCPF = new FormField();
		GroupLayout gl_formPanel = new GroupLayout(this.formPanel);
		gl_formPanel.setHorizontalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(this.fieldEmail, 0, 0, Short.MAX_VALUE)
								.addComponent(this.fieldName, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(this.fieldCPF, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
								.addComponent(this.fieldNumber, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
						.addContainerGap()));
		gl_formPanel.setVerticalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_formPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.fieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(this.fieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(this.fieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(82)));
		this.formPanel.setLayout(gl_formPanel);
		this.contentPane.setLayout(gl_contentPane);
	}
}
