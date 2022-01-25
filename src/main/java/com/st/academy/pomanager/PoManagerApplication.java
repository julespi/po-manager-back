package com.st.academy.pomanager;

import com.st.academy.pomanager.models.entities.OrderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PoManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoManagerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		return modelMapper;
	}
}


