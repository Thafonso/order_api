package com.thafonsotest.users_api.services.exceptions;

public class NotFoundException extends RuntimeException{

    private  static final long serialVersionUID = 1L;

    public NotFoundException(Object Id){
        super("Resource not found. Id: " + Id);
    }
}
