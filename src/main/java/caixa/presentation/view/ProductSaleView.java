package caixa.presentation.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import caixa.presentation.controller.ProductSaleController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ProductSaleView extends JPanel {
	private JTextField tfProductDesc;
	private JTable tableProduct;
	private JTable tableCart;
	private JTextField tfCustomer;
	private JLabel lblBack;
	private JLabel blbTotal;
	private JLabel lblReceived;
	private ProductSaleController controller;
	private JButton btnSearchCustomer;
	private JButton btnSearchProduct;
	private JButton btnSale;

	public ProductSaleView(ProductSaleController controller) {
		this.controller = controller;
		initComponents();
		actionButton();
	}
	
	private void actionButton() {
		this.btnSearchCustomer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.btnSearchProduct.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.btnSale.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	private void initComponents() {
		JLabel lblNewLabel = new JLabel("Buscar Produto:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		tfProductDesc = new JTextField();
		tfProductDesc.setColumns(10);
		
		btnSearchProduct = new JButton("Buscar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("+");
		
		JButton btnNewButton_1_1 = new JButton("-");
		
		JLabel lblDetalhes = new JLabel("Detalhes");
		lblDetalhes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		
		tfCustomer = new JTextField();
		tfCustomer.setEditable(false);
		tfCustomer.setColumns(10);
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente:");
		lblBuscarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		btnSearchCustomer = new JButton("Buscar");
		
		btnSale = new JButton("Finalizar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDetalhes, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(tfProductDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSearchProduct))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tfCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearchCustomer, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBuscarCliente, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSale, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCarrinho, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
							.addGap(350))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarrinho, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBuscarCliente, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearchCustomer))
							.addGap(13)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfProductDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearchProduct))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_1_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDetalhes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSale, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
					.addGap(15))
		);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor Recebido");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_2 = new JLabel("Troco");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		blbTotal = new JLabel("R$ 45,00");
		blbTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		blbTotal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblReceived = new JLabel("R$ 20,00");
		lblReceived.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReceived.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblBack = new JLabel("Total");
		lblBack.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(blbTotal, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblReceived, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBack, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(blbTotal, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblReceived, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblBack, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		tableCart = new JTable();
		scrollPane_1.setViewportView(tableCart);
		
		tableProduct = new JTable();
		scrollPane.setViewportView(tableProduct);
		setLayout(groupLayout);
	}
}
