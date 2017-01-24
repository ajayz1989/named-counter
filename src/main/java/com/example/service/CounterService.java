package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.dto.Counter;
import com.example.dto.ResponseDTO;

/**
 * Service for applying operation on counters
 * 
 * @author pritam.kumar
 *
 */
@Service
public class CounterService implements ICounterService {
	private static ConcurrentHashMap<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();

	@Override
	public ResponseDTO add(String counterName) {
		ResponseDTO response = new ResponseDTO();
		if (counterMap.containsKey(counterName)) {
			response.setErrors(Arrays.asList(counterName + " already exists"));
		} else {
			counterMap.putIfAbsent(counterName, new AtomicInteger(1));
			response.setCounters(Arrays.asList(new Counter(counterName, counterMap.get(counterName).get())));
		}
		return response;
	}

	@Override
	public ResponseDTO update(String name) {
		ResponseDTO response = new ResponseDTO();
		if (!counterMap.containsKey(name)) {
			response.setErrors(Arrays.asList("counter with name - " + name + " does not exists"));
		} else {
			counterMap.get(name).set(counterMap.get(name).incrementAndGet());
			response.setCounters(Arrays.asList(new Counter(name, counterMap.get(name).get())));
		}
		return response;
	}

	@Override
	public ResponseDTO getAll() {
		List<Counter> counters = new ArrayList<>();
		counterMap.forEach((key, val) -> {
			counters.add(new Counter(key, val.get()));
		});
		return new ResponseDTO(counters, null);
	}

	@Override
	public ResponseDTO get(String name) {
		ResponseDTO response = new ResponseDTO();
		if (counterMap.containsKey(name)) {
			response.setCounters(Arrays.asList(new Counter(name, counterMap.get(name).get())));
		} else {
			response.setErrors(Arrays.asList("counter with name - " + name + " does not exists"));
		}
		return response;
	}
}
