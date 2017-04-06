package com.springboot.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column
	private Double totalPrices;
	@OneToMany( mappedBy = "order",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ItemDetails> itemDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(Double totalPrices) {
		this.totalPrices = totalPrices;
	}
	public Set<ItemDetails> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(Set<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}
	

}
