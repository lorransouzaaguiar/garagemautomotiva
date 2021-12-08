package agendamento.presentation.view;

import shared.CustomTable;
import shared.ManageView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import agendamento.factory.SchedulingFactory;
import agendamento.presentation.controller.ManageSchedulingController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXDatePicker;

public class ManageSchedulingView extends ManageView {
	private JXDatePicker datePicker;
	private ManageSchedulingController controller;

	public ManageSchedulingView(ManageSchedulingController controller) {
		this.controller = controller;
		changeUI();
		table.setModel(new String[] {"Nome do Cliente", "Hora" });
		actionButton();
		
	}
	
	private void actionButton() {
		this.btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SchedulingFactory.insertScheduling();
			}
		});

		this.btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.update(table);
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete(table);
			}
		});

		this.btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = datePicker.getDate();
				controller.search(table, date);
			}
		});
	}
	
	private void changeUI() {
		this.datePicker = new JXDatePicker();
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
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
