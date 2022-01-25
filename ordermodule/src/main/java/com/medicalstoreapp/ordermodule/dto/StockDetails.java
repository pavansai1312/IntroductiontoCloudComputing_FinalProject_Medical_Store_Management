package com.medicalstoreapp.ordermodule.dto;

public class StockDetails {

	private long stockId;
	private String stockName;
	private int units;
	private double price;

	public StockDetails() {
		super();
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockDetails [stockId=" + stockId + ", stockName=" + stockName + ", units=" + units + ", price=" + price
				+ "]";
	}

}
