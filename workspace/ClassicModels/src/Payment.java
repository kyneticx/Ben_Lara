import java.sql.Date;
import java.util.Calendar;


public class Payment {
	private int custNum;
	private String checkNum;
	private java.sql.Date payDate;
	private double amount;
	
	public Payment(int custNum, double amount, Date payDate, String checkNum) {
		this.custNum = custNum;
		this.amount = amount;
		this.payDate = payDate;
		this.checkNum = checkNum;
	}
	
	public Payment(int custNum, String checkNum, java.sql.Date sqlDate, double amount) {
		this.custNum = custNum;
		this.amount = amount;
		payDate = sqlDate;
		this.checkNum = checkNum;
	}

	public int getPayCustNum() {
		return custNum;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Date getPayDate() {
		return payDate;
	}
	
	public String getCheckNum () {
		return checkNum;
	}
}
