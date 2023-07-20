package me.Vark123.Archolos.EpicRPGStats.Repositories.Adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import me.Vark123.Archolos.EpicRPGStats.Model.Player;
import me.Vark123.Archolos.EpicRPGStats.Repositories.PlayerRepository;



public interface SqlPlayerRepository extends PlayerRepository, JpaRepository<Player, Integer> {
	
	
}
