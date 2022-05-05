package com.grupollano;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SuperinventApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SuperinventApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		String password = "12345";
		
		BCryptPasswordEncoder bcryebcoder = new BCryptPasswordEncoder();
		
		for(int i=0; i<2; i++) {
			String bcryptPassword = bcryebcoder.encode(password);

			System.out.println("hola oscar aca vamos ");
			System.out.println(bcryptPassword);
		}
		
	}

}
