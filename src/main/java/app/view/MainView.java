package app.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.controller.MainController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JButton btnDashboard;
	private JButton btnScheduling;
	private JButton btnService;
	private JButton btnProduct;
	private JPanel sidePanel;
	private JLabel logo;
	private JButton btnSell;
	private JLabel pageTitle;
	private MainController controller;
	private JButton btnCustomer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView() {
		initComponents();
		setLocationRelativeTo(null);
		
		this.controller = new MainController(mainPanel, pageTitle);
		
		this.btnDashboard.addActionListener(controller.dashboardListener());
		this.btnCustomer.addActionListener(controller.customerListener());
		this.btnScheduling.addActionListener(controller.schedulingListener());
		this.btnService.addActionListener(controller.serviceListener());
		this.btnProduct.addActionListener(controller.productListener());
		this.btnSell.addActionListener(controller.saleListener());
	}
	
	private void initComponents() {
		setMinimumSize(new Dimension(960, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 468);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.BLACK);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.mainPanel = new JPanel();
		this.mainPanel.setForeground(new Color(60, 63, 65));
		this.mainPanel.setLayout(new BorderLayout(0, 0));
		this.sidePanel = new JPanel();
		this.sidePanel.setBackground(Color.BLACK);
		
		this.pageTitle = new JLabel("Dashboard");
		this.pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.pageTitle.setForeground(Color.WHITE);
		this.pageTitle.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(this.sidePanel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(this.mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(this.pageTitle, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(this.pageTitle, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.mainPanel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
						.addComponent(this.sidePanel, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
					.addGap(0))
		);
		this.buttonPanel = new JPanel();
		this.buttonPanel.setBackground(Color.BLACK);
		this.buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			this.btnDashboard = new JButton("Dashboard");
			this.btnDashboard.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			this.btnDashboard.setForeground(Color.WHITE);
			this.btnDashboard.setBackground(new Color(53,81,208));
			this.btnDashboard.setSize(new Dimension(100, 40));
			this.btnDashboard.setPreferredSize(new Dimension(130, 40));
			this.btnDashboard.setMaximumSize(new Dimension(100, 40));
			this.btnDashboard.setMinimumSize(new Dimension(100, 40));
			this.buttonPanel.add(this.btnDashboard);
		}
		{
			this.btnCustomer = new JButton("Cliente");
			this.btnCustomer.setSize(new Dimension(100, 40));
			this.btnCustomer.setPreferredSize(new Dimension(130, 40));
			this.btnCustomer.setMinimumSize(new Dimension(100, 40));
			this.btnCustomer.setMaximumSize(new Dimension(100, 40));
			this.btnCustomer.setForeground(Color.WHITE);
			this.btnCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			this.btnCustomer.setBackground(new Color(53, 81, 208));
			this.buttonPanel.add(this.btnCustomer);
		}
		{
			this.btnScheduling = new JButton("Agendamento");
			this.btnScheduling.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			this.btnScheduling.setForeground(Color.WHITE);
			this.btnScheduling.setBackground(new Color(53,81,208));
			this.btnScheduling.setSize(new Dimension(100, 40));
			this.btnScheduling.setPreferredSize(new Dimension(130, 40));
			this.btnScheduling.setMinimumSize(new Dimension(100, 40));
			this.btnScheduling.setMaximumSize(new Dimension(100, 40));
			this.buttonPanel.add(this.btnScheduling);
		}
		{
			this.btnService = new JButton("Servi\u00E7o");
			this.btnService.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			this.btnService.setForeground(Color.WHITE);
			this.btnService.setBackground(new Color(53,81,208));
			this.btnService.setSize(new Dimension(100, 40));
			this.btnService.setPreferredSize(new Dimension(130, 40));
			this.btnService.setMinimumSize(new Dimension(100, 40));
			this.btnService.setMaximumSize(new Dimension(100, 40));
			this.buttonPanel.add(this.btnService);
		}
		{
			this.btnProduct = new JButton("Produto");
			this.btnProduct.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			this.btnProduct.setForeground(Color.WHITE);
			this.btnProduct.setBackground(new Color(53,81,208));
			this.btnProduct.setSize(new Dimension(100, 40));
			this.btnProduct.setPreferredSize(new Dimension(130, 40));
			this.btnProduct.setMinimumSize(new Dimension(100, 40));
			this.btnProduct.setMaximumSize(new Dimension(100, 40));
			this.buttonPanel.add(this.btnProduct);
		}
		this.logo = new JLabel("logo");
		GroupLayout gl_sidePanel = new GroupLayout(this.sidePanel);
		gl_sidePanel.setHorizontalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(this.buttonPanel, GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE)
				.addComponent(this.logo, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
		);
		gl_sidePanel.setVerticalGroup(
			gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
					.addComponent(this.logo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.buttonPanel, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
		);
		
		this.btnSell = new JButton("Caixa");
		this.btnSell.setSize(new Dimension(100, 40));
		this.btnSell.setPreferredSize(new Dimension(130, 40));
		this.btnSell.setMinimumSize(new Dimension(100, 40));
		this.btnSell.setMaximumSize(new Dimension(100, 40));
		this.btnSell.setForeground(Color.WHITE);
		this.btnSell.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.btnSell.setBackground(new Color(53, 81, 208));
		this.buttonPanel.add(this.btnSell);
		this.sidePanel.setLayout(gl_sidePanel);
		this.contentPane.setLayout(gl_contentPane);
	}
}
