package com.calculator.prueba4.Model;

public class OperationModel<T> {
	
	private String operation;
    private T a;
    private T b;
    
    public OperationModel() {
    	
    }
    
    public OperationModel(String operation) {
        this.operation = operation;
    }
    
    public OperationModel(T a, T b) {
        this.a = a;
        this.b = b;
    }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	
}
