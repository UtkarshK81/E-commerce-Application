package com.cg.zmart.model;

public class ProductModel {

	private Long id;
	private String productName;
	private double unitPrice;
	private long productQuantity;
	private String productDescription;
	private String productCategory;
	private String imageUrl;

	public ProductModel() {
		super();
	}

	public ProductModel(Long id, String productName, double unitPrice, long productQuantity, String productDescription,
			String productCategory, String imageUrl) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
