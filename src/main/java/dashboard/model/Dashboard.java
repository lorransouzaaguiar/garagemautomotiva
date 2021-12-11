package dashboard.model;

public class Dashboard {
	private String productCount;
	private String customerCount;
	private String schedulingCount;
	
	public Dashboard(String productCount, String customerCount, String schedulingCount) {
		super();
		this.productCount = productCount;
		this.customerCount = customerCount;
		this.schedulingCount = schedulingCount;
	}

	public String getProductCount() {
		return productCount;
	}

	public String getCustomerCount() {
		return customerCount;
	}

	public String getSchedulingCount() {
		return schedulingCount;
	}
	
}
