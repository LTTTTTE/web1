package com.lttttte.relationtest.repository;

import com.lttttte.relationtest.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
