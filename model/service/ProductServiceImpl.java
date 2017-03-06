package by.epam.tr.lesson11.model.service;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.dao.ExceptionDao;
import by.epam.tr.lesson11.dao.ProductDao;
import by.epam.tr.lesson11.model.ExceptionModel;

import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDao();

	@Override
	public Product createProduct(String category, Date date, String annotation) throws ExceptionModel {
		Product product = new Product(category, date, annotation);
		try {
			return productDao.create(product);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public Product getProductByCode(long code) throws ExceptionModel {		
		try {
			return productDao.getProductByCode(code);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public List<Product> getProductsByCategory(String category, boolean isSort) throws ExceptionModel {
		try {
			return productDao.getProductsByCategory(category, isSort);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public List<Product> getProductsByDate(Date date, boolean isSort) throws ExceptionModel {
		try {
			return productDao.getProductsByDate(date, isSort);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public List<Product> getProductsByAnnotation(String annotation, boolean isSort) throws ExceptionModel {
		try {
			return productDao.getProductsByAnnotation(annotation, isSort);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public List<Product> getProductsByCategoryAndDate(String category, Date date, boolean isSort) throws ExceptionModel {
		try {
			return productDao.getProductsByCategoryAndDate(category, date, isSort);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public List<Product> getProductsByMatchingString(String matcher, boolean isSort) throws ExceptionModel {
		try {
			return productDao.getProductsByMatchingString(matcher, isSort);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}

	@Override
	public List<Product> getAllProducts(boolean isSort) throws ExceptionModel {
		try {
			return productDao.getAllProducts(isSort);
		} catch (ExceptionDao e) {
			throw new ExceptionModel(e);
		}
	}
}