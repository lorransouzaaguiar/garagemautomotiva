package produto.presentation.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import produto.presentation.controller.KeepProductController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;

public abstract class KeepProductView extends JFrame {
	protected JFrame frame;
	protected JPanel contentPane;
	protected JLabel title;
	protected JPanel formPanel;
	protected FormField fieldDescription;
	protected FormField fieldPrice;
	protected FormField fieldQtyStock;
	protected JButton btn;
	protected FormSwing formSwing;
	protected KeepProductController controller;
	
	
	public KeepProductView(KeepProductController controller) {
		this.controller = controller;
		this.frame = this;
		this.formSwing = new FormSwing();
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
		
		this.fieldDescription.setTitle("Descrição");
		this.fieldPrice.setTitle("Preço");
		this.fieldQtyStock.setTitle("Estoque");
	}
	
	protected boolean isValidForm() {
		FormValidation v = formSwing.formValidation();
		
		String description = fieldDescription.getText();
		String price = fieldPrice.getText();
		
		formSwing
			.field("description", fieldDescription)
			.field("price", fieldPrice)
			.attribute("description", v.string().isRequired(description), "A descriçao é requerida")
			.attribute("price", v.string().isRequired(price), "O preço é requerido");
		
		if(formSwing.isValid())
			return true;
		else {
			formSwing.showErrors();
			return false;
		}
	}
	
	
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 358);
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
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(title, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addComponent(formPanel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(formPanel, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		this.fieldDescription = new FormField();
		this.fieldPrice = new FormField();
		
		fieldQtyStock = new FormField();
		GroupLayout gl_formPanel = new GroupLayout(this.formPanel);
		gl_formPanel.setHorizontalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_formPanel.createSequentialGroup()
							.addComponent(fieldDescription, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(fieldPrice, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addComponent(fieldQtyStock, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_formPanel.setVerticalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fieldQtyStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		this.formPanel.setLayout(gl_formPanel);
		this.contentPane.setLayout(gl_contentPane);
	}
}
