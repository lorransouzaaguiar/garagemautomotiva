package agendamento.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import agendamento.data.SchedulingDAO;
import agendamento.factory.SchedulingFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.store.SchedulingStore;
import app.AppProvider;
import shared.Action;

public class ManageSchedulingController {
	private JTextField tfSearch;
	private JTable table;
	private DefaultTableModel tableModel;
	private AppProvider appProvider = AppProvider.getInstance();
	private SchedulingDAO dao;
	private SchedulingStore store = SchedulingStore.getInstance();
	
	public ManageSchedulingController(SchedulingDAO dao) {
		this.dao = dao;
	}
	
	public ActionListener btnNewListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SchedulingFactory.keepScheduling(Action.NEW);
			}
		};
	}
	
	public ActionListener btnEditListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1)
					SchedulingFactory.keepScheduling(Action.EDIT);
				else appProvider.showMessageUI("Selecione uma linha da tabela");
			}
		};
	}
	
	public ActionListener btnDeleteListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTableRow = table.getSelectedRow();
				if(selectedTableRow != -1) {
					String id = store.getScheduling().getId();
					if(dao.delete(id)) {
						store.removeScheduling();
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
					List<Scheduling> schedulings = dao.searchByName(name);
					store.setServiceList(schedulings);
					setDataOnTable(schedulings);
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
	
	private void setDataOnTable(List<Scheduling> schedulings) {
		schedulings.forEach(ser -> {
			
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
