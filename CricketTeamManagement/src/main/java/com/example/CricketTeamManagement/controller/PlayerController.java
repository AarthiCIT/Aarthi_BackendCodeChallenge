package com.example.CricketTeamManagement.controller;

import com.example.CricketTeamManagement.dto.RequestDTO;
import com.example.CricketTeamManagement.dto.ResponseDTO;
import com.example.CricketTeamManagement.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    private List<ResponseDTO> players;

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAllPlayers() {
        List<ResponseDTO> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<ResponseDTO> getPlayerById(@PathVariable Long playerId) {
        ResponseDTO player = playerService.getPlayerById(playerId);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createPlayer(@Valid @RequestBody RequestDTO playerRequestDto) {
        ResponseDTO savedPlayer = playerService.createPlayer(playerRequestDto);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<ResponseDTO> updatePlayer(@PathVariable Long playerId, @Valid @RequestBody RequestDTO playerRequestDto) {
        ResponseDTO updatedPlayer = playerService.updatePlayer(playerId, playerRequestDto);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }


}
