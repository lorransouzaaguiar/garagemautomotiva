package shared.br.com.formSwing.internal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public abstract class Input extends JPanel{
	protected JLabel title;
	protected JLabel errorMessage;
	protected GroupLayout groupLayout;
	protected JPanel panel;
	public Input() {
		initComponents();
	}
	
	private void initComponents() {
		setPreferredSize(new Dimension(350, 90));
		setSize(new Dimension(350, 90));
		title = new JLabel("Title");
		this.title.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		this.errorMessage = new JLabel();
		this.errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.errorMessage.setForeground(Color.RED);
		this.panel = new JPanel();
		this.groupLayout = new GroupLayout(this);
		this.groupLayout.setHorizontalGroup(
			this.groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(this.title, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
				.addComponent(this.errorMessage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
				.addComponent(this.panel, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
		);
		this.groupLayout.setVerticalGroup(
			this.groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(this.groupLayout.createSequentialGroup()
					.addComponent(this.title)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(this.errorMessage)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		this.panel.setLayout(new BorderLayout(0, 0));
		setLayout(groupLayout);
	}
	
	public void setTitle(String text) {
		this.title.setText(text);
	}
	
	public void setText(String text) {
		
	}
	
	public String getText() {
		return null;
	}
	
	public void setErrorMessage(String text) {
		this.errorMessage.setText(text);
	}
}
