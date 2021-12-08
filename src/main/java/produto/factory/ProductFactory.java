package produto.factory;
import produto.data.ProductDAOImpl;
import produto.presentation.controller.KeepProductController;
import produto.presentation.controller.ManageProductController;
import produto.presentation.view.InsertProdutctView;
import produto.presentation.view.ManageProductView;
import produto.presentation.view.UpdateProductView;

public class ProductFactory {
	
	public static ManageProductView manageProductView() {
		ProductDAOImpl dao = new ProductDAOImpl();
		ManageProductController controller = new ManageProductController(dao);
		return new ManageProductView(controller);
	}
	
	private static KeepProductController keepProductController() {
		ProductDAOImpl dao = new ProductDAOImpl();
		return new KeepProductController(dao);
	}
	
	public static InsertProdutctView insertProductView() {
		return new InsertProdutctView(keepProductController());
	}
	
	public static UpdateProductView updateProductView() {
		return new UpdateProductView(keepProductController());
	}
}
