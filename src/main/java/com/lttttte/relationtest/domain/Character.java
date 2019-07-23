package com.lttttte.relationtest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity @Table
public class Character {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    private Player player;

    @Column
    private String name;

    @Column
    private Long level;

    @Column
    private Long hp;

    @Column
    private Long dmg;

    @Column
    private Long money;

    @Builder
    public Character(Player player, String name) {
        setPlayer(player);
        this.name = name;
        this.level = 1L;
        this.hp = 100L;
        this.dmg = 1L;
        this.money = 0L;
    }

    public void setPlayer(Player player){

        if(this.player != null)
            this.player.getCharSet().remove(this);

        this.player = player;

        if(player != null)
            player.getCharSet().add(this);
    }

}
