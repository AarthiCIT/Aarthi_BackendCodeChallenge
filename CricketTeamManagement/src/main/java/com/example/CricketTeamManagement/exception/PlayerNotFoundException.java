package com.example.CricketTeamManagement.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Player not found with this id");
    }
}
