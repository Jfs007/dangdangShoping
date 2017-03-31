package entiy;

/**
 * DItem entity. @author MyEclipse Persistence Tools
 */

public class DItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private DOrder DOrder;
	private DProduct DProduct;
	private String productName;
	private Double dangPrice;
	private Integer productNum;
	private Double amount;

	// Constructors

	/** default constructor */
	public DItem() {
	}

	/** full constructor */
	public DItem(DOrder DOrder, DProduct DProduct, String productName,
			Double dangPrice, Integer productNum, Double amount) {
		this.DOrder = DOrder;
		this.DProduct = DProduct;
		this.productName = productName;
		this.dangPrice = dangPrice;
		this.productNum = productNum;
		this.amount = amount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DOrder getDOrder() {
		return this.DOrder;
	}

	public void setDOrder(DOrder DOrder) {
		this.DOrder = DOrder;
	}

	public DProduct getDProduct() {
		return this.DProduct;
	}

	public void setDProduct(DProduct DProduct) {
		this.DProduct = DProduct;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getDangPrice() {
		return this.dangPrice;
	}

	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public Integer getProductNum() {
		return this.productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}