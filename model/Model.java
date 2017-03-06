package by.epam.tr.lesson11.model;

import java.util.Date;

public interface Model {
    ModelData getModelData();

    void createProduct(String category, Date date, String annotation) throws ExceptionModel;

    void getProductByCode(long code) throws ExceptionModel;

    void getProductsByCategory(String category, boolean isSort) throws ExceptionModel;
    
    void getProductsByDate(Date date, boolean isSort) throws ExceptionModel;
    
    void getProductsByAnnotation(String annotation, boolean isSort) throws ExceptionModel;
    
    void getProductsByCategoryAndDate(String category, Date date, boolean isSort) throws ExceptionModel;
    
    void getProductsByMatchingString(String matcher, boolean isSort) throws ExceptionModel;
    
    void getAllProducts(boolean isSort) throws ExceptionModel;
}
