package com.cg.zmart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

	@Id
	@GeneratedValue
	private long prodId;

	@NotNull
	@Size(min = 1, max = 255, message = "Give your product a name.")
	private String prodName;

	@NotNull
	@Min(1)
	private double prodPrice;

	@NotNull
	private long prodQuantity;

	@NotNull
	private String prodDescription;

	@NotNull
	private String prodCategory;

	@NotNull
	private String prodImageUrl;

	public ProductEntity() {
	}

	public ProductEntity(long prodId, String prodName, double prodPrice, long prodQuantity, String prodDescription,
			String prodCategory, String prodImageUrl) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodDescription = prodDescription;
		this.prodCategory = prodCategory;
		this.prodImageUrl = prodImageUrl;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public long getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(long prodQuantity) {
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
