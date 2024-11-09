package pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaCustomFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaCustomFinderApplication.class, args);
		
		System.out.println("Working");
	}

}
