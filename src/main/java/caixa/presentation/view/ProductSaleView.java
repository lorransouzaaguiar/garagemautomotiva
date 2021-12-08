package caixa.presentation.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import caixa.presentation.controller.ProductSaleController;
import caixa.presentation.model.CartProduct;
import caixa.presentation.model.SaleViewModel;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import produto.presentation.model.Product;
import shared.CustomTable;
import shared.cliente.SearchCustomerFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductSaleView extends JPanel {
	private JTextField tfProductDesc;
	private CustomTable tableProduct;
	private CustomTable tableCart;
	private JTextField tfCustomer;
	private JLabel lblBack;
	private JLabel lblTotal;
	private JLabel lblReceived;
	private ProductSaleController controller;
	private JButton btnSearchCustomer;
	private JButton btnSearchProduct;
	private JButton btnSale;
	
	private CustomerStore customerStore = CustomerStore.getInstance();
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField tfReceived;
	
	public ProductSaleView(ProductSaleController controller) {
		this.controller = controller;
		initComponents();
		this.tableProduct.setModel(new String[] {"Descrição", "Preço"});
		this.tableCart.setModel(new String[] {"Descrição", "Preço", "Qtd", "Valor"});
		actionButton();
		addEvent();
	}
	
	private void setProductsOnTable(List<Product> products) {
		tableProduct.removeAllData();
		if(!products.isEmpty()) {
			products.forEach(prod -> {
				this.tableProduct.addRow(new Object[] {prod.getDescription(), prod.getPrice()});
			});
		}
	}
	
	private void setProductsOnCart(List<CartProduct> cartProducts) {
		tableCart.removeAllData();
		if(!cartProducts.isEmpty()) {
			cartProducts.forEach(prod -> {
				this.tableCart.addRow(new Object[] {
						prod.getProduct().getDescription(), 
						prod.getProduct().getPrice(), prod.getQty(), prod.getValue()});
			});
		}
	}
	
	private void addEvent() {
		customerStore.addListener(e -> {
			if(e.getPropertyName().equals("getCustomerFromSearch")) {
				Customer customer = customerStore.getCustomer();
				controller.setCustomer(customer);
				tfCustomer.setText(customer.getName());
			}
		});
		
	}
	
	private void actionButton() {
		this.btnSearchCustomer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchCustomerFactory.searchCustomer();
			}
		});
		this.btnSearchProduct.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String description = tfProductDesc.getText();
				SaleViewModel sale = controller.searchProduct(description);
				setProductsOnTable(sale.getProducts());
			}
		});
		this.btnAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableProduct.getSelectedRow();
				SaleViewModel sale = controller.addProductOnCart(index);
				setProductsOnCart(sale.getCartProducts());
				lblTotal.setText(controller.getTotal());
			}
		});
		this.btnRemove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableProduct.getSelectedRow();
				SaleViewModel sale = controller.removeProductOnCart(index);
				setProductsOnCart(sale.getCartProducts());
				lblTotal.setText(controller.getTotal());
			}
		});
		this.btnSale.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.checkout();
			}
		});
		tfReceived.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String received = tfReceived.getText();
				lblBack.setText(controller.getBack(received));
			}
		});
		
	}
	
	private void initComponents() {
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCarrinho, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(scrollPane_1))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCarrinho, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente:");
		lblBuscarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		btnSearchCustomer = new JButton("Buscar");
		
		tfCustomer = new JTextField();
		tfCustomer.setEditable(false);
		tfCustomer.setColumns(10);
		JLabel lblNewLabel = new JLabel("Buscar Produto:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		tfProductDesc = new JTextField();
		tfProductDesc.setColumns(10);
		
		btnSearchProduct = new JButton("Buscar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableProduct = new CustomTable();
		scrollPane.setViewportView(tableProduct);
		
		btnAdd = new JButton("+");
		
		btnRemove = new JButton("-");
		
		JLabel lblDetalhes = new JLabel("Detalhes");
		lblDetalhes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor Recebido");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_2 = new JLabel("Troco");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblTotal = new JLabel("R$ 0.00");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblReceived = new JLabel("R$ ");
		lblReceived.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReceived.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblBack = new JLabel("R$ 0.00");
		lblBack.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfReceived = new JTextField();
		tfReceived.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblReceived, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfReceived, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBack, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblReceived, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfReceived, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblBack, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		btnSale = new JButton("Finalizar");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSale, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(tfCustomer, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblBuscarCliente, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSearchCustomer))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(tfProductDesc, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearchProduct))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove))
						.addComponent(lblDetalhes, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscarCliente)
						.addComponent(btnSearchCustomer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfProductDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearchProduct))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDetalhes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSale, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		tableCart = new CustomTable();
		scrollPane_1.setViewportView(tableCart);
		setLayout(groupLayout);
	}
}
