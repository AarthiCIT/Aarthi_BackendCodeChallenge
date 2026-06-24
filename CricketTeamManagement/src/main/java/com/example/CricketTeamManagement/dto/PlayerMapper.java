package com.example.CricketTeamManagement.dto;

import com.example.CricketTeamManagement.entity.Player;

public class PlayerMapper {

    public static Player toEntity(RequestDTO dto) {
        Player player = new Player();
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryStateName(dto.getCountryStateName());
        player.setDescription(dto.getDescription());
        return player;
    }

    public static ResponseDTO toResponseDto(Player player) {
        return new ResponseDTO(
                player.getPlayerId(),
                player.getPlayerName(),
                player.getJerseyNumber(),
                player.getRole(),
                player.getTotalMatches(),
                player.getTeamName(),
                player.getCountryStateName(),
                player.getDescription()
        );
    }
}
