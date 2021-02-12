package com.cg.zmart.dto;

public class ProductDTO {
	private Long prodID;
	private String prodName;
	private Double prodPrice;
	private Long prodQuantity;
	private String prodDescription;
	private String prodCategory;
	private String prodImageUrl;

	public Long getProdID() {
		return prodID;
	}

	public void setProdID(Long prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Long getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(Long prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdImageUrl() {
		return prodImageUrl;
	}

	public void setProdImageUrl(String prodImageUrl) {
		this.prodImageUrl = prodImageUrl;
	}
}
