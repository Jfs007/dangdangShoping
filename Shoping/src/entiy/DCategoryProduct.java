package entiy;

/**
 * DCategoryProduct entity. @author MyEclipse Persistence Tools
 */

public class DCategoryProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private DCategory DCategory;
	private DProduct DProduct;

	// Constructors

	/** default constructor */
	public DCategoryProduct() {
	}

	/** full constructor */
	public DCategoryProduct(DCategory DCategory, DProduct DProduct) {
		this.DCategory = DCategory;
		this.DProduct = DProduct;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DCategory getDCategory() {
		return this.DCategory;
	}

	public void setDCategory(DCategory DCategory) {
		this.DCategory = DCategory;
	}

	public DProduct getDProduct() {
		return this.DProduct;
	}

	public void setDProduct(DProduct DProduct) {
		this.DProduct = DProduct;
	}

}