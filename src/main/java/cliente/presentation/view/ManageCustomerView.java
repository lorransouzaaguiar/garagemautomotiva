package cliente.presentation.view;
import cliente.presentation.controller.ManageCustomerController;
import shared.ManageView;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ManageCustomerView  extends ManageView{

	public ManageCustomerView(ManageCustomerController controller) {
		super();
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
				"Nome", "Celular", "Email", "CPF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		centerDataColumns();
	}

}
