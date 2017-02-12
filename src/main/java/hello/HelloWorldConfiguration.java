package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HelloWorldConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldConfiguration.class, args);
	}

}
