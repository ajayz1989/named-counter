package com.example.dto;

public class Counter {
	private String name;
	private Integer value;
	
	public Counter() {
		// For Jackson
	}

	public Counter(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
}
