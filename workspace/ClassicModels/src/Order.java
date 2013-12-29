import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Order {
	private int orderNum;
	private Calendar orderDate;
	private Calendar reqDate;
	private Calendar shipDate;
	private String status;
	private String comments;
	private int custNum;
	

	
	public Order() {
		status = "Open";
			
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	
	public void setReqDate(Calendar reqDate) {
		this.reqDate = reqDate;
	}
	
	public void shipDate(Calendar shipDate) {
		this.shipDate = shipDate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addComment(String comments) {
		this.comments = comments;
	}
	
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public Calendar getOrderDate() {
		return orderDate;
	}
	
	public Calendar getreqDate() {
		return reqDate;
	}
	
	public Calendar getShipDate() {
		return shipDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getComments() {
		return comments;
	}
	
	public int getCustNum() {
		return custNum;
	}
	
	public void shipOrder(Calendar shipDate) {
		status = "Shipped";
		this.shipDate = shipDate;
	}
	
	
	
}


