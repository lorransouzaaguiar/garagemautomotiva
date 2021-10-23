package servico.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import app.AppProvider;
import cliente.factory.CustomerFactory;
import servico.data.ServiceDAO;
import servico.fatory.ServiceFactory;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import shared.Action;

public class ManageServiceController {
	private JTextField tfSearch;
	private JTable table;
	private DefaultTableModel tableModel;
	private AppProvider appProvider = AppProvider.getInstance();
	private ServiceDAO dao;
	private ServiceStore store = ServiceStore.getInstance();
	
	public ManageServiceController(ServiceDAO dao) {
		this.dao = dao;
	}
	
	public ActionListener btnNewListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceFactory.keepService(Action.NEW);
			}
		};
	}
	
	public ActionListener btnEditListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1)
					ServiceFactory.keepService(Action.EDIT);
				else appProvider.showMessageUI("Selecione uma linha da tabela");
			}
		};
	}
	
	public ActionListener btnDeleteListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTableRow = table.getSelectedRow();
				if(selectedTableRow != -1) {
					String id = store.getService().getId();
					if(dao.delete(id)) {
						store.removeService();
						tableModel.removeRow(selectedTableRow);
						appProvider.showMessageUI("Serviço deletado com sucesso!");
					}
					else appProvider.showMessageUI("Falha ao deletar serviço!");
				}
				else appProvider.showMessageUI("Selecione uma linha da tabela");
			}
		};
	}
	
	public ActionListener btnSearchListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfSearch.getText();
				if(!name.isEmpty()) {
					List<Service> services = dao.searchByName(name);
					store.setServiceList(services);
					setServiceOnTable(services);
				}else appProvider.showMessageUI("Insira o nome a ser pesquisado!");
			}
		};
	}
	
	public MouseAdapter tableListener() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				store.setSelectedTableRow(table.getSelectedRow());
			}
		};
	}
	
	private void setServiceOnTable(List<Service> services) {
		services.forEach(ser -> {
			String price = String.valueOf(ser.getPrice());
			tableModel.addRow(new Object[] {
					ser.getDescription(),
					price
			});
		});
	}
	
	public void setUIitems(
			JTextField tfSearch, 
			JTable table) 
	{
		this.tfSearch = tfSearch;
		this.table = table;
		this.tableModel = (DefaultTableModel) table.getModel();
	
	}
}
