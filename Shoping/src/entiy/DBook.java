package entiy;

import java.util.HashSet;
import java.util.Set;

/**
 * DBook entity. @author MyEclipse Persistence Tools
 */

public class DBook implements java.io.Serializable {

	// Fields

	private Integer id;
	private String author;
	private String publishing;
	private Long publishTime;
	private String wordNumber;
	private String whichEdtion;
	private String totalPage;
	private Long printTime;
	private String printNumber;
	private String isbn;
	private String authorSummary;
	private String catalogue;
	private Set DProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public DBook() {
	}

	/** minimal constructor */
	public DBook(String author, String publishing, Long publishTime,
			String authorSummary, String catalogue) {
		this.author = author;
		this.publishing = publishing;
		this.publishTime = publishTime;
		this.authorSummary = authorSummary;
		this.catalogue = catalogue;
	}

	/** full constructor */
	public DBook(String author, String publishing, Long publishTime,
			String wordNumber, String whichEdtion, String totalPage,
			Long printTime, String printNumber, String isbn,
			String authorSummary, String catalogue, Set DProducts) {
		this.author = author;
		this.publishing = publishing;
		this.publishTime = publishTime;
		this.wordNumber = wordNumber;
		this.whichEdtion = whichEdtion;
		this.totalPage = totalPage;
		this.printTime = printTime;
		this.printNumber = printNumber;
		this.isbn = isbn;
		this.authorSummary = authorSummary;
		this.catalogue = catalogue;
		this.DProducts = DProducts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return this.publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public Long getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}

	public String getWordNumber() {
		return this.wordNumber;
	}

	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	public String getWhichEdtion() {
		return this.whichEdtion;
	}

	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}

	public String getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public Long getPrintTime() {
		return this.printTime;
	}

	public void setPrintTime(Long printTime) {
		this.printTime = printTime;
	}

	public String getPrintNumber() {
		return this.printNumber;
	}

	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorSummary() {
		return this.authorSummary;
	}

	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}

	public String getCatalogue() {
		return this.catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public Set getDProducts() {
		return this.DProducts;
	}

	public void setDProducts(Set DProducts) {
		this.DProducts = DProducts;
	}

}