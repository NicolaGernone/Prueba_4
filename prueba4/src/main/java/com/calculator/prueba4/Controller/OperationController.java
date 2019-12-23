package com.calculator.prueba4.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.calculator.prueba4.Model.OperationModel;
import com.calculator.prueba4.Services.OperationServices;

import io.corp.calculator.TracerImpl;

@Controller
public class OperationController extends TracerImpl{
	
	//inicializo el model
	OperationModel<Object> modelBean = new OperationModel<Object>();
	
	@Autowired
	private OperationServices operationServices;
	
	/**
	 * map del html para la interface de la calculadora
	 * @param model
	 * @param modelBean
	 * @return
	 */
	@RequestMapping("/calculator")
    private String getCalculatorPage(Model model){
        model.addAttribute("operationModel",modelBean);
        return "calculator";
	}
	
	/**
	 * servicio para suma
	 * @param modelBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/calculator", params="add", method = RequestMethod.POST)
    private String add(@ModelAttribute("operationModel")  OperationModel<Object> modelBean, Model model ){
        model.addAttribute("result", operationServices.add(modelBean));
        return "calculator";
    }
	
	/**
	 * servicio para resta
	 * @param modelBean
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/calculator", params="subtract", method = RequestMethod.POST)
    private String subtract(@ModelAttribute("operationModel")  OperationModel<Object> modelBean, Model model ){
        model.addAttribute("result", operationServices.subtr(modelBean));
        return "calculator";
    }
	

}

