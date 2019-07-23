package com.lttttte.relationtest.controller;

import com.lttttte.relationtest.domain.Player;
import com.lttttte.relationtest.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controller {

    private PlayerRepository playerRepository;

    public controller(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public String index(Player player){
        return "index";
    }

    @PostMapping("/player/signIn")
    public String playerSignIn(Player player){

        Player check = playerRepository.findAll().stream().filter(x -> x.getLoginId().equals(player.getLoginId()))
                .filter(x -> x.getLoginPw().equals(player.getLoginPw()))
                .limit(1).findFirst().orElse(null);

        if(check != null)
            return "main";

        return "index";
    }
}
