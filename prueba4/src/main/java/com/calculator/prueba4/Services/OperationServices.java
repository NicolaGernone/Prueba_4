package com.calculator.prueba4.Services;

import org.springframework.stereotype.Service;

import com.calculator.prueba4.Model.OperationModel;

import java.math.*;

import io.corp.calculator.TracerImpl;

@Service
public class OperationServices extends TracerImpl {
	
	//declaro las variables de suma y resta
	private BigDecimal sum;
	private BigDecimal rest;
	
	/**
	 * servicio que devuelve la suma de dos valores
	 * @param model
	 * @return 
	 * @return
	 */
	public <T> BigDecimal add(OperationModel<BigDecimal> model){
        try {
        	trace("La primera variable introducida es: " + model.getA());
        	trace("La segunda variable introducida es: " + model.getB());
        	sum = model.getA().add(model.getB());
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
	 * @param model
	 * @return
	 */
	public <T> BigDecimal subtr(OperationModel<BigDecimal> model){
        try {
        	trace("La primera variable introducida es: " + model.getA());
        	trace("La segunda variable introducida es: " + model.getB());
        	rest = model.getA().subtract(model.getB());
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

