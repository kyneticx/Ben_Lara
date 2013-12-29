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
		shipDate.set(2013, 12, 30);
		neworder.shipDate(shipDate);
		Calendar reqDate = Calendar.getInstance();
		reqDate.set(2013, 12, 30);
		neworder.setReqDate(reqDate);
		neworder.setStatus("Open");
		neworder.addComment("Deliver by 30 Dec");
		
		//

		pst = conn.prepareStatement("UPDATE orders VALUES(?)");
		
		pst.setString(1, (new SimpleDateFormat("yyyy-MM-dd").format(neworder.getOrderDate())));
		//
			
		
		
		
		
	}
	
	
}
