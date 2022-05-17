package org.customer;

import org.amqp.RabbitMQMessageProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myapp.clients.Notification.NotificationClient;
import com.myapp.clients.Notification.NotificationRequest;
import com.myapp.clients.fraud.FraudCheckResponse;
import com.myapp.clients.fraud.FraudClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

//	private final RestTemplate restTemplate;
	private final CustomerRepository customerRepository;
//	private final NotificationClient notificationClient;
	private final FraudClient fraudClient;
	private final RabbitMQMessageProducer rabbitMQMessageProducer;
	
	
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
   
     NotificationRequest notificationRequest = new NotificationRequest(
    		  customer.getId(),
    		  customer.getEmail(),
    		  String.format("Hi there, %s",customer.getFirstName())
    		  
    		 ) ;
     
     rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange","internal.notification.routing-key");
	}
}