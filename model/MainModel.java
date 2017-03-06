package by.epam.tr.lesson11.model;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.model.service.ProductService;
import by.epam.tr.lesson11.model.service.ProductServiceImpl;

import java.util.Date;
import java.util.List;


public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private ProductService productService = new ProductServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

	@Override
	public void getAllProducts(boolean isSort) throws ExceptionModel {
		List<Product> products = productService.getAllProducts(isSort);
        modelData.setProducts(products);
	}

	@Override
	public void createProduct(String category, Date date, String annotation) throws ExceptionModel {
		productService.createProduct(category, date, annotation);
		modelData.setProducts(productService.getAllProducts(false));		
	}

	@Override
	public void getProductByCode(long code) throws ExceptionModel {
		modelData.getSearchedProducts().clear();
		modelData.getSearchedProducts().add(productService.getProductByCode(code));
	}

	@Override
	public void getProductsByCategory(String category, boolean isSort) throws ExceptionModel {
		modelData.setSearchedProducts(productService.getProductsByCategory(category, isSort));
	}

	@Override
	public void getProductsByDate(Date date, boolean isSort) throws ExceptionModel {
		modelData.setSearchedProducts(productService.getProductsByDate(date, isSort));
	}

	@Override
	public void getProductsByAnnotation(String annotation, boolean isSort) throws ExceptionModel {
		modelData.setSearchedProducts(productService.getProductsByAnnotation(annotation, isSort));
	}

	@Override
	public void getProductsByCategoryAndDate(String category, Date date, boolean isSort) throws ExceptionModel {
		modelData.setSearchedProducts(productService.getProductsByCategoryAndDate(category, date, isSort));
	}

	@Override
	public void getProductsByMatchingString(String matcher, boolean isSort) throws ExceptionModel {
		modelData.setSearchedProducts(productService.getProductsByMatchingString(matcher, isSort));
	}
}
