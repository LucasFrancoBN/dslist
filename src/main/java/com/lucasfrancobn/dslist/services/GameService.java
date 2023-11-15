package com.lucasfrancobn.dslist.services;

import com.lucasfrancobn.dslist.dto.GameMinDTO;
import com.lucasfrancobn.dslist.entities.Game;
import com.lucasfrancobn.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }
}
