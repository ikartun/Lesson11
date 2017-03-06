package by.epam.tr.lesson11.dao;

public class ExceptionDao extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionDao(Exception e) {
		super(e);
	}
}
