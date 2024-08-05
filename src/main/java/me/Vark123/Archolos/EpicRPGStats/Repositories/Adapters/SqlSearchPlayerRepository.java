package me.Vark123.Archolos.EpicRPGStats.Repositories.Adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import me.Vark123.Archolos.EpicRPGStats.Model.Search.SearchPlayer;
import me.Vark123.Archolos.EpicRPGStats.Repositories.SearchPlayerRepository;


public interface SqlSearchPlayerRepository extends SearchPlayerRepository, JpaRepository<SearchPlayer, Integer> {
	
	
}
