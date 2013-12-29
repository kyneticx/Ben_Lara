//
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Scanner;

public class Progs {
////	public static void createnewProduct() throws SQLException {
//	ArrayList<String> products = new ArrayList<String>(DatabaseHelper.checkProduct());
//	Scanner console = new Scanner(System.in);
//	System.out.println("Enter a product code: ");
//	String productCode = console.nextLine();
//	boolean duplicate = false;
//	for (int i = 0; i < products.size(); i++) {
//		 duplicate = products.get(i).equalsIgnoreCase(productCode);
//		 if (duplicate) {
//			 break;
//		 }
//	}
//		 
//
//	while (duplicate) {
//		
//		System.out.println("Product code exists!");
//		System.out.println("Please enter a product code: ");
//		productCode = console.nextLine();
//		for (int j = 0; j < products.size(); j++) {
//			 duplicate = products.get(j).equalsIgnoreCase(productCode);
//			 if (duplicate) {
//				 break;
//			 }
//			 else {
//				 
//			 }
//		}
//	}
//	System.out.println("Enter a product name: ");
//	String productName = console.nextLine();
//	Product firstProduct = new Product(productCode, productName);
//	System.out.println("Enter a product line: ");
//	String productLine = console.nextLine();
//	boolean productLineExist;
//	productLineExist = DatabaseHelper.checkProductLine(productLine);
//	while (!productLineExist) {
//		System.out.println("Product line does not exist!");
//		System.out.println("Please enter a product line: ");
//		productLine = console.nextLine();
//		productLineExist = DatabaseHelper.checkProductLine(productLine);
//	}
//	firstProduct.setProductLine(productLine);
//	System.out.println("Enter the product scale: ");
//	firstProduct.setproductScale(console.nextLine());
//	System.out.println("Enter the product vendor: ");
//	firstProduct.setproductVendor(console.nextLine());
//	System.out.println("Enter the product description: ");
//	firstProduct.setproductDesc(console.nextLine());
//	System.out.println("Enter the qty in stock: ");
//	firstProduct.setStock(console.nextInt());
//	if(console.hasNextLine())
//	{
//		console.nextLine();
//	}
//	System.out.println("Enter the product buy price: ");
//	firstProduct.setPrice(console.nextDouble());
//	if(console.hasNextLine())
//	{
//		console.nextLine();
//	}
//	System.out.println("Enter the product MSRP: ");
//	firstProduct.setMSRP(console.nextDouble());
//	if(console.hasNextLine())
//	{
//		console.nextLine();
//	}
//
//	createProduct(firstProduct);
//	console.close();
//	
//
//}
//public static void createnewProduct() {
//	Scanner console = new Scanner(System.in);
//	System.out.println("Enter a product code: ");
//	String productCode = console.nextLine();
//	boolean productCodefound;
//	productCodefound = DatabaseHelper.checkProductCode(productCode);
//	while (productCodefound) {
//		
//		System.out.println("Product code exists!");
//		System.out.println("Please enter a product code: ");
//		productCode = console.nextLine();
//		productCodefound = DatabaseHelper.checkProductCode(productCode);
//	}
//	System.out.println("Enter a product name: ");
//	String productName = console.nextLine();
//	Product firstProduct = new Product(productCode, productName);
//	System.out.println("Enter a product line: ");
//	String productLine = console.nextLine();
//	boolean productLineExist;
//	productLineExist = DatabaseHelper.checkProductLine(productLine);
//	while (!productLineExist) {
//		System.out.println("Product line does not exist!");
//		System.out.println("Please enter a product line: ");
//		productLine = console.nextLine();
//		productLineExist = DatabaseHelper.checkProductLine(productLine);
//	}
//	firstProduct.setProductLine(productLine);
//	System.out.println("Enter the product scale: ");
//	firstProduct.setproductScale(console.nextLine());
//	System.out.println("Enter the product vendor: ");
//	firstProduct.setproductVendor(console.nextLine());
//	System.out.println("Enter the product description: ");
//	firstProduct.setproductDesc(console.nextLine());
//	System.out.println("Enter the qty in stock: ");
//	firstProduct.setStock(console.nextInt());
//	if(console.hasNextLine())
//	{
//		console.nextLine();
//	}
//	System.out.println("Enter the product buy price: ");
//	firstProduct.setPrice(console.nextDouble());
//	if(console.hasNextLine())
//	{
//		console.nextLine();
//	}
//	System.out.println("Enter the product MSRP: ");
//	firstProduct.setMSRP(console.nextDouble());
//	if(console.hasNextLine())
//	{
//		console.nextLine();
//	}
//	
//	DatabaseHelper.createProduct(firstProduct);
//	console.close();
//
// }
//
//public static void createNewProductLine() {
//	Scanner console = new Scanner(System.in);
//	System.out.println("Enter a product line name: ");
//	String productLine = console.nextLine();
//	boolean productLineFound;
//	productLineFound = DatabaseHelper.checkProductLine(productLine);
//	while (productLineFound) {
//		
//		System.out.println("Product line exists!");
//		System.out.println("Please enter a product line: ");
//		productLine = console.nextLine();
//		productLineFound = DatabaseHelper.checkProductLine(productLine);
//	}
//	
//	System.out.println("Enter a product line description: ");
//	String productDesc = new String(console.nextLine());
//	ProductLine newProductLine = new ProductLine(productLine, productDesc);
//	DatabaseHelper.createProductLine(newProductLine);
//	console.close();
//
//}
//
//public static void createNewOffice() {
//	Scanner console = new Scanner(System.in);
//	
//	System.out.println("Enter an office code: ");
//	Office office = new Office(console.nextLine());
//	System.out.println("Enter the office city: ");
//	office.setCity(console.nextLine());
//	System.out.println("Ehter the office phone: ");
//	office.setPhone(console.nextLine());
//	System.out.println("Enter address line 1: ");
//	office.setAddress1(console.nextLine());
//	System.out.println("Enter address line 2: ");
//	office.setAddress2(console.nextLine());
//	System.out.println("Enter the state: ");
//	office.setState(console.nextLine());
//	System.out.println("Enter the country: ");
//	office.setCountry(console.nextLine());
//	System.out.println("Enter the postal code: ");
//	office.setPost(console.nextLine());
//	System.out.println("Ehter the territory: ");
//	office.setTerritory(console.nextLine());
//	
//	DatabaseHelper.newOffice(office);
//	console.close();
//
//}
//
//
//
//	

}