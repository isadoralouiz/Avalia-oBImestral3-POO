package br.edu.ifpr.todo.api.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
    super(msg);
    }
    }