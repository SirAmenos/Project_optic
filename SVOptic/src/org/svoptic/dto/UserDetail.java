package org.svoptic.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "USER_DETAIL")
public class UserDetail implements Serializable {
	

	private int id ;
	private String firstName ;
	private String lastName  ;
	private String company   ;
	private String firstAddr  ;
	private String secondAddr;
	private String city      ;
	private String postalCode   ;
	private String country   ;
	private String province  ;
	private String phone     ;
	private String FAX       ;
	private String Email     ;
	private String rank      ;
	private String userName  ;
	private String passWord  ;
	private Set <StockLens> stockLenses = new HashSet<StockLens>();
	


	
	public UserDetail() {

		// TODO Auto-generated constructor stub
	}



	public UserDetail( String firstName, String lastName,
			String company, String firstAddr, String secondAddr, String city,
			String postalCode, String country, String province, String phone,
			String fAX, String email, String rank, String userName,
			String passWord, Set<StockLens> stockLenses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.firstAddr = firstAddr;
		this.secondAddr = secondAddr;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.province = province;
		this.phone = phone;
		FAX = fAX;
		Email = email;
		this.rank = rank;
		this.userName = userName;
		this.passWord = passWord;
		this.stockLenses = stockLenses;
	}



	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "FIRST_ADDRESS")
	public String getFirstAddr() {
		return firstAddr;
	}


	public void setFirstAddr(String firstAddr) {
		this.firstAddr = firstAddr;
	}

	@Column(name = "SECOND_ADDRESS")
	public String getSecondAddr() {
		return secondAddr;
	}


	public void setSecondAddr(String secondAddr) {
		this.secondAddr = secondAddr;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "POSTAL_CODE")
	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "PROVINCE")
	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "FAX")
	public String getFAX() {
		return FAX;
	}


	public void setFAX(String FAX) {
		this.FAX = FAX;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return Email;
	}


	public void setEmail(String Email) {
		this.Email = Email;
	}

	@Column(name = "RANK" )
	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}

	@Column(name = "USER_NAME" )
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_STOCK", 
	joinColumns = {
			@JoinColumn(name = "USER_ID")  },
	inverseJoinColumns = {
			@JoinColumn(name= "STOCK_ID") }
	)
	public Set<StockLens> getStockLenses() {
		return stockLenses;
	}

	public void setStockLenses(Set<StockLens> stockLenses) {
		this.stockLenses = stockLenses;
	}

	

}
