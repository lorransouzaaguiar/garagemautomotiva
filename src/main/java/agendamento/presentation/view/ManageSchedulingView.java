package agendamento.presentation.view;
import shared.ManageView;
import javax.swing.table.DefaultTableModel;
import agendamento.presentation.controller.ManageSchedulingController;

public class ManageSchedulingView extends ManageView {

	
	public ManageSchedulingView(ManageSchedulingController controller) {
		initComponents();
		controller.setUIitems(tfSearch, table);
		
		this.btnNew.addActionListener(controller.btnNewListener());
		this.btnEdit.addActionListener(controller.btnEditListener());
		this.btnDelete.addActionListener(controller.btnDeleteListener());
		this.btnSearch.addActionListener(controller.btnSearchListener());
		this.table.addMouseListener(controller.tableListener());
	}
	
	@SuppressWarnings("serial")
	private void initComponents() {
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Servi�o", "Data"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

}
