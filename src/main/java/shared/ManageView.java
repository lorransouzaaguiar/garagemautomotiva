package shared;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class ManageView extends JPanel {
	protected JButton btnNew;
	protected JButton btnEdit;
	protected JButton btnDelete;
	protected JButton btnSearch;
	protected JScrollPane scrollPane;
	protected JTextField tfSearch;
	protected CustomTable table;

	protected ManageView() {
		initComponents();
	}
	
	private void initComponents() {
		setPreferredSize(new Dimension(693, 308));
		setSize(new Dimension(700, 500));
		this.btnNew = new JButton("Novo");
		this.btnNew.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.btnNew.setForeground(new Color(255, 255, 240));
		this.btnNew.setBackground(new Color(53,81,208));
		this.btnNew.setSize(new Dimension(100, 40));
		this.btnNew.setPreferredSize(new Dimension(100, 40));
		this.btnEdit = new JButton("Editar");
		this.btnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.btnEdit.setForeground(new Color(255, 255, 240));
		this.btnEdit.setSize(new Dimension(100, 40));
		this.btnEdit.setPreferredSize(new Dimension(100, 40));
		this.btnEdit.setBackground(new Color(53, 81, 208));
		this.btnDelete = new JButton("Excluir");
		this.btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.btnDelete.setForeground(new Color(255, 255, 240));
		this.btnDelete.setSize(new Dimension(100, 40));
		this.btnDelete.setPreferredSize(new Dimension(100, 40));
		this.btnDelete.setBackground(new Color(53, 81, 208));
		this.btnSearch = new JButton("Pesquisar");
		this.btnSearch.setSize(new Dimension(100, 40));
		this.btnSearch.setPreferredSize(new Dimension(100, 40));
		this.btnSearch.setForeground(new Color(255, 255, 240));
		this.btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.btnSearch.setBackground(new Color(53, 81, 208));
		this.scrollPane = new JScrollPane();
		this.tfSearch = new JTextField();
		this.tfSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.tfSearch.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSearch, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addComponent(btnNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tfSearch))
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addContainerGap())
		);
		{
			this.table = new CustomTable();
			this.table.setRowMargin(10);
			this.table.setRowHeight(40);
			this.table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			table.setSelectionBackground(new Color(53,81,208));
			this.scrollPane.setViewportView(this.table);
			
		}
		setLayout(groupLayout);
	}
}
