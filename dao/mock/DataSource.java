package by.epam.tr.lesson11.dao.mock;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.dao.ExceptionDao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DataSource {
	private static DataSource ourInstance = new DataSource();
    // configurable
    private String fileName = "d:/Products.txt"; // data in file are separated by space in order to Product constructor parameters
    private List<Product> products = new ArrayList<>();
    private long currentMaxId;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    // configurable
    private Comparator<Product> comparator = new Comparator<Product>() {
    	@Override
		public int compare(Product o1, Product o2) {
			Date date1 = o1.getDate();
			Date date2 = o2.getDate();
			String annotation1 = o1.getAnnotation();
			String annotation2 = o2.getAnnotation();
			
			if (date1.after(date2)) {
				return 1;
			}
			else if (date1.before(date2)) {
				return -1;
			}
			else {
				if (annotation1.compareTo(annotation2) > 0) {
					return 1;
				}
				else if (annotation1.compareTo(annotation2) < 0) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	};
    
    public static DataSource getInstance() {
        return ourInstance;
    }
    
    private DataSource() {
    }

    public List<Product> getProducts(boolean isSort) throws ExceptionDao {
    	loadFromFile();
    	if (isSort) {
			sort(products);
		}
		return products;
	}
    
    public void sort(List<Product> products) {
    	java.util.Collections.sort(products, comparator);
    }
    
    public long getCurrentMaxId() {
		return currentMaxId;
	}

	public void loadFromFile() throws ExceptionDao {
    	try(FileReader fileReader = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	    	long maxId = 0;
	    	products = new ArrayList<>();
	    	
	    	while (bufferedReader.ready()) {
	    		String product = bufferedReader.readLine();
	    		String[] productFields = product.split(" ");
	    		if (Long.parseLong(productFields[1]) > maxId) {
					maxId = Long.parseLong(productFields[1]);
				}
	    		products.add(new Product(productFields[0], Long.parseLong(productFields[1]), simpleDateFormat.parse(productFields[2]), productFields[3]));
	    	}
	    	currentMaxId = maxId;
    	}
    	catch(IOException | ParseException e) {
    		throw new ExceptionDao(e);
    	}
    }
    
    public void saveToFile(Product newProduct) throws ExceptionDao {
    	try(FileWriter fileWriter = new FileWriter(fileName); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
	    	
	    	for (Product product : products) {
		    	bufferedWriter.write(product.getCategory() + " " + product.getCode() + " " + simpleDateFormat.format(product.getDate()) + " " + product.getAnnotation());
		    	bufferedWriter.newLine();
			}	    	
    	}
    	catch(IOException e) {
    		throw new ExceptionDao(e);
    	}
    }

	public Product createNewProduct(Product newProduct) throws ExceptionDao {
        newProduct.setCode(++currentMaxId);
        
        products.add(newProduct);
        saveToFile(newProduct);
        
        return newProduct;
    }
}