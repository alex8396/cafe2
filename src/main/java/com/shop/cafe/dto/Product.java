package com.shop.cafe.dto;

public class Product {
	private String prodname,pimg;
	private int prodcode, price;
	
	@Override
	public String toString() {
		return "Product [prodname=" + prodname + ", pimg=" + pimg + ", prodcode=" + prodcode + ", price=" + price + "]";
	}
	public Product(String prodname, String pimg, int prodcode, int price) {
		super();
		this.prodname = prodname;
		this.pimg = pimg;
		this.prodcode = prodcode;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public int getProdcode() {
		return prodcode;
	}
	public void setProdcode(int prodcode) {
		this.prodcode = prodcode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
