package servico.presentation.controller;

import java.util.List;
import app.AppProvider;
import servico.data.ServiceDAO;
import servico.fatory.ServiceFactory;
import servico.presentation.model.Service;
import servico.presentation.store.ServiceStore;
import servico.presentation.util.ServiceMsg;
import shared.CustomTable;

public class ManageServiceController {

	private ServiceDAO dao;
	private ServiceStore store = ServiceStore.getInstance();
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomTable table;

	public ManageServiceController(ServiceDAO dao) {
		this.dao = dao;
		addListener();
	}

	public void setUiItem(CustomTable table) {
		this.table = table;
	}

	public void update() {
		if (table.lineIsSelected()) {
			store.setSelectedTableRow(table.getSelectedRowCount());
			ServiceFactory.updateServiceView();
		}
			
		else
			appProvider.showMessageUI(ServiceMsg.TABLE_WARNING.getMessage());
	}

	public void delete() {
		if (table.lineIsSelected()) {
			store.setSelectedTableRow(table.getSelectedRow());
			String id = store.getService().getId();

			if (dao.delete(id)) {
				store.removeService();
				table.removeRow(table.getSelectedRow());
				appProvider.showMessageUI(ServiceMsg.DELETE_SUCCESS.getMessage());
			}

			else
				appProvider.showMessageUI(ServiceMsg.DELETE_ERROR.getMessage());
		} else
			appProvider.showMessageUI(ServiceMsg.TABLE_WARNING.getMessage());
	}

	
	public void search(String name) {
		if (!name.isEmpty()) {
			List<Service> services = dao.searchByName(name);

			if (!services.isEmpty()) {
				store.setServiceList(services);
				setServiceOnTable(services);
				appProvider.showMessageUI(ServiceMsg.SEARCH_SUCCESS.getMessage());

			} else
				appProvider.showMessageUI(ServiceMsg.SEARCH_ERROR.getMessage());

		} else
			appProvider.showMessageUI(ServiceMsg.SEARCHFIELD_EMPTY.getMessage());
	}
	
	
	/* Search */
	public void addListener() {
		store.addListener(e -> {
			if (e.getPropertyName().equals("changedService")) {
				table.removeAllData();
				List<Service> updatedServices = store.getServices();
				setServiceOnTable(updatedServices);
			}
		});
	}

	public void setServiceOnTable(List<Service> services) {
		table.removeAllData();
		services.forEach(ser -> {
			String price = String.valueOf(ser.getPrice());
			table.addRow(new Object[] { ser.getDescription(), price });
		});
	}
	/* Search */
}
