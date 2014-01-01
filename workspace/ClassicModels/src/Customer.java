
public class Customer {
	private int custNum;
	private String custName;
	private String contLast;
	private String contFirst;
	private String ph;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String pCode;
	private String country;
	private int empNum;
	double credLim;
	
	public Customer() {
		
	}
	public Customer (int custNum) {
		this.custNum = custNum;
	}
	
	public Customer(String custName) {
			this.custName = custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public void setContact(String contLast, String contFirst) {
		this.contLast = contLast;
		this.contFirst = contFirst;
	}
	
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}
	
	
	public void setAddress1(String address1, String city, String state, String pcode, String country, String phone) {
		this.address1 = address1;
		this.city = city;
		this.state = state;
		pCode = pcode;
		this.country = country;
		ph = phone;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public void setEmp(int empNum) {
		this.empNum = empNum;
	}
	
	public void setcredLim(double credLim) {
		this.credLim = credLim;
	}
	
	public int getCustNum() {
		return custNum;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public String getCustLast() {
		return contLast;
	}
	
	public String getCustFirst() {
		return contFirst;
	}
	
	public String getAdd1() {
		return address1;
	}
	
	public String getAdd2() {
		return address2;
	}
	
	public String getPh() {
		return ph;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getpCode() {
		return pCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public int getEmpNum() {
		return empNum;
	}
	
	public double getCredLim() {
		return credLim;
	}
	
	public boolean checkCredit() {
		if (credLim <= 0) {
			return false;
		}
		else
			return true;
	}
	
}
