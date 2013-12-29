package ams.driver;
import ams.model.facade.*;
import ams.view.AMSView;
public class AMSDriver {

	private static AMSModel model = new AMSFacade(); 
	
	public static void main(String[] args) {
		AMSView frame = new AMSView(model);
		frame.setSize(1200,800);
		frame.setVisible(true);
	}

}
