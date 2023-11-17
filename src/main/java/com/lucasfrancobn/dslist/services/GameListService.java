package com.lucasfrancobn.dslist.services;

import com.lucasfrancobn.dslist.dto.GameDTO;
import com.lucasfrancobn.dslist.dto.GameListDTO;
import com.lucasfrancobn.dslist.dto.GameMinDTO;
import com.lucasfrancobn.dslist.entities.Game;
import com.lucasfrancobn.dslist.entities.GameList;
import com.lucasfrancobn.dslist.repositories.GameListRepository;
import com.lucasfrancobn.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> games = gameListRepository.findAll();
        List<GameListDTO> dto = games.stream().map(gameList -> new GameListDTO(gameList)).toList();
        return dto;
    }
}
