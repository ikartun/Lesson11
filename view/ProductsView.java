package by.epam.tr.lesson11.view;

import java.util.Date;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.controller.Controller;
import by.epam.tr.lesson11.controller.ExceptionController;
import by.epam.tr.lesson11.model.ModelData;


public class ProductsView implements View {
    private Controller controller;

    public void showAllProducts(boolean isSort) {
        try {
			controller.onShowAllProducts(isSort);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }
    
    public void createProduct(String category, Date date, String annotation) {
    	try {
			controller.onCreateProduct(category, date, annotation);
		} catch (ExceptionController e) {
			System.out.println("Can not add new product. Try later.");
		}
    }
    
    @Override
    public void refresh(ModelData modelData) {
    	System.out.println("All products are: ");

        for (Product product : modelData.getProducts()) {
            System.out.println("\t" + product);
        }
        System.out.println("======================================================================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
