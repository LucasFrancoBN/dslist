package com.lucasfrancobn.dslist.repositories;

import com.lucasfrancobn.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
