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
@Table(name = "goods")
public class Goods implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column
	private String goodsName;
	@Column
	private Double goodsPrice;
	@Column
	private Integer goodsNum;
	@OneToMany( mappedBy = "goods",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ItemDetails> itemDetails;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Set<ItemDetails> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(Set<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}

}
