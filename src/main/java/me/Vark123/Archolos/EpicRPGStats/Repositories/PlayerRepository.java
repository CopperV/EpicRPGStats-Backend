package me.Vark123.Archolos.EpicRPGStats.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.Vark123.Archolos.EpicRPGStats.Model.Player;

public interface PlayerRepository {

	public List<Player> findAll();
	public Page<Player> findAll(Pageable page);
	
	public Optional<Player> findById(int id);
	public Optional<Player> findByUid(String uid);
	public Optional<Player> findByNick(String nick);

}
