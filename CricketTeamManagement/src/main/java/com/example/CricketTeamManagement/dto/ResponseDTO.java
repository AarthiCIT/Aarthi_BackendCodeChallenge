package com.example.CricketTeamManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ResponseDTO {
    private Long playerId;
    private String playerName;
    private int jerseyNumber;
    private String role;
    private int totalMatches;
    private String teamName;
    private String countryStateName;
    private String description;

    public ResponseDTO() {
    }

    public ResponseDTO(Long playerId, String playerName, int jerseyNumber, String role, int totalMatches, String teamName, String countryStateName, String description) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryStateName = countryStateName;
        this.description = description;
    }

}
