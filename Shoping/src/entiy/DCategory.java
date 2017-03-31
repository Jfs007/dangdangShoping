package entiy;

import java.util.HashSet;
import java.util.Set;

/**
 * DCategory entity. @author MyEclipse Persistence Tools
 */

public class DCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer turn;
	private String enName;
	private String name;
	private String description;
	private Integer parentId;
	private Set DCategoryProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public DCategory() {
	}

	/** minimal constructor */
	public DCategory(Integer turn, String enName, String name) {
		this.turn = turn;
		this.enName = enName;
		this.name = name;
	}

	/** full constructor */
	public DCategory(Integer turn, String enName, String name,
			String description, Integer parentId, Set DCategoryProducts) {
		this.turn = turn;
		this.enName = enName;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
		this.DCategoryProducts = DCategoryProducts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurn() {
		return this.turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Set getDCategoryProducts() {
		return this.DCategoryProducts;
	}

	public void setDCategoryProducts(Set DCategoryProducts) {
		this.DCategoryProducts = DCategoryProducts;
	}

}