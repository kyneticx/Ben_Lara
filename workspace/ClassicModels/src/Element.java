
public class Element {
	private String dickSize;
	private String sexStatus;
	private double bankAccountBalance;
	
	public Element(String dicksize, String sexStatus, double bankAccountBalance) {
		this.dickSize = dicksize;
		this.sexStatus = sexStatus;
		this.bankAccountBalance = bankAccountBalance;
	}
	
	public static void main(String args[]) {
		Element element = new Element("Small", "Virgin", -60000);
	}

}


