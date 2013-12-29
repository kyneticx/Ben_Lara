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
			
			System.out.print("Enter an order number if one exists, or press 0 to create a new one: ");
			Scanner console = new Scanner(System.in);
			int orderNum = console.nextInt();
			if (console.hasNextLine())
				console.nextLine();
			if (DatabaseHelper.checkOrderExist(orderNum))
			{
				// Add order lines to the existing order
				
				Order newOrder = new Order();
				newOrder.setOrderNum(orderNum);
				
				boolean addLine = true;
				do {
					System.out.print("Would you like to add a product line? Type Yes or No");
					String userInput = console.nextLine();
					if (userInput.equalsIgnoreCase("Yes")) {
						OrderLine firstline = new OrderLine(newOrder.getOrderNum());
						int lineNum = DatabaseHelper.getNextLineNum(orderNum);
						if (lineNum > 0)
						{
							firstline.setLineNum(++lineNum);
						}
						else 
						{
							firstline.setLineNum(1);
							
						}
						System.out.print("Enter the product code: ");
						firstline.setProductCode(console.nextLine());
						System.out.print("Enter the price: ");
						firstline.setPrice(console.nextDouble());
						if (console.hasNextLine())
							console.nextLine();
						System.out.print("Enter the quantity ordered: ");
						firstline.qtyOrdered(console.nextInt());
						if (console.hasNextLine())
							console.nextLine();
						DatabaseHelper.newOrderLine(firstline);
						
					}
					
					else if (userInput.equalsIgnoreCase("No")) {
						addLine = false;
					}
				}
				while (addLine);
			}

			else {
				
				// Create a new instance of Order and set values
			
				Order newOrder = new Order();
				newOrder.setOrderNum(DatabaseHelper.getNewOrderNum());
				newOrder.setOrderDate(Calendar.getInstance());
				Calendar reqDate = Calendar.getInstance();
				System.out.print("Enter the order required date: ");
				String stringreqDate = new String(console.nextLine());
				SimpleDateFormat sdf = new SimpleDateFormat("YYYYmmdd");
				reqDate.setTime(sdf.parse(stringreqDate));
				newOrder.setReqDate(reqDate);
				System.out.print("Enter the customer number: ");
				newOrder.setCustNum(console.nextInt());
				if (console.hasNextLine())
					console.nextLine();
					
				DatabaseHelper.newOrder(newOrder);
			
				// Add order lines to the order
				
				int lineNum = 0;
				boolean addLine = true;
				do {
					System.out.print("Would you like to add a product line? Type Yes or No");
					String userInput = console.nextLine();
					if (userInput.equalsIgnoreCase("Yes")) {
						OrderLine firstline = new OrderLine(newOrder.getOrderNum());
						firstline.setLineNum(++lineNum);
						System.out.print("Enter the product code: ");
						firstline.setProductCode(console.nextLine());
						System.out.print("Enter the price: ");
						firstline.setPrice(console.nextDouble());
						if (console.hasNextLine())
							console.nextLine();
						System.out.print("Enter the quantity ordered: ");
						firstline.qtyOrdered(console.nextInt());
						if (console.hasNextLine())
							console.nextLine();
						DatabaseHelper.newOrderLine(firstline);
					}
					
					
					else if (userInput.equalsIgnoreCase("No")) {
						addLine = false;
					}
				}
				while (addLine);
				
			}
			
			
			
		}
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}
			
		
		
	
	
	
}
}
