import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateOrder {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws SQLException, ParseException {
		
		

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
		Order neworder = new Order(orderNumber);
		neworder.setCustNum(363);
		neworder.setOrderDate(Calendar.getInstance());		
		Calendar shipDate = Calendar.getInstance();
		Calendar reqDate = Calendar.getInstance();
		reqDate.set(2013, 12, 30);
		neworder.setReqDate(reqDate);
		neworder.setStatus("Open");
		
		//

		pst = conn.prepareStatement("CALL createOrder(?, ?, ?, ?, ?)");
		
//		pst.setString(1, (new SimpleDateFormat("yyyy-MM-dd").format(neworder.getOrderDate())));
		pst.setInt(1, neworder.getOrderNum());
		pst.setDate(2, (new java.sql.Date(neworder.getOrderDate().getTimeInMillis())));
		pst.setDate(3, (new java.sql.Date(neworder.getreqDate().getTimeInMillis())));
		pst.setString(4, neworder.getStatus());
		pst.setInt(5, neworder.getCustNum());
		pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		//
			
		
		
		
		
	}
	
	
}
