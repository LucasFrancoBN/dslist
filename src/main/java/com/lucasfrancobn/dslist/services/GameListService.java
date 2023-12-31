package com.lucasfrancobn.dslist.services;

import com.lucasfrancobn.dslist.dto.GameDTO;
import com.lucasfrancobn.dslist.dto.GameListDTO;
import com.lucasfrancobn.dslist.dto.GameMinDTO;
import com.lucasfrancobn.dslist.entities.Game;
import com.lucasfrancobn.dslist.entities.GameList;
import com.lucasfrancobn.dslist.projection.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> games = gameListRepository.findAll();
        List<GameListDTO> dto = games.stream().map(gameList -> new GameListDTO(gameList)).toList();
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
