package com.example;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.example.controller.NamedCounterController;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		register(NamedCounterController.class);
	}

}