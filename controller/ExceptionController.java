package by.epam.tr.lesson11.controller;

import by.epam.tr.lesson11.model.ExceptionModel;

public class ExceptionController extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionController(ExceptionModel e) { 
		super(e);
	}

}
