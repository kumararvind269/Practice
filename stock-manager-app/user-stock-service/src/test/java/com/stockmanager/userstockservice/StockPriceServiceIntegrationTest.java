package com.stockmanager.userstockservice;

import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stockmanager.userstockservice.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserStockServiceApplication.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockPriceServiceIntegrationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();



	@Test
	public void testRetrieveStudentCourse() throws JSONException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/USER1"),
				HttpMethod.GET, entity, String.class);

		String expected = "{id:20001,name:USER1}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void addCourse() {
		HttpHeaders headers = new HttpHeaders();
		User user = new User(123,"XUSER");
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/user/"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().getLocation().toString();

		System.out.println(actual);
		assertTrue(actual.contains("/user/XUSER"));
	

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}


}
