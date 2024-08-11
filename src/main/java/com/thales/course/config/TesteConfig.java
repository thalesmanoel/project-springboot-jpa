package com.thales.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thales.course.entities.User;
import com.thales.course.repositories.UserRepository;

//Declarando pelo Spring que é uma classe de configuração
@Configuration
@Profile("test")					//Executa essa classe quando o programa for iniciado
public class TesteConfig implements CommandLineRunner {

	//Injeção de dependência
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
