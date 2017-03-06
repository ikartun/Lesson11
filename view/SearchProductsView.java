package by.epam.tr.lesson11.view;

import java.util.Date;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.controller.Controller;
import by.epam.tr.lesson11.controller.ExceptionController;
import by.epam.tr.lesson11.model.ModelData;

public class SearchProductsView  implements View {
	private Controller controller;

	@Override
	public void refresh(ModelData modelData) {
		System.out.println("All searched products are: ");

        for (Product product : modelData.getSearchedProducts()) {
            System.out.println("\t" + product);
        }
        System.out.println("======================================================================================================");
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;		
	}

    public void getProductByCode(long code) {
    	try {
			controller.onGetProductByCode(code);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }

    public void getProductsByCategory(String category, boolean isSort) {
    	try {
			controller.onGetProductsByCategory(category, isSort);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }
    
    public void getProductsByDate(Date date, boolean isSort) {
    	try {
			controller.onGetProductsByDate(date, isSort);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }
    
    public void getProductsByAnnotation(String annotation, boolean isSort) {
    	try {
			controller.onGetProductsByAnnotation(annotation, isSort);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }
    
    public void getProductsByCategoryAndDate(String category, Date date, boolean isSort) {
    	try {
			controller.onGetProductsByCategoryAndDate(category, date, isSort);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }
    
    public void getProductsByMatchingString(String matcher, boolean isSort) {
    	try {
			controller.onGetProductsByMatchingString(matcher, isSort);
		} catch (ExceptionController e) {
			System.out.println("Nothing to display. Try later.");
		}
    }
}
