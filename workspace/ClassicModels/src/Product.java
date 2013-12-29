
public class Product {
private String productCode;
private String productName;
private String productLine;
private String productScale;
private String productVendor;
private String productDesc;
private int qtyStock;
private double buyPrice;
private double MSRP;

public Product(String productCode,String productName) {
	this.productCode = productCode;
	this.productName = productName;
	this.productLine = "";
	this.productScale = "";
	this.productVendor = "";
	this.productDesc = "";
	this.qtyStock = 0;
	this.buyPrice = 0.00;
	this.MSRP = 0.00;	
}

public void setProductLine(String productLine) {
	this.productLine = productLine;
}

public void setproductScale(String setproductScale) {
	this.productScale = setproductScale;
}

public void setproductVendor(String productVendor) {
	this.productVendor = productVendor;
}

public void setproductDesc(String productDesc) {
	this.productDesc = productDesc;
}

public void setStock(int qtyStock) {
	this.qtyStock = qtyStock;
}

public void setPrice (double buyPrice) {
	this.buyPrice = buyPrice;
}

public void setMSRP(double MSRP) {
	this.MSRP = MSRP;
}

public String getProductCode() {
	return productCode;
}

public String getProductName() {
	return productName;
}

public String getProductScale () {
	return productScale;
}

public String getProductLine() {
	return productLine;
}

public String getProductVendor() {
	return productVendor;
}

public String getProductDesc() {
	return productDesc;
}

public int getQtyStock() {
	return qtyStock;
}

public double getPrice() {
	return buyPrice;
}

public double getMSRP() {
	return MSRP;
}
}