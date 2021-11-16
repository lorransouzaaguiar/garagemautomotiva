package agendamento.presentation.controller;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.AppProvider;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.util.CustomerMsg;

public class SearchCustomerController {
	 private JTextField fieldName;
	 private JButton btnSearch;
	 private JButton btnOk;
	 private JTable table;
	 private DefaultTableModel tableModel;
	 private AppProvider appProvider = AppProvider.getInstance();
	 private CustomerDAO dao;
	 
	 public SearchCustomerController(CustomerDAO dao) {
		 this.dao = dao;
	 }
	
	public void setUIitems(
			 JTextField fieldName,
			 JButton btnSearch,
			 JButton btnOk,
			 JTable table)
	{
		this.fieldName = fieldName;
		this.btnSearch = btnSearch;
		this.btnOk = btnOk;
		this.table = table;
		this.tableModel = (DefaultTableModel) table.getModel();
		
		this.btnSearch.addActionListener(btnSearchListener());
		this.btnOk.addActionListener(btnOkListener());
	}

	private ActionListener btnSearchListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerName = fieldName.getText();
				if(!customerName.isEmpty()) {
					List<Customer> custumers = dao.searchByName(customerName);
					if(custumers != null) {
						appProvider.showMessageUI(CustomerMsg.SEARCH_SUCCESS.getMessage());
						setCustomerOnTable(custumers);
					} else appProvider.showMessageUI(CustomerMsg.SEARCH_ERROR.getMessage());
				}
			}
		};
	}
	
	private ActionListener btnOkListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
	}
	
	private void setCustomerOnTable(List<Customer> customers) {
		clearDataOnTable();
		customers.forEach(cus -> {
			tableModel.addRow(new Object [] {cus.getName()});
		});
	}
	
	private void clearDataOnTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}
	
}
