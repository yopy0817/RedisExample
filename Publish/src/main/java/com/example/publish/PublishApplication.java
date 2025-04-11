package com.example.publish;

import com.example.publish.component.RedisPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublishApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublishApplication.class, args);
	}

}
