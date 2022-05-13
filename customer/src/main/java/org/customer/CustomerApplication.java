package org.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages="com.myapp.clients")
public class CustomerApplication{
    public static void main( String[] args )
    {
       SpringApplication.run(CustomerApplication.class, args);
    }
}
