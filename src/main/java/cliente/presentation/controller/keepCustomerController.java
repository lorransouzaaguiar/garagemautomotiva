package cliente.presentation.controller;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import app.AppProvider;
import br.com.formSwing.FormSwing;
import br.com.formSwing.components.FormField;
import br.com.formSwing.validation.FormValidation;
import cliente.data.CustomerDAO;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import cliente.presentation.util.CustomerMsg;
import shared.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class keepCustomerController implements ActionListener{
	
	private JFrame frame;
	private FormField fieldName;
	private FormField fieldEmail;
	private FormField fieldNumber;
	private FormField fieldCPF;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btn;
	private FormSwing formSwing;
	private Action action;
	private CustomerDAO dao;
	private AppProvider appProvider = AppProvider.getInstance();
	private CustomerStore store = CustomerStore.getInstance();
	
	public keepCustomerController(CustomerDAO dao){
		this.dao = dao;
		this.formSwing = new FormSwing();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isValidForm()) {
			switch (action) {
				case NEW:{
					if(dao.insert(createNewCustomer())) {
						appProvider.showMessageUI(CustomerMsg.NEW_SUCCESS.getMessage());
						frame.dispose();
					}	
					else appProvider.showMessageUI(CustomerMsg.NEW_ERROR.getMessage());
				}break;
				case EDIT:{
					Customer editedCustomer = createEditedCustomer();
					if(dao.update(editedCustomer)) {
						store.actionSetChangedCustomer(editedCustomer);
						appProvider.showMessageUI(CustomerMsg.EDIT_SUCCESS.getMessage());
						frame.dispose();
					}
					else appProvider.showMessageUI(CustomerMsg.EDIT_ERROR.getMessage());
				}break;
			}
		}
	}	
	
	private void addListener() {
		if(action.equals(action.EDIT)) {
			store.addListener(e -> {
				if(e.getPropertyName().equals("getCustomer")) {
					Customer cus = store.getCustomer();
					if(cus != null) {
						setCustomerOnFields(cus);
					}
				}
			});
			
			store.actionSetCustomerOnFields();
		}
	}
	
	private boolean isValidForm() {
		FormValidation v = formSwing.formValidation();
		
		String name = fieldName.getText();
		String email = fieldEmail.getText();
		String number = fieldNumber.getText();
		
		formSwing
			.field("name", fieldName)
			.field("email", fieldEmail)
			.field("number", fieldNumber)
			.attribute("name", v.string().isRequired(name), "O nome é requerido")
			.attribute("email", v.string().isEmail(email), "O email precisa ser válido")
			.attribute("number", v.string().isDigit(number), "O número precisa ser um digito");
		
		if(formSwing.isValid())
			return true;
		else {
			formSwing.showErrors();
			return false;
		}
	}
	
	private Customer createNewCustomer() {
		Customer customer = new Customer(
				fieldName.getText(), 
				fieldNumber.getText(), 
				fieldEmail.getText(), 
				fieldCPF.getText()
		);
		return customer;
	}
	
	private Customer createEditedCustomer() {
		Customer customer = new Customer(
				store.getCustomer().getId(),
				fieldName.getText(), 
				fieldNumber.getText(), 
				fieldEmail.getText(), 
				fieldCPF.getText()
		);
		return customer;
	}
	
	private void setCustomerOnFields(Customer cus) {
		this.fieldName.setText(cus.getName());
		this.fieldNumber.setText(cus.getNumber());
		this.fieldEmail.setText(cus.getEmail());
		this.fieldCPF.setText(cus.getCpf());
	}
	
	public void setUIitems(
			JFrame frame,
			FormField fieldName, 
			FormField fieldEmail, 
			FormField fieldNumber, 
			FormField fieldCPF,
			JButton btn, 
			Action action) 
	{
		this.frame = frame;
		this.fieldName = fieldName;
		this.fieldEmail = fieldEmail;
		this.fieldNumber = fieldNumber;
		this.fieldCPF = fieldCPF;
		this.btn = btn;
		this.action = action;
		addListener();
		this.btn.addActionListener(this);
	}
}
