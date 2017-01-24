package com.example.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseDTO {

	private List<Counter> counters;
	private List<String> errors;

	public ResponseDTO(){
		//For Jackson
	}
	public ResponseDTO(List<Counter> counters, List<String> errors) {
		this.counters = counters;
		this.errors = errors;
	}

	public List<Counter> getCounters() {
		return counters;
	}

	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
