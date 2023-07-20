package me.Vark123.Archolos.EpicRPGStats.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import me.Vark123.Archolos.EpicRPGStats.Model.Player;
import me.Vark123.Archolos.EpicRPGStats.Repositories.PlayerRepository;

@Service
public class PlayerService {

	private final PlayerRepository repo;
	public PlayerService(PlayerRepository repo) {
		this.repo = repo;
	}
	
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}
	
	public Page<Player> getPagedPlayers(Pageable page){
		return repo.findAll(page);
	}
	
}
