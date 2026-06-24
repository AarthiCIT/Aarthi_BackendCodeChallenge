package com.example.CricketTeamManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestDTO {
    @NotBlank(message = "player name is required")
    private String playerName;
    @Min(value = 1, message = "jersey number must be greater than 0")
    private int jerseyNumber;
    @NotBlank(message = "role is required")
    private String role;
    private int totalMatches;
    private String teamName;
    private String countryStateName;
    private String description;

    public RequestDTO(){
    }

}
