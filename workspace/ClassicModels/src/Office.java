
public class Office {
	String officeCode;
	String city;
	String phone;
	String addressLine1;
	String addressLine2;
	String state;
	String country;
	String pCode;
	String territory;
	
	public Office(String officeCode) {
		this.officeCode = officeCode;
	}
	
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	public void setCity (String city) {
		this.city = city;
	}
	
	public void setPhone (String phone ) {
		this.phone = phone;
	}
	
	public void setAddress(String addressLine1, String state, String country, String pCode, String city, String phone, String territory) {
		this.addressLine1 = addressLine1;
		this.state = state;
		this.country = country;
		this.pCode = pCode;
		this.territory = territory;
		this.city = city;
		this.phone = phone;
	}
	
	public void setAddress1 (String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public void setAddress2 (String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public void setState (String state) {
		this.state = state;
	}
	
	public void setCountry (String country) {
		this.country = country;
	}
	
	public void setPost (String postCode) {
		pCode = postCode;
	}
	
	public void setTerritory (String territory) {
		this.territory = territory;
	}
	
	public String getOfficeCode() {
		return officeCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress1() {
		return addressLine1;
	}
	
	public String getAddress2() {
		return addressLine2;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getPostCode() {
		return pCode;
	}
	
	public String getTerritory() {
		return territory;
	}
	
}
