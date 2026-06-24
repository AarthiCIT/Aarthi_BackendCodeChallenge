package com.example.CricketTeamManagement.entity;
import com.example.CricketTeamManagement.entity.Role;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    @NotBlank(message = "playerName is required")
    private String playerName;
    @Min(value = 1, message = "jerseyNumber should be greater than 0")
    private int jerseyNumber;
    @NotBlank(message = "role is required")
    @Enumerated(EnumType.STRING)
    private Role role;
    private int totalMatches;
    private String teamName;
    private String countryStateName;
    @Column(length = 1000)
    private String description;
    public Player() {
    }

    public Player(Long playerId, String playerName, int jerseyNumber, Role role, int totalMatches, String teamName, String countryStateName, String description) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryStateName = countryStateName;
        this.description = description;
    }

    public Long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public int getTotalMatches() {
        return totalMatches;
    }
    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryStateName() {
        return countryStateName;
    }
    public void setCountryStateName(String countryStateName) {
        this.countryStateName = countryStateName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
