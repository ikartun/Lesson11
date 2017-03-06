package by.epam.tr.lesson11.model;

import by.epam.tr.lesson11.bean.Product;

import java.util.ArrayList;
import java.util.List;


public class ModelData {
    private List<Product> products = new ArrayList<>();
    private List<Product> searchedProducts = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getSearchedProducts() {
		return searchedProducts;
	}

	public void setSearchedProducts(List<Product> searchedProducts) {
		this.searchedProducts = searchedProducts;
	}    
}
