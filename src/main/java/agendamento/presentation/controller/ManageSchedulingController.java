package agendamento.presentation.controller;

import java.util.Date;
import java.util.List;
import agendamento.data.SchedulingDAO;
import agendamento.factory.SchedulingFactory;
import agendamento.presentation.model.Scheduling;
import agendamento.presentation.store.SchedulingStore;
import agendamento.presentation.util.SchedulingMsg;
import app.AppProvider;
import shared.CustomTable;

public class ManageSchedulingController {
	private AppProvider appProvider = AppProvider.getInstance();
	private SchedulingDAO dao;
	private SchedulingStore store = SchedulingStore.getInstance();

	public ManageSchedulingController(SchedulingDAO dao) {
		this.dao = dao;
	}

	public void update(CustomTable table) {
		store.setSelectedTableRow(table.getSelectedRow());

		if (table.getSelectedRow() != -1)
			SchedulingFactory.updateScheduling();
		else
			appProvider.showMessageUI(SchedulingMsg.TABLE_WARNING.getMessage());
	}

	public void delete(CustomTable table) {
		int selectedTableRow = table.getSelectedRow();
		
		if (table.lineIsSelected()) {
			store.setSelectedTableRow(selectedTableRow);
			String id = store.getScheduling().getId();

			if (dao.delete(id)) {
				store.removeScheduling();
				table.removeRow(selectedTableRow);
				appProvider.showMessageUI(SchedulingMsg.DELETE_SUCCESS.getMessage());
			} else
				appProvider.showMessageUI(SchedulingMsg.DELETE_ERROR.getMessage());
		} else
			appProvider.showMessageUI(SchedulingMsg.TABLE_WARNING.getMessage());
	}

	// search
	public void search(CustomTable table, Date date) {
		if (date != null) {
			List<Scheduling> schedulings = dao.searchByDate(date);
			if (!schedulings.isEmpty()) {
				store.setSchedulingList(schedulings);
				setDataOnTable(table, schedulings);
				appProvider.showMessageUI(SchedulingMsg.SEARCH_SUCCESS.getMessage());
			}else appProvider.showMessageUI(SchedulingMsg.SEARCH_EMPTY.getMessage());
		} else
			appProvider.showMessageUI(SchedulingMsg.SEARCH_ERROR.getMessage());
	}

	public void setDataOnTable(CustomTable table, List<Scheduling> schedulings) {
		table.removeAllData();
		schedulings.forEach(sche -> {
			table.addRow(new Object[] { sche.getCustomer().getName(), sche.getHour() });
		});
	}
	// search

}
