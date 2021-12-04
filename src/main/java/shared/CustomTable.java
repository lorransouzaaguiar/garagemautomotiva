package shared;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends JTable{
	
	private DefaultTableModel tableModel;
	protected DefaultTableCellRenderer centerRenderer;
	
	public CustomTable() {
		this.centerRenderer = new DefaultTableCellRenderer();
	}
	
	public void setModel(String[] columnHeader) {
		int size = columnHeader.length;
		
		this.setModel(new DefaultTableModel() {
			boolean[] columnEditables = allUneditableColumns(size);

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		this.tableModel = (DefaultTableModel) this.getModel();
		this.tableModel.setColumnIdentifiers(columnHeader);
		this.centerDataColumns();
	}
	
	private boolean[] allUneditableColumns(int size) {
		boolean[] columnEditables = new boolean[size];
		for(int i = 0; i < size; i++) {
			columnEditables[i] = false;
		}
		
		return columnEditables;
	}
	
	private void centerDataColumns() {
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		int columnCount = tableModel.getColumnCount();
		for (int i = 0; i < columnCount; i++) {
			this.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
	}
	
	public boolean lineIsSelected() {
		int selectedTableRow = this.getSelectedRow();
		if(selectedTableRow != -1) {
			return true;
		}
		
		return false;
	}
	
	public void removeRow(int index) {
		tableModel.removeRow(index);
	}
	
	public void addRow(Object[] rowData) {
		tableModel.addRow(rowData);
	}
	
	public void removeAllData() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

}
