import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateOrder {

	public static void main(String args[]) throws SQLException, ParseException {
		
		try {
			Order thisorder = new Order(20001);
			thisorder.shipOrder(Calendar.getInstance());
			DatabaseHelper.shipOrder(thisorder);
		}
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}
			
		
		
	}
	
	
}
