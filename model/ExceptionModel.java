package by.epam.tr.lesson11.model;

import by.epam.tr.lesson11.dao.ExceptionDao;

public class ExceptionModel extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionModel(ExceptionDao e) {
		super(e);
	}

}
