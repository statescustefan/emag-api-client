package com.flow.emag.api.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table( name = "orders" )
@EmagResource(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@SerializedName("id")
	private Long id;
	
	/**
	 * The number that uniquely identifies an order Required. Integer value
	 * between 1 and 4294967295.
	 */
	@Column(name="emag_id")
	@SerializedName("id")
	@Expose
	private Long emagId;	
	
	/**
	 * 0 - cancelled 
	 * 1 - new 
	 * 2 - working 
	 * 3 - ready for shipping 
	 * 4 - completed 
	 * 5 - returned 
	 * Required. Integer value between 0 and 5
	 */
	@Column
	@SerializedName("status")
	@Expose
	private Integer status;
	
	/**
	 * The order payment method. The possible values are:
	 * 1 - COD
	 * 2 - cheque payment
	 * 6 - CARD online
	 * 9 - CardAvantaj online
	 * 10 - BonusCard online
	 * 11 - CardRaiffeisen online
	 * 12 - CardTransilvania online
	 *	Required. Integer.
	 */
	@Column(name="payment_mode_id")
	@SerializedName("payment_mode_id")
	@Expose
	private Integer paymentMode;
	
	/**
	 * Additional customer notes
	 * Optional. Text
	 */
	@Column
	@SerializedName("observation")
	@Expose
	private String observation;
	
	/**
	 * The car submission timestamp.
	 * Optional. Text in YYYY-mm-dd HH:ii:ss format.
	 */
	@Column
	@SerializedName("date")
	@Expose
	private String date;
	
	/**
	 * 0 - not payed
	 * 1 - payed 
	 * Required only for online payment methods.
	 */
	@Column(name="payment_status")
	@SerializedName("payment_status")
	@Expose
	private Integer paymentStatus;
	
	/**
	 * The shipment tax value.
	 * Optional. Decimal
	 */
	@Column(name="shipping_tax")
	@SerializedName("shipping_tax")
	@Expose
	private BigDecimal shippingTax;
	
	/**
	 * A list with additional order values that are not standard.
	 * Optional. List
	 */
	@OneToMany(mappedBy="order")
	@SerializedName("details")
	@Expose
	private List<OrderDetail> details;
	
	/**
	 * A list with the details about the customer, the shipping and the billing addresses.
	 * Optional. List.
	 */
	@OneToOne
	@SerializedName("customer")
	@Expose
	private Customer customer;
	
	/**
	 * A list describing the products in the order.
	 */
	@OneToMany(mappedBy="order")
	@SerializedName("products")
	@Expose
	private List<OrderItem> orderItems;
	
	/**
	 * A list describing the voucher discounts.
	 */
	@OneToMany(mappedBy="order")
	@SerializedName("vouchers")
	@Expose
	private List<Voucher> vouchers;
	
	/**
	 * A list describing the proformas. 
	 * Actually, the list may have only one proforma. 
	 * Vendors may only read proformas
	 */
	@OneToMany(mappedBy="order")
	@SerializedName("proforms")
	@Expose
	private List<Proforma> proforms;
	
	/**
	 * The vendor shipping details. Vendors may only save shipping details.
	 */
	@OneToOne
	@SerializedName("shipment")
	@Expose
	private Shipment shipment;
	
	/**
	 * A list describing vendor invoice details. Vendors may only save invoice details.
	 */
	@OneToOne
	@SerializedName("invoice")
	@Expose
	private Invoice invoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public BigDecimal getShippingTax() {
		return shippingTax;
	}

	public void setShippingTax(BigDecimal shippingTax) {
		this.shippingTax = shippingTax;
	}

	public Long getEmagId() {
		return emagId;
	}

	public void setEmagId(Long emagId) {
		this.emagId = emagId;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<Voucher> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}

	public List<Proforma> getProforms() {
		return proforms;
	}

	public void setProforms(List<Proforma> proforms) {
		this.proforms = proforms;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", paymentMode="
				+ paymentMode + ", observation=" + observation + ", date="
				+ date + ", paymentStatus=" + paymentStatus + ", shippingTax="
				+ shippingTax + ", details=" + details + ", customer="
				+ customer + ", orderItems=" + orderItems + ", vouchers="
				+ vouchers + ", proforms=" + proforms + ", shipment="
				+ shipment + ", invoice=" + invoice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result
				+ ((observation == null) ? 0 : observation.hashCode());
		result = prime * result
				+ ((orderItems == null) ? 0 : orderItems.hashCode());
		result = prime * result
				+ ((paymentMode == null) ? 0 : paymentMode.hashCode());
		result = prime * result
				+ ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime * result
				+ ((proforms == null) ? 0 : proforms.hashCode());
		result = prime * result
				+ ((shipment == null) ? 0 : shipment.hashCode());
		result = prime * result
				+ ((shippingTax == null) ? 0 : shippingTax.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((vouchers == null) ? 0 : vouchers.hashCode());
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
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (paymentMode == null) {
			if (other.paymentMode != null)
				return false;
		} else if (!paymentMode.equals(other.paymentMode))
			return false;
		if (paymentStatus == null) {
			if (other.paymentStatus != null)
				return false;
		} else if (!paymentStatus.equals(other.paymentStatus))
			return false;
		if (proforms == null) {
			if (other.proforms != null)
				return false;
		} else if (!proforms.equals(other.proforms))
			return false;
		if (shipment == null) {
			if (other.shipment != null)
				return false;
		} else if (!shipment.equals(other.shipment))
			return false;
		if (shippingTax == null) {
			if (other.shippingTax != null)
				return false;
		} else if (!shippingTax.equals(other.shippingTax))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (vouchers == null) {
			if (other.vouchers != null)
				return false;
		} else if (!vouchers.equals(other.vouchers))
			return false;
		return true;
	}
	
	
}
