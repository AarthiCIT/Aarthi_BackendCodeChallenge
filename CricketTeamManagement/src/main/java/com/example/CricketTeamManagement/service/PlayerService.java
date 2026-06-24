package com.example.CricketTeamManagement.service;

import com.example.CricketTeamManagement.dto.PlayerMapper;
import com.example.CricketTeamManagement.dto.RequestDTO;
import com.example.CricketTeamManagement.dto.ResponseDTO;
import com.example.CricketTeamManagement.entity.Player;
import com.example.CricketTeamManagement.exception.PlayerNotFoundException;
import com.example.CricketTeamManagement.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<ResponseDTO> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ResponseDTO getPlayerById(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(()->new PlayerNotFoundException(playerId));
        return PlayerMapper.toResponseDto(player);
    }

    public ResponseDTO createPlayer(RequestDTO playerRequestDto) {
        Player player = PlayerMapper.toEntity(playerRequestDto);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMapper.toResponseDto(savedPlayer);
    }

    public ResponseDTO updatePlayer(Long playerId, RequestDTO playerRequestDto) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));

        existingPlayer.setPlayerName(playerRequestDto.getPlayerName());
        existingPlayer.setJerseyNumber(playerRequestDto.getJerseyNumber());
        existingPlayer.setRole(playerRequestDto.getRole());
        existingPlayer.setTotalMatches(playerRequestDto.getTotalMatches());
        existingPlayer.setTeamName(playerRequestDto.getTeamName());
        existingPlayer.setCountryStateName(playerRequestDto.getCountryStateName());
        existingPlayer.setDescription(playerRequestDto.getDescription());
        Player updatedPlayer = playerRepository.save(existingPlayer);
        return PlayerMapper.toResponseDto(updatedPlayer);
    }

    public void deletePlayer(Long playerId) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));
        playerRepository.delete(existingPlayer);
    }
}
