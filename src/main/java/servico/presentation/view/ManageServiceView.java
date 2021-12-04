package servico.presentation.view;

import javax.swing.JPanel;

import shared.ManageView;
import javax.swing.table.DefaultTableModel;

import servico.presentation.controller.ManageServiceController;

public class ManageServiceView extends ManageView {

	
	public ManageServiceView(ManageServiceController controller) {
		initComponents();
		controller.setUIitems(tfSearch, table);
		
		this.btnNew.addActionListener(controller.btnNewListener());
		this.btnEdit.addActionListener(controller.btnEditListener());
		this.btnDelete.addActionListener(controller.btnDeleteListener());
		this.btnSearch.addActionListener(controller.btnSearchListener());
		this.table.addMouseListener(controller.tableListener());
	}
	
	@SuppressWarnings("serial")
	public void initComponents() {
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

}
