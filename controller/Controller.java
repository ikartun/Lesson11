package by.epam.tr.lesson11.controller;

import java.util.Date;

import by.epam.tr.lesson11.model.ExceptionModel;
import by.epam.tr.lesson11.model.Model;
import by.epam.tr.lesson11.view.ProductsView;
import by.epam.tr.lesson11.view.SearchProductsView;


public class Controller {
    private Model model;
    private ProductsView productsView;
    private SearchProductsView searchProductsView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setProductsView(ProductsView productsView) {
		this.productsView = productsView;
	}

	public void setSearchProductsView(SearchProductsView searchProductsView) {
		this.searchProductsView = searchProductsView;
	}

	public void onShowAllProducts(boolean isSort) throws ExceptionController {
        try {
			model.getAllProducts(isSort);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
        productsView.refresh(model.getModelData());
	}
        

    public void onCreateProduct(String category,Date date, String annotation) throws ExceptionController {
        try {
			model.createProduct(category, date, annotation);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
        productsView.refresh(model.getModelData());
    }

	public void onGetProductByCode(long code) throws ExceptionController {
		try {
			model.getProductByCode(code);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
		searchProductsView.refresh(model.getModelData());
	}

	public void onGetProductsByCategory(String category, boolean isSort) throws ExceptionController {
		try {
			model.getProductsByCategory(category, isSort);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
		searchProductsView.refresh(model.getModelData());
	}

	public void onGetProductsByDate(Date date, boolean isSort) throws ExceptionController {
		try {
			model.getProductsByDate(date, isSort);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
		searchProductsView.refresh(model.getModelData());
	}

	public void onGetProductsByAnnotation(String annotation, boolean isSort) throws ExceptionController {
		try {
			model.getProductsByAnnotation(annotation, isSort);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
		searchProductsView.refresh(model.getModelData());
	}

	public void onGetProductsByCategoryAndDate(String category, Date date, boolean isSort) throws ExceptionController {
		try {
			model.getProductsByCategoryAndDate(category, date, isSort);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
		searchProductsView.refresh(model.getModelData());
	}

	public void onGetProductsByMatchingString(String matcher, boolean isSort) throws ExceptionController {
		try {
			model.getProductsByMatchingString(matcher, isSort);
		} catch (ExceptionModel e) {
			throw new ExceptionController(e);
		}
		searchProductsView.refresh(model.getModelData());
	}
}
