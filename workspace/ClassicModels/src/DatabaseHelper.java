
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;


public class DatabaseHelper {

	public static void newCustomer(Customer newCust) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
			
		conn = DBUtil.getConnection(DBType.MYSQL);
		pst = conn.prepareStatement("CALL newCustomer(?, ?, ?, ?, ?, ?, ?, ?)");
		pst.setInt(1, newCust.getCustNum());
		pst.setString(2, newCust.getCustName());
		pst.setString(3, newCust.getCustFirst());
		pst.setString(4, newCust.getCustLast());
		pst.setString(5, newCust.getPh());
		pst.setString(6, newCust.getAdd1());
		pst.setString(7, newCust.getCity());
		pst.setString(8, newCust.getCountry());
		pst.executeUpdate();
		
		if(newCust.getAdd2() != null) {
			pst = conn.prepareStatement("CALL updateCustomer(?, ?, ?)");
			pst.setString(1, newCust.getAdd2());
			pst.setString(2, "addressLine2");
			pst.setInt(3, newCust.getCustNum());
			pst.executeUpdate();
		}
		
		if(newCust.getState().length() > 0) {
			pst = conn.prepareStatement("CALL updateCustomer(?, ?, ?)");
			pst.setString(1, newCust.getState());
			pst.setString(2, "state");
			pst.setInt(3, newCust.getCustNum());
			pst.executeUpdate();
		}
		
		if(newCust.getpCode().length() > 0) {
			pst = conn.prepareStatement("CALL updateCustomer(?, ?, ?)");
			pst.setString(1, newCust.getpCode());
			pst.setString(2, "postalCode");
			pst.setInt(3, newCust.getCustNum());
			pst.executeUpdate();
		}
		
		if(newCust.getCredLim() != 0) {
			pst = conn.prepareStatement("CALL updateCredLimit(?, ?)");
			pst.setDouble(1, newCust.getCredLim());
			pst.setInt(2, newCust.getCustNum());
			pst.executeUpdate();
			
		}
		
