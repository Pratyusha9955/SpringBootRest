package com.springbootapp.service;

public interface RestService {
	<T> T callService(String url, Class<T> response);
}
