package shared.br.com.formSwing.components;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;

import shared.br.com.formSwing.internal.Input;

public class FormBox extends Input{
	private JComboBox comboBox;
	
	public FormBox() {
		initComponents();
	}
	private void initComponents() {
		{
			this.comboBox = new JComboBox();
			this.comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(this.comboBox, BorderLayout.CENTER);
		}
	}
	
	
	public void setText(String text) {
		this.comboBox.setSelectedItem(text);
	}
	
	public String getText() {
		Object selectedItem = this.comboBox.getSelectedItem();
		if( selectedItem != null) {
			String text = String.valueOf(selectedItem);
			return text;
		}
		return null;
	}
	
	
}
