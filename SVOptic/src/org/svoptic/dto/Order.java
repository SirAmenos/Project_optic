package org.svoptic.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ORDER_TABLE")
public class Order {
	
	private int orderId;
	private String state;
	private UserDetail costumer ;
	private StockLens product ;
	private Date orderDate;
	private Date deliveryDate;
	private String Number ;
	
	public Order() {

	}

	public Order(String state, UserDetail costumer, StockLens product,
			Date orderDate, Date deliveryDate, String number) {
		super();
		this.state = state;
		this.costumer = costumer;
		this.product = product;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		Number = number;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID" , nullable=false , unique = true)
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@OneToOne
	@JoinColumn(name="COSTUMER_ID")
	public UserDetail getCostumer() {
		return costumer;
	}

	public void setCostumer(UserDetail costumer) {
		this.costumer = costumer;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_ID")
	public StockLens getProduct() {
		return product;
	}

	public void setProduct(StockLens product) {
		this.product = product;
	}
	@Column(name="ORDER_DATE")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name="DELIVERY_DATE")
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Column(name="NUMBER")
	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}


	
	

}
