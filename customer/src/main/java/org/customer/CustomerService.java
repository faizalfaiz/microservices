package org.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myapp.clients.fraud.FraudCheckResponse;
import com.myapp.clients.fraud.FraudClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private final RestTemplate restTemplate;
	private final CustomerRepository customerRepository;
	private final FraudClient fraudClient;
	public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);
//FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//        		"http://FRAUD/api/v1/fraud-check/{customerId}",
//        		FraudCheckResponse.class, customer.getId()
//        		);
// 
FraudCheckResponse fraudCheckResponse=
fraudClient.isFraudster(customer.getId());
      if(fraudCheckResponse.isFraudster()) {
    	  throw new IllegalStateException("fraudster");
      }
 //todo: check if email valid, email not taken, store customer in db
//check if fraudster
//todo: send notification
	}
}