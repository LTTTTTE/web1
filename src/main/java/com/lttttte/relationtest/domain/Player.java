package com.lttttte.relationtest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity @Table
public class Player {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String loginId;

    @Column
    private String loginPw;

    @OneToMany(mappedBy = "player")
    private Set<Character> charSet = new HashSet<>();

    @Column
    private Long credit;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime lastLoginDate;

    @Builder
    public Player(String loginId, String loginPw) {
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.credit = 0L;
        this.createdDate = LocalDateTime.now();
        this.lastLoginDate = LocalDateTime.now();
    }
}
