package entiy;

import java.util.HashSet;
import java.util.Set;

/**
 * DProduct entity. @author MyEclipse Persistence Tools
 */

public class DProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private DBook DBook;
	private String productName;
	private String description;
	private Long addTime;
	private Double fixedPrice;
	private Double dangPrice;
	private String keywords;
	private Integer hasDeleted;
	private String productPic;
	private Set DCategoryProducts = new HashSet(0);
	private Set DItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public DProduct() {
	}

	/** minimal constructor */
	public DProduct(DBook DBook, String productName, Double fixedPrice,
			Double dangPrice, Integer hasDeleted) {
		this.DBook = DBook;
		this.productName = productName;
		this.fixedPrice = fixedPrice;
		this.dangPrice = dangPrice;
		this.hasDeleted = hasDeleted;
	}

	/** full constructor */
	public DProduct(DBook DBook, String productName, String description,
			Long addTime, Double fixedPrice, Double dangPrice, String keywords,
			Integer hasDeleted, String productPic, Set DCategoryProducts,
			Set DItems) {
		this.DBook = DBook;
		this.productName = productName;
		this.description = description;
		this.addTime = addTime;
		this.fixedPrice = fixedPrice;
		this.dangPrice = dangPrice;
		this.keywords = keywords;
		this.hasDeleted = hasDeleted;
		this.productPic = productPic;
		this.DCategoryProducts = DCategoryProducts;
		this.DItems = DItems;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DBook getDBook() {
		return this.DBook;
	}

	public void setDBook(DBook DBook) {
		this.DBook = DBook;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	public Double getFixedPrice() {
		return this.fixedPrice;
	}

	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public Double getDangPrice() {
		return this.dangPrice;
	}

	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getHasDeleted() {
		return this.hasDeleted;
	}

	public void setHasDeleted(Integer hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public String getProductPic() {
		return this.productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public Set getDCategoryProducts() {
		return this.DCategoryProducts;
	}

	public void setDCategoryProducts(Set DCategoryProducts) {
		this.DCategoryProducts = DCategoryProducts;
	}

	public Set getDItems() {
		return this.DItems;
	}

	public void setDItems(Set DItems) {
		this.DItems = DItems;
	}

}