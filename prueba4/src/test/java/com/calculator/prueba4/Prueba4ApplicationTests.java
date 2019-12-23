package com.calculator.prueba4;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.calculator.prueba4.Model.OperationModel;

import io.corp.calculator.TracerImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServicesResponseTests extends TracerImpl{
	
	@LocalServerPort
    private int port;

    @Test
	void ResponseTests() throws URISyntaxException  {
		
		RestTemplate restTemplate = new RestTemplate();
		//construyo la url
        final String baseUrl = "http://localhost:"+port+"/calculator";
        
		URI uri = new URI(baseUrl);
		
		//set de las variables que quiero probar
        OperationModel<Object> model = new OperationModel<>();
        model.setA("9.00");
        model.setB("67.98");
        
        //set de los eders de la llamada
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");   
        
        HttpEntity<OperationModel<Object>> request = new HttpEntity<>(model, headers);
        
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        
        //assert para response positiva
        Assertions.assertEquals(201, result.getStatusCodeValue());
        
	}

}
