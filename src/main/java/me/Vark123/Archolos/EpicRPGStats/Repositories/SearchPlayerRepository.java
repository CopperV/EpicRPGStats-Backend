package me.Vark123.Archolos.EpicRPGStats.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import me.Vark123.Archolos.EpicRPGStats.Model.Search.SearchPlayer;

public interface SearchPlayerRepository {

	@Query(value = "SELECT * FROM players WHERE players.nick LIKE ?1% ORDER BY players.nick ASC LIMIT 10",
			nativeQuery = true)
	public List<SearchPlayer> searchPlayersByName(String name);
	
}
