package com.lucasfrancobn.dslist.services;

import com.lucasfrancobn.dslist.dto.GameDTO;
import com.lucasfrancobn.dslist.dto.GameMinDTO;
import com.lucasfrancobn.dslist.entities.Game;
import com.lucasfrancobn.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }
}
