package com.example.CricketTeamManagement.repo;

import com.example.CricketTeamManagement.entity.Player;
import com.example.CricketTeamManagement.exception.PlayerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
