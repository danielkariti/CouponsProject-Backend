package com.daniel.coupons.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.daniel.coupons.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(unique = false, nullable = false)
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = false, nullable = false)
	private Category category;
	
	@Column(unique = false, nullable = false)
	private String description;
	
	@Column(unique = false, nullable = false)
	private float price;
	
	@Column(unique = false, nullable = false)
	private int couponStock;
	
	@Column(unique = false, nullable = false)
	private String image;
	
	@Column(name = "expirationDate", unique = false, nullable = true)
	private Date expirationDate;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
	private Company company;
	
	@OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Purchase>purchases;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCouponStock() {
		return couponStock;
	}

	public void setCouponStock(int couponStock) {
		this.couponStock = couponStock;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", couponStock=" + couponStock + ", image=" + image + ", expirationDate="
				+ expirationDate + ", company=" + company + ", purchases=" + purchases + "]";
	}


}