		if(newCust.getEmpNum() != 0) {
			pst = conn.prepareStatement("CALL updateCustomerRep(?, ?)");
			pst.setDouble(1, newCust.getEmpNum());
			pst.setInt(2, newCust.getCustNum());
			pst.executeUpdate();
		}
	}
		
	
	
	public static void newEmployee(Employee newEmp) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
			
		conn = DBUtil.getConnection(DBType.MYSQL);
		pst = conn.prepareStatement("CALL createEmp(?, ?, ?, ?, ?, ?, ?, ?)");
		pst.setInt(1, newEmp.getEmpNum());
		pst.setString(2, newEmp.getlast());
		pst.setString(3, newEmp.getfirst());
		pst.setString(4, newEmp.getext());
		pst.setString(5, newEmp.email());
		pst.setString(6, newEmp.getOffice());
		pst.setInt(7, newEmp.getReports());
		pst.setString(8, newEmp.getTitle());
		
		pst.executeUpdate();
		
		
	}


	public static void newOffice (Office office) throws SQLException {
	
	
			Connection conn = null;
			PreparedStatement pst = null;
				
			conn = DBUtil.getConnection(DBType.MYSQL);
			pst = conn.prepareStatement("CALL newOffice (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, office.getOfficeCode());
			pst.setString(2, office.getCity());
			pst.setString(3, office.getPhone());
			pst.setString(4, office.getAddress1());
			pst.setString(5, office.getAddress2());
			pst.setString(6, office.getState());
			pst.setString(7, office.getCountry());
			pst.setString(8, office.getPostCode());
			pst.setString(9, office.getTerritory());
	
			int result = pst.executeUpdate();
			if(result == 1) {
				System.out.println("Success");
			}
			else {
				System.out.println("Fail");
			}
			conn.close();
			pst.close();
	}


	public static void newProduct(Product newproduct) throws SQLException {
			Connection conn = null;
			PreparedStatement pst = null;
				
		
				conn = DBUtil.getConnection(DBType.MYSQL);
				pst = conn.prepareStatement("CALL insertNewProduct (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pst.setString(1, newproduct.getProductCode());
				pst.setString(2, newproduct.getProductName());
				pst.setString(3, newproduct.getProductLine());
				pst.setString(4, newproduct.getProductScale());
				pst.setString(5, newproduct.getProductVendor());
				pst.setString(6, newproduct.getProductDesc());
				pst.setInt(7, newproduct.getQtyStock());
				pst.setDouble(8, newproduct.getPrice());
				pst.setDouble(9, newproduct.getMSRP());
				int result = pst.executeUpdate();
				if(result == 1) {
					System.out.println("Success");
				}
				else {
					System.out.println("Fail");
				}
				conn.close();
				pst.close();
				
	}


	public static void newProductLine(ProductLine newproductLine) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = DBUtil.getConnection(DBType.MYSQL);
		
		pst = conn.prepareStatement("CALL newProductLine (?, ?)");
		
		pst.setString(1, newproductLine.getProductLine());
		pst.setString(2, newproductLine.getTextDesc());

		conn.close();
		pst.close();
			
	}
	
	public static void newPayment(Payment payment) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = DBUtil.getConnection(DBType.MYSQL);
		
		pst = conn.prepareStatement("CALL newpayment(?, ?, ?, ?)");
		
		pst.setInt(1, payment.getPayCustNum());
		pst.setString(2, payment.getCheckNum());
		pst.setDate(3, payment.getPayDate());
		pst.setDouble(4, payment.getAmount());

		conn.close();
		pst.close();
	}
	
	public static int getNewOrderNum() throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection(DBType.MYSQL);
		pst = conn.prepareStatement("SELECT max(orderNumber) FROM orders");
		ResultSet rs = pst.executeQuery();
		int orderNumber = 0;
		while(rs.next()) {
				orderNumber = rs.getInt(1);
						
		}
		orderNumber+=10;
		return orderNumber;
	}
	
	public static void newOrder(Order neworder) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection(DBType.MYSQL);
		
		pst = conn.prepareStatement("CALL createOrder(?, ?, ?, ?, ?)");
		pst.setInt(1, neworder.getOrderNum());
		pst.setDate(2, (new java.sql.Date(neworder.getOrderDate().getTimeInMillis())));
		pst.setDate(3, (new java.sql.Date(neworder.getreqDate().getTimeInMillis())));
		pst.setString(4, neworder.getStatus());
		pst.setInt(5, neworder.getCustNum());
		pst.executeUpdate();
		
		pst.close();
		conn.close();
	}
	
	public static double getAvailableCredit(Customer thisCust) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = DBUtil.getConnection(DBType.MYSQL);
		
		pst = conn.prepareStatement("CALL getAvailableCredit(?)");
		pst.setInt(1, thisCust.getCustNum());
		ResultSet rs = pst.executeQuery();
		double availableCredit = 0;
		int custNum = 0;
		
		while (rs.next()) {
			availableCredit = rs.getDouble(1);
		}
		
		
		
		return availableCredit;
		
	
		
		
		
	}
	
	
	public static boolean checkProductCode (String productCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean success = false;
	
			conn = DBUtil.getConnection(DBType.MYSQL);
			pst = conn.prepareStatement("CALL checkProductCode(?)");
			pst.setString(1, productCode);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String pccheck = result.getString(1);
				
				if (pccheck.equalsIgnoreCase(productCode)) {				
					
					success = true;
				}
			}
			pst.close();
			conn.close();
			
		return success;
	}


	public static boolean checkProductLine(String productlinecheck) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean success = false;
	
		conn = DBUtil.getConnection(DBType.MYSQL);
		pst = conn.prepareStatement("CALL checkProductLines(?)");
		pst.setString(1, productlinecheck);
		ResultSet result = pst.executeQuery();
			
		while (result.next()) {
			String plcheck = result.getString(1);
			
			if (plcheck.equalsIgnoreCase(productlinecheck)) {				
					success = true;
			}
				
			}
			pst.close();
			conn.close();
			return success;
	
	
	}


	public static ArrayList<String> checkProduct() throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
	
		conn = DBUtil.getConnection(DBType.MYSQL);
		pst = conn.prepareStatement("CALL findProducts()");
		ResultSet result = pst.executeQuery();
		ArrayList<String> products = new ArrayList<String>();
		
		
		
			while (result.next()){
				products.add(result.getString("productCode"));
				
			}
				
	
		pst.close();
		conn.close();
		return products;
	}




	public static void showProduct(String productCode) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pst = null;
			
		
			conn = DBUtil.getConnection(DBType.MYSQL);
			pst = conn.prepareStatement("CALL DisplayProduct (?)");
			pst.setString(1, productCode);
			ResultSet rs = pst.executeQuery();
			
			if (!rs.next())
			{
				System.out.println("Product Code Not Found");
			}
			while (rs.next()) {
				System.out.println("Product Code: " + rs.getString(1));
				System.out.println("Product Name: " + rs.getString(2));
				System.out.println("Product Line: " + rs.getString(3));
				System.out.println("Product Scale: " + rs.getString(4));
				System.out.println("Product Vendor: " + rs.getString(5));
				System.out.println("Product Description: " + rs.getString(6));
				System.out.println("Quantity in Stock: " + rs.getInt(7));
				System.out.println("Buy Price: " + rs.getDouble(8));
				System.out.println("MSRP: " + rs.getDouble(9));
			}
			
			conn.close();
			pst.close();
		
	}
}

