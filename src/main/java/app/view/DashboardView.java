package app.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DashboardView extends JPanel {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_3;

	public DashboardView() {

		initComponents();
	}
	private void initComponents() {
		this.panel = new JPanel();
		this.panel.setBackground(new Color(53,81,208));
		this.panel_1 = new JPanel();
		this.panel_1.setBackground(new Color(53, 81, 208));
		this.lblNewLabel_2 = new JLabel("Clientes");
		this.lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		this.lblNewLabel_3 = new JLabel("3");
		this.lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		this.lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		GroupLayout gl_panel_1 = new GroupLayout(this.panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(this.lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(this.lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addComponent(this.lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.panel_1.setLayout(gl_panel_1);
		this.panel_2 = new JPanel();
		this.panel_2.setBackground(new Color(53, 81, 208));
		this.lblNewLabel_4 = new JLabel("Clientes");
		this.lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		this.lblNewLabel_5 = new JLabel("3");
		this.lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
		this.lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		GroupLayout gl_panel_2 = new GroupLayout(this.panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 183, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(this.lblNewLabel_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(this.lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addComponent(this.lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.panel_2.setLayout(gl_panel_2);
		this.panel_3 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(this.panel_3, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(224))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(this.panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(this.panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(this.panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(26))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(this.panel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(this.panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(this.panel_3, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		this.lblNewLabel = new JLabel("Clientes");
		this.lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		this.lblNewLabel_1 = new JLabel("3");
		this.lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		this.lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel = new GroupLayout(this.panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(this.lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(this.lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addComponent(this.lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
}
