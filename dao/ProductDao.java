package by.epam.tr.lesson11.dao;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.dao.mock.DataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDao {
	private DataSource dataSource = DataSource.getInstance();

	public Product getProductByCode(long code) throws ExceptionDao {
        List<Product> products = getAllProducts(false);
        
        for (Product product : products) {
            if (product.getCode() == code) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductsByCategory(String category, boolean isSort) throws ExceptionDao {
        List<Product> products = getAllProducts(false);
        
        if (category == null || category.trim().isEmpty()) {
        	return products;
        };
        List<Product> result = new ArrayList<>();
        
        for (Product product : products) {
            if (category.equals(product.getCategory())) {
                result.add(product);
            }
        }
        if (isSort) {
			dataSource.sort(result);
		}
        return result;
    }

    public List<Product> getProductsByDate(Date date, boolean isSort) throws ExceptionDao {
    	List<Product> products = getAllProducts(false);
        
        if (date == null) {
        	return products;
        };
        
        List<Product> result = new ArrayList<>();
        
        for (Product product : products) {
            if (date.equals(product.getDate())) {
                result.add(product);
            }
        }
        if (isSort) {
			dataSource.sort(result);
		}
        return result;
    }

    public List<Product> getProductsByAnnotation(String annotation, boolean isSort) throws ExceptionDao {
    	List<Product> products = getAllProducts(false);
        
        if (annotation == null || annotation.trim().isEmpty()) {
        	return products;
        };  
        
        List<Product> result = new ArrayList<>();
        
        for (Product product : products) {
            if (annotation.equals(product.getAnnotation())) {
                result.add(product);
            }
        }
        if (isSort) {
			dataSource.sort(result);
		}
        return result;
    }

    public List<Product> getProductsByCategoryAndDate(String category, Date date, boolean isSort) throws ExceptionDao {
        List<Product> products = getAllProducts(false);
        boolean isCategoryNull = false;
        boolean isDateNull = false;
    	
    	if (category == null || category.trim().isEmpty()) {
        	isCategoryNull = true;
        }
    	if (date == null) {
    		isDateNull = true;
        }
    	if (isCategoryNull && isDateNull) {
			return products;
		}
    	else if (!isCategoryNull && isDateNull) {
			return getProductsByCategory(category, isSort);
		}
    	else if (isCategoryNull && !isDateNull) {
			return getProductsByDate(date, isSort);
		}
    	else {    	
	        List<Product> result = new ArrayList<>();
	        
	        for (Product product : products) {
	            if (category.equals(product.getCategory()) && date.equals(product.getDate())) {
	                result.add(product);
	            }
	        }
	        if (isSort) {
				dataSource.sort(result);
			}
	        return result;
    	}
    }

    public List<Product> getProductsByMatchingString(String s, boolean isSort) throws ExceptionDao {
    	List<Product> products = getAllProducts(false);
        
        if (s == null || s.trim().isEmpty()) {
        	return products;
        };  
        
        List<Product> result = new ArrayList<>();
        String matcher = ".*" + s + ".*";
        
        for (Product product : products) {
            if (product.getCategory().matches(matcher) || product.getAnnotation().matches(matcher)) {
                result.add(product);
            }
        }
        if (isSort) {
			dataSource.sort(result);
		}
        return result;
    }

    public List<Product> getAllProducts(boolean isSort) throws ExceptionDao {
    	return dataSource.getProducts(isSort);
    }
    
    public Product create(Product product) throws ExceptionDao {
        return dataSource.createNewProduct(product);
    }
}