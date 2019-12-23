package com.calculator.prueba4.Model;

public class OperationModel<Object> {
	
    private Object a;
    private Object b;
    private Object operation;
    
    public OperationModel() {
    	
    }
    
    public OperationModel(Object operation) {
        this.operation = operation;
    }
    public OperationModel(Object a, Object b) {
        this.a = a;
        this.b = b;
    }
	public Object getA() {
		return a;
	}

	public void setA(Object a) {
		this.a = a;
	}

	public Object getB() {
		return b;
	}

	public void setB(Object b) {
		this.b = b;
	}

	
}
