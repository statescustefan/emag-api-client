package com.flow.emag.api.model;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class InvoiceItem {
	
	@SerializedName("id")
	private Integer id;
	
	/**
	 * Emag product id
	 */
	@SerializedName("product_id")
	private Integer productId;
	
	@SerializedName("quantity")
	private Integer quantity;
	
	/**
	 * Ex : 119.9935
	 */
	@SerializedName("sale_price")
	private BigDecimal salePrice;
	
	@SerializedName("vat_rate")
	private BigDecimal vatRate;
	
	/**
	 * ProductName
	 */
	@SerializedName("name")
	private String productName;
	
	@SerializedName("part_number")
	private String partNumber;
	
	/**
	 * Ex: 62.1200
	 */
	@SerializedName("cost")
	private BigDecimal cost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((salePrice == null) ? 0 : salePrice.hashCode());
		result = prime * result + ((vatRate == null) ? 0 : vatRate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceItem other = (InvoiceItem) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (salePrice == null) {
			if (other.salePrice != null)
				return false;
		} else if (!salePrice.equals(other.salePrice))
			return false;
		if (vatRate == null) {
			if (other.vatRate != null)
				return false;
		} else if (!vatRate.equals(other.vatRate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceItem [id=" + id + ", productId=" + productId
				+ ", quantity=" + quantity + ", salePrice=" + salePrice
				+ ", vatRate=" + vatRate + ", productName=" + productName
				+ ", partNumber=" + partNumber + ", cost=" + cost + "]";
	}
}
