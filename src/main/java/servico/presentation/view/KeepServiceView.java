package servico.presentation.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.formSwing.components.FormField;
import servico.presentation.controller.keepServiceController;
import shared.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;

public class KeepServiceView extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JPanel formPanel;
	private FormField fieldDescription;
	private FormField fieldPrice;
	private JButton btn;
	private  Action action;
	
	public KeepServiceView(keepServiceController controller, Action action) {
		this.action = action;
		initComponents();
		changeUI();
		
		controller.setUIitems(fieldDescription, fieldPrice, btn, action);
	}
	
	private void changeUI() {
		this.fieldDescription.setTitle("Descrição");
		this.fieldPrice.setTitle("Preço");

		switch (action) {
		case NEW: {
			this.title.setText("Novo Serviço");
			this.btn.setText("Salvar");
		}break;
		case EDIT: {
			this.title.setText("Alterar Serviço");
			this.btn.setText("Alterar");
		}break;

		default:
			break;
		}
	}
	
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 265);
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
				.addComponent(this.title, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addComponent(this.formPanel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(548, Short.MAX_VALUE)
					.addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(this.title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(this.formPanel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		this.fieldDescription = new FormField();
		this.fieldPrice = new FormField();
		GroupLayout gl_formPanel = new GroupLayout(this.formPanel);
		gl_formPanel.setHorizontalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.fieldDescription, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(this.fieldPrice, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_formPanel.setVerticalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.fieldDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.fieldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(104))
		);
		this.formPanel.setLayout(gl_formPanel);
		this.contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
