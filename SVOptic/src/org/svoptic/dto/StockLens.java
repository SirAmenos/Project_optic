package org.svoptic.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "STOCK_LENS")
public class StockLens implements Serializable {
	
	
	private int stockId ;
	private String index ;
	private String manufacturer;
	private String diameter ;
	private String webPrice ;
	private String regPrice ;
	private String description;
	private Set<UserDetail> userDetails = new HashSet<UserDetail>();
	

	public StockLens() {
	
		// TODO Auto-generated constructor stub
	}



	public StockLens( String index, String manufacturer,
			String diameter, String webPrice, String regPrice,
			String description, Set<UserDetail> userDetails) {
		super();
		this.index = index;
		this.manufacturer = manufacturer;
		this.diameter = diameter;
		this.webPrice = webPrice;
		this.regPrice = regPrice;
		this.description = description;
		this.userDetails = userDetails;
	}



	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	@Column(name = "INDEX")
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	@Column(name = "MANUFACTURER")
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Column(name = "DIAMETER")
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	@Column(name = "WEBPRICE")
	public String getWebPrice() {
		return webPrice;
	}
	public void setWebPrice(String webPrice) {
		this.webPrice = webPrice;
	}
	@Column(name = "REGPRICE")
	public String getRegPrice() {
		return regPrice;
	}
	public void setRegPrice(String regPrice) {
		this.regPrice = regPrice;
	}
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "stockLenses" )
	public Set<UserDetail> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Set<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}
	
	
	

}
