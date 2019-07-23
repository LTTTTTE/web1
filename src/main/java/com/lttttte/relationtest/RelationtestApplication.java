package com.lttttte.relationtest;

import com.lttttte.relationtest.domain.Player;
import com.lttttte.relationtest.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RelationtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationtestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (PlayerRepository playerRepository){
        return args ->{
            playerRepository.save(Player.builder()
                    .loginId("testid1")
                    .loginPw("testpw1")
                    .build());
        };
    }
}
