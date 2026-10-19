package com.customerorder;

import com.customerorder.config.RedisDetailsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(
        value = RedisDetailsConfig.class
)
public class CustomerOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderApplication.class, args);
	}

}
