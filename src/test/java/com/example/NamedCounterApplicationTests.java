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
	private static final String COUNTER2_ENDPOINT = "/counters/counter2";
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldGetAllCounters() {
		ResponseEntity<ResponseDTO> entity = this.restTemplate.getForEntity("/counters", ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldGetCounter() {
		ResponseEntity<ResponseDTO> entity = this.restTemplate.getForEntity(COUNTER1_ENDPOINT, ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldAddCounter() {
		ResponseEntity<ResponseDTO> entity = this.restTemplate.postForEntity(COUNTER1_ENDPOINT, null,
				ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldUpdateCounter() {
		this.restTemplate.postForEntity(COUNTER2_ENDPOINT, null,
				ResponseDTO.class);
		ResponseEntity<ResponseDTO> entity = this.restTemplate.getForEntity(COUNTER2_ENDPOINT, ResponseDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getCounters().isEmpty()).isEqualTo(false);
	}

}
