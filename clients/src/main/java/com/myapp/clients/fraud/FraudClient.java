package com.myapp.clients.fraud;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient("fraud")
public interface FraudClient {
	
	@GetMapping(path="api/v1/fraud-check/{customerId}")
	FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID); 
	
}
