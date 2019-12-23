package com.calculator.prueba4;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.calculator.prueba4.Model.OperationModel;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServicesResponseTests {

	@LocalServerPort
	private int port;
	OperationModel<Object> model = new OperationModel<Object>();

	@Test
	void ResponseTestsOk() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		// construyo la url
		final String baseUrl = "http://localhost:" + port + "/calculator";

		URI uri = new URI(baseUrl);

		// set de las variables que quiero probar
		
		model.setA("9.00");
		model.setB("67.98");

		// set de los eders de la llamada
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<OperationModel<Object>> request = new HttpEntity<>(model, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

		// assert para response positiva
		Assertions.assertEquals(200, result.getStatusCodeValue());

	}

	/*@Test
	void ResponseTestsMissHeaders() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + port + "/calculator";
		URI uri = new URI(baseUrl);
		model.setA("9.00");
		model.setB("67.98");

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<OperationModel<Object>> request = new HttpEntity<>(model, headers);

		try {
			restTemplate.postForEntity(uri, request, String.class);
			Assertions.fail();
		} catch (HttpClientErrorException ex) {
			// Verify bad request and missing header
			Assertions.assertEquals(400, ex.getRawStatusCode());
			Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}

	}

	@Test
	void ResponseTestsMissValues() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		// construyo la url
		final String baseUrl = "http://localhost:" + port + "/calculator";

		URI uri = new URI(baseUrl);

		// set de las variables que quiero probar
		model.setA("9.00");
		model.setB("9.00");

		// set de los eders de la llamada
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "USA");

		HttpEntity<OperationModel<Object>> requestEntity = new HttpEntity<>(null, headers);

		try {
			restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
            Assertions.fail();
		} catch (HttpClientErrorException ex) {
			// faltan los valores de input y nos tiene que devolver un 500
			Assertions.assertEquals(500, ex.getRawStatusCode());
			Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}

	}*/

}
