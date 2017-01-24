package com.example.service;

import com.example.dto.ResponseDTO;

public interface ICounterService {
	/**
	 * API for adding a new named counter
	 * 
	 * @param name
	 * @return
	 */
	ResponseDTO add(String name);

	/**
	 * API for incrementing the existing counter
	 * 
	 * @param name
	 * @return
	 */
	ResponseDTO update(String name);

	/**
	 * API for getting the counter detail
	 * 
	 * @param name
	 * @return
	 */
	ResponseDTO get(String name);

	/**
	 * API for getting all the counters
	 * 
	 * @return
	 */
	ResponseDTO getAll();

}
