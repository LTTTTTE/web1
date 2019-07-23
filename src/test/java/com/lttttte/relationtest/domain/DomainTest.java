package com.lttttte.relationtest.domain;

import com.lttttte.relationtest.repository.CharacterRepository;
import com.lttttte.relationtest.repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class domainTest {

    @Autowired private PlayerRepository playerRepository;
    @Autowired private CharacterRepository characterRepository;


    @Test
    public void setPlayerRepositoryDataTest(){
        playerRepository.save(Player.builder()
                .loginId("id1")
                .loginPw("pw1")
                .build());

        assertThat(playerRepository.findAll().stream().filter(x->x.getLoginId().equals("id1")).limit(1).findFirst().orElse(null).getLoginId()).isEqualTo("id1");

    }

    @Test
    public void setCharacterRepositoryDataTest(){
        playerRepository.save(Player.builder()
                .loginId("id1")
                .loginPw("pw1")
                .build());
        characterRepository.save(Character.builder()
                .name("케릭터1")
                .player(playerRepository.findAll().stream().findAny().orElse(null))
                .build());
        characterRepository.save(Character.builder()
                .name("케릭터2")
                .player(playerRepository.findAll().stream().findAny().orElse(null))
                .build());

        assertThat(playerRepository.findAll().stream().filter(x->x.getLoginId().equals("id1")).limit(1).findAny().map(Player::getCharSet).orElse(null))
                .contains(characterRepository.findAll().stream().findAny().orElse(null));
    }
}
