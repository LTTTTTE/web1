package com.lttttte.relationtest.repository;

import com.lttttte.relationtest.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character,Long> {
}
