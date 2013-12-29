
public class ProductLine {
	private String productLine;
	private String textDesc;
	private String htmlDesc;
	
	public ProductLine(String productLine, String textDesc) {
		this.productLine = productLine;
		this.textDesc = textDesc;
	}
	
	public void setTextDesc(String textDesc) {
		this.textDesc = textDesc;
	}
	
	public void setHtmlDesc (String htmlDesc) {
		this.htmlDesc = htmlDesc;
	}
	
	public String getProductLine () {
		return productLine;
	}
	
	public String getTextDesc() {
		return textDesc;
	}
	
	public String getHtmlDesc() {
		return htmlDesc;
	}
	
}