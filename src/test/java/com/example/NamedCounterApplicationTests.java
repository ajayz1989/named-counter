package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.ResponseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NamedCounterApplicationTests {

	private static final String COUNTER1_ENDPOINT = "/counters/counter1";
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		ResponseEntity<ResponseDTO> entity = this.restTemplate.getForEntity("/counters", ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void getCounter() {
		ResponseEntity<ResponseDTO> entity = this.restTemplate.getForEntity(COUNTER1_ENDPOINT, ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void addCounter() {
		ResponseEntity<ResponseDTO> entity = this.restTemplate.postForEntity(COUNTER1_ENDPOINT, null,
				ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void updateCounter() {
		this.restTemplate.put(COUNTER1_ENDPOINT, null);
		ResponseEntity<ResponseDTO> entity = this.restTemplate.getForEntity(COUNTER1_ENDPOINT, ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getCounters().isEmpty()).isEqualTo(false);

	}

}
