package produto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.formSwing.components.FormField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;

public class KeepProductView extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JPanel formPanel;
	private FormField fieldName;
	private FormField fieldEmail;
	private FormField fieldNumber;
	private FormField fieldCPF;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeepProductView frame = new KeepProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public KeepProductView() {
		initComponents();
	}
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		this.btn.setBackground(new Color(53,81,208));
		this.btn.setSize(new Dimension(100, 40));
		this.btn.setPreferredSize(new Dimension(100, 40));
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(this.title, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addComponent(this.formPanel, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(551, Short.MAX_VALUE)
					.addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(this.title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(this.formPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(this.btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		this.fieldName = new FormField();
		this.fieldEmail = new FormField();
		this.fieldNumber = new FormField();
		this.fieldCPF = new FormField();
		GroupLayout gl_formPanel = new GroupLayout(this.formPanel);
		gl_formPanel.setHorizontalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.fieldEmail, 0, 0, Short.MAX_VALUE)
						.addComponent(this.fieldName, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(this.fieldCPF, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
						.addComponent(this.fieldNumber, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_formPanel.setVerticalGroup(
			gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.fieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.fieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.fieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(82))
		);
		this.formPanel.setLayout(gl_formPanel);
		this.contentPane.setLayout(gl_contentPane);
	}
}
