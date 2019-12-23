package com.calculator.prueba4.Model;

public class OperationModel<T> {
	
	private T operation;
    private T a;
    private T b;
    
    public OperationModel() {
    	
    }
    
    public OperationModel(T operation) {
        this.operation = operation;
    }
    
    public OperationModel(T a, T b) {
        this.a = a;
        this.b = b;
    }

	public T getOperation() {
		return operation;
	}

	public void setOperation(T operation) {
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
