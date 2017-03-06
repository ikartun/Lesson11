package by.epam.tr.lesson11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.epam.tr.lesson11.controller.Controller;

import by.epam.tr.lesson11.model.MainModel;
import by.epam.tr.lesson11.model.Model;
import by.epam.tr.lesson11.view.ProductsView;
import by.epam.tr.lesson11.view.SearchProductsView;

public class Client {
    public static void main(String[] args) {
        Model model = new MainModel();
        ProductsView productsView = new ProductsView();
        Controller controller = new Controller();

        productsView.setController(controller);
        controller.setModel(model);
        controller.setProductsView(productsView);
        
        productsView.showAllProducts(false);
        productsView.createProduct("mycategory", new Date(), "myannotation");

        SearchProductsView searchProductsView = new SearchProductsView();
        searchProductsView.setController(controller);
        controller.setSearchProductsView(searchProductsView);
        
        searchProductsView.getProductByCode(1);
        searchProductsView.getProductsByCategory("food", false);
        searchProductsView.getProductsByAnnotation("jeans", false);
        // catch ParseException only as an exception during genereting test data, not related to basic functionality
        try {
			searchProductsView.getProductsByDate(new SimpleDateFormat("dd.MM.yyyy").parse("25.06.2013"), false);
			searchProductsView.getProductsByCategoryAndDate("auto", new SimpleDateFormat("dd.MM.yyyy").parse("29.10.2014"), false);
		} catch (ParseException e) {
			System.out.println("Not a valid date parameter");
		}
        searchProductsView.getProductsByMatchingString("the", true);
    }
}