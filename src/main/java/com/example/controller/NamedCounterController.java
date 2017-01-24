package com.example.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.service.CounterService;
import com.example.service.ICounterService;

@Component
@Path("/counters")
@Produces(MediaType.APPLICATION_JSON)
public class NamedCounterController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ICounterService counterService;
	public NamedCounterController() {
		//Default
	}
	
	@Autowired
	public NamedCounterController(CounterService service) {
		counterService = service;
	}
	
	@GET
	public Response getCounters() {
		logger.info("getting all the counters");
		return Response.ok().entity(counterService.getAll()).build();
	}
	
	@GET
	@Path("/{name}")
	public Response getCounter(@PathParam("name") String name) {
		logger.info("Getting counter- {}", name);
		return Response.ok().entity(counterService.get(name)).build();
	}
	
	@POST
	@Path("/{name}")
	public Response addCounters(@PathParam("name") String name) {
		logger.info("Adding counter- {}", name);
		return Response.ok().entity(counterService.add(name)).build();
	}
	
	@PUT
	@Path("/{name}")
	public Response updateCounters(@PathParam("name") String name) {
		logger.info("Updating counter- {}", name);
		return Response.ok().entity(counterService.update(name)).build();
	}

}
