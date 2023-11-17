package com.lucasfrancobn.dslist.dto;

import com.lucasfrancobn.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public GameListDTO() {
    }
}
