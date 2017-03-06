package by.epam.tr.lesson11.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String category;
    private long code;
    private Date date;
    private String annotation;

    public Product(String category, long code, Date date, String annotation) {
		this.category = category;
		this.code = code;
		this.date = date;
		this.annotation = annotation;
	}

    public Product(String category,  Date date, String annotation) {
		this.category = category;
		this.date = date;
		this.annotation = annotation;
	}    

	public Product() {
		this("", new Date(), "");
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public long getCode() {
		return code;
	}	

	public void setCode(long code) {
		this.code = code;
	}

	//methods with logic
    public boolean isNew() {
        return code == 0;
    }

	@Override
	public String toString() {
		return "Product [category=" + category + ", code=" + code + ", date=" + new SimpleDateFormat("dd.MM.yyyy").format(date) + ", annotation=" + annotation
				+ "]";
	}
    
    
}