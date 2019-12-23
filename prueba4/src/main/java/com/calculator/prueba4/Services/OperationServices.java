package com.calculator.prueba4.Services;

import org.springframework.stereotype.Service;

import com.calculator.prueba4.Model.OperationModel;

import java.math.*;

import io.corp.calculator.TracerImpl;

@Service
public class OperationServices extends TracerImpl {
	
	//declaro las variables de suma y resta
	private BigDecimal sum = new BigDecimal(0);
	private BigDecimal rest  = new BigDecimal(0);
	
	
	/**
	 * servicio que devuelve la suma de dos valores
	 * @param model
	 * @return 
	 * @return
	 */
	public BigDecimal add(OperationModel<Object> model){
        try {
        	trace("La primera variable introducida es: " + model.getA());
        	trace("La segunda variable introducida es: " + model.getB());
        	sum = new BigDecimal(model.getA().toString());
        	sum = sum.add(new BigDecimal(model.getB().toString()));
        	trace("La suma de los valores es: " + sum);
			return sum;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			trace(e);
			trace("Se han itroducido valores incorrectos");
			return sum;
		}
    }
	
	/**
	 * servicio que devuelve la resta de dos valores
	 * @param modelBean
	 * @return
	 */
	public BigDecimal subtr(OperationModel<Object> modelBean){
        try {
        	trace("La primera variable introducida es: " + modelBean.getA());
        	trace("La segunda variable introducida es: " + modelBean.getB());
        	rest = new BigDecimal(modelBean.getA().toString());
        	rest = rest.subtract(new BigDecimal(modelBean.getB().toString()));
        	trace("La resta de los valores es: " + rest);
			return rest;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			trace(e);
			trace("Se han itroducido valores incorrectos");
			return rest;
		}
    }

}

