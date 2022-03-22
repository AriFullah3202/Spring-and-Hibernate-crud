package com.homework.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.NamedQueries;


@NamedQueries(value ={
	@NamedQuery(name = "findBy",query = "from Offer"),
	@NamedQuery(name = "findBy.app", query = "from Offer e where e.offerDetails =:offerDetails")

})
//@NamedQuery(name = "findBy", query = "from Offer s where s.id =:'value'")
//@org.hibernate.annotations.NamedQuery(name = "getAllList", query = "select * from Offer")
@Entity
@Table(name="offerr")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String companayName;
	String offerDetails;
	int price;
	

	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanayName() {
		return companayName;
	}

	public void setCompanayName(String companayName) {
		this.companayName = companayName;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Offer [id=" + id + ", companayName=" + companayName + ", offerDetails=" + offerDetails + ", price="
				+ price + ", getId()=" + getId() + ", getCompanayName()=" + getCompanayName() + ", getOfferDetails()="
				+ getOfferDetails() + ", getPrice()=" + getPrice() + "]";
	}





}
