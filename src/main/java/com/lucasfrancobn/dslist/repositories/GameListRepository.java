package com.lucasfrancobn.dslist.repositories;

import com.lucasfrancobn.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
