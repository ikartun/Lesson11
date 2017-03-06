package by.epam.tr.lesson11.model.service;

import by.epam.tr.lesson11.bean.Product;
import by.epam.tr.lesson11.model.ExceptionModel;

import java.util.Date;
import java.util.List;

public interface ProductService {
    Product createProduct(String category, Date date, String annotation) throws ExceptionModel;

    Product getProductByCode(long code) throws ExceptionModel;

    List<Product> getProductsByCategory(String category, boolean isSort) throws ExceptionModel;
    
    List<Product> getProductsByDate(Date date, boolean isSort) throws ExceptionModel;
    
    List<Product> getProductsByAnnotation(String annotation, boolean isSort) throws ExceptionModel;
    
    List<Product> getProductsByCategoryAndDate(String category, Date date, boolean isSort) throws ExceptionModel;
    
    List<Product> getProductsByMatchingString(String matcher, boolean isSort) throws ExceptionModel;
    
    List<Product> getAllProducts(boolean isSort) throws ExceptionModel;
}