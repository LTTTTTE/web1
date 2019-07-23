package com.lttttte.relationtest.controller;

import com.lttttte.relationtest.domain.Player;
import com.lttttte.relationtest.repository.PlayerRepository;
import com.lttttte.relationtest.service.CrawlingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class PlayerController {

    private PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public String index(Player player){
        return "index";
    }

    @PostMapping("/player/signIn")
    public String playerSignIn(Player player, CrawlingService crawlingService, Model model) throws IOException {

        Player check = playerRepository.findAll().stream()
                .filter(x -> x.getLoginId().equals(player.getLoginId()))
                .filter(x -> x.getLoginPw().equals(player.getLoginPw()))
                .limit(1).findFirst().orElse(null);

        if(check != null) {
            model.addAttribute("codeList",crawlingService.getHtmlSourceCodeByList("https://www.naver.com"));
            return "main";
        }

        return "index";
    }

    @GetMapping("/player/signUp")
    public String playerSignUp(Player player){
        return "signUp";
    }

    @PostMapping("/player/signUpPost")
    public String playerSignUpPost(Player player){
        Player newPlayer = Player.builder().loginId(player.getLoginId()).loginPw(player.getLoginPw()).build();
        playerRepository.save(newPlayer);
        return "index";
    }
}
