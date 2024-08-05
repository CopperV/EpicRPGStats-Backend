package me.Vark123.Archolos.EpicRPGStats.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import me.Vark123.Archolos.EpicRPGStats.Model.Detail.DetailPlayer;

public interface DetailPlayerRepository {

	public Optional<DetailPlayer> findById(int id);
	public Optional<DetailPlayer> findByUid(String uid);
	public Optional<DetailPlayer> findByNick(String nick);
	
	@Query(value = "SELECT COUNT(*) FROM players", nativeQuery = true)
	public int countPlayers();
	
}
