package produto.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import produto.presentation.controller.KeepProductController;
import produto.presentation.model.Product;

public class InsertProdutctView extends KeepProductView {

	public InsertProdutctView(KeepProductController controller) {
		super(controller);
		changeUI();
		actionButton();
	}

	private void changeUI() {
		this.title.setText("Novo Produto");
		this.btn.setText("Salvar");
	}

	private void actionButton() {
		this.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					double price = Double.parseDouble(fieldPrice.getText());
					int qtyStock = Integer.parseInt(fieldQtyStock.getText());
					Product product = new Product(fieldDescription.getText(), price, qtyStock);
					controller.insert(product, frame);
				}
			}
		});
	}

}
