
public class Employee {
	private int empNum;
	private String last;
	private String first;
	private String ext;
	private String email;
	private String officeCode;
	private int reports;
	private String jobtitle;
	
	public Employee(String last, String first) {
		this.last = last;
		this.first = first;
	}
	
	public void setName(String last, String first) {
		this.last = last;
		this.first = first;
	}
	
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	public void setReports(int reports) {
		this.reports = reports;
	}
	public void setTitle(String title) {
		jobtitle = title;
	}
	
	public int getEmpNum() {
		return empNum;
	}
	
	public String getlast() {
		return last;
	}
	
	public String getfirst() {
		return first;
	}
	
	public String getext() {
		return ext;
	}
	
	public String email() {
		return email;
	}
	
	public String getOffice() {
		return officeCode;
	}
	
	public int getReports() {
		return reports;
	}
	
	public String getTitle() {
		return jobtitle;
	}
	
	
	
	
	
	
}
