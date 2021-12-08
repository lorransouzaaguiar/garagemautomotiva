package produto.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cliente.presentation.controller.keepCustomerController;
import cliente.presentation.model.Customer;
import cliente.presentation.store.CustomerStore;
import produto.presentation.controller.KeepProductController;
import produto.presentation.model.Product;
import produto.presentation.store.ProductStore;

public class UpdateProductView extends KeepProductView {
	
	private ProductStore store = ProductStore.getInstance();

	public UpdateProductView(KeepProductController controller) {
		super(controller);
		actionButton();
		changeUI();
		setDataOnFields();
	}

	private void changeUI() {
		this.title.setText("Alterar Produto");
		this.btn.setText("Alterar");
	}
	
	
	private void setDataOnFields() {
		Product prod = store.getProduct();
		String price = String.valueOf(prod.getPrice());
		String qtyStock = String.valueOf(prod.getQtyStock());
		
		if(prod != null) {
			this.fieldDescription.setText(prod.getDescription());
			this.fieldPrice.setText(price);
			this.fieldQtyStock.setText(qtyStock);
		}
		
	}

	private void actionButton() {
		this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					String id = store.getProduct().getId();
					String description = fieldDescription.getText();
					double price = Double.parseDouble(fieldPrice.getText());
					int qtyStock = Integer.parseInt(fieldQtyStock.getText());
					Product product = new Product(id, description, price, qtyStock);
					controller.update(product, frame);
				}
			}
		});
	}

}
