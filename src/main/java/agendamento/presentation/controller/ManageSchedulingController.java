package agendamento.presentation.controller;

import java.util.List;
import agendamento.data.SchedulingDAO;
import agendamento.factory.SchedulingFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.store.SchedulingStore;
import app.AppProvider;
import shared.Action;
import shared.CustomTable;

public class ManageSchedulingController {
	private AppProvider appProvider = AppProvider.getInstance();
	private SchedulingDAO dao;
	private SchedulingStore store = SchedulingStore.getInstance();
	private CustomTable table;
	
	public ManageSchedulingController(SchedulingDAO dao) {
		this.dao = dao;
	}
	
	public void setUiItem(CustomTable table) {
		this.table = table;
	}
	
	public void update() {
		store.setSelectedTableRow(table.getSelectedRow());
		
		if (table.getSelectedRow() != -1)
			SchedulingFactory.keepScheduling(Action.EDIT);
		else
			appProvider.showMessageUI("Selecione uma linha da tabela");
	}
	
	public void delete() {
		store.setSelectedTableRow(table.getSelectedRow());
		
		int selectedTableRow = table.getSelectedRow();
		if (selectedTableRow != -1) {
			String id = store.getScheduling().getId();
			
			if (dao.delete(id)) {
				store.removeScheduling();
				table.removeRow(selectedTableRow);
				appProvider.showMessageUI("Serviço deletado com sucesso!");
			} else
				appProvider.showMessageUI("Falha ao deletar serviço!");
		} else
			appProvider.showMessageUI("Selecione uma linha da tabela");
	}
	
	//search
	public void search(String name) {
		if (!name.isEmpty()) {
			List<Scheduling> schedulings = dao.searchByName(name);
			store.setServiceList(schedulings);
			setDataOnTable(schedulings);
		} else
			appProvider.showMessageUI("Insira o nome a ser pesquisado!");
	}
	
	private void setDataOnTable(List<Scheduling> schedulings) {
		schedulings.forEach(ser -> {
			
		});
	}
	//search
	
}
