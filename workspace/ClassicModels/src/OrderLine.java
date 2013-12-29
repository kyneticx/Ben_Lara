public class OrderLine {
	private int orderNum;
	private String productCode;
	private int qtyOrdered;
	private double price = 0.00;
	private int lineNum = 0;
	
	public OrderLine(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public void qtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int lineNum() {
		return lineNum;
	}
	
	
	
}
