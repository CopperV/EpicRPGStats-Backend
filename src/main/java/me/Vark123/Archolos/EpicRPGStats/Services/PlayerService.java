package me.Vark123.Archolos.EpicRPGStats.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import me.Vark123.Archolos.EpicRPGStats.Model.Detail.DetailPlayer;
import me.Vark123.Archolos.EpicRPGStats.Model.List.ListPlayer;
import me.Vark123.Archolos.EpicRPGStats.Model.Search.SearchPlayer;
import me.Vark123.Archolos.EpicRPGStats.Repositories.DetailPlayerRepository;
import me.Vark123.Archolos.EpicRPGStats.Repositories.ListPlayerRepository;
import me.Vark123.Archolos.EpicRPGStats.Repositories.SearchPlayerRepository;

@Service
public class PlayerService {

	private final DetailPlayerRepository detailRepo;
	private final SearchPlayerRepository searchRepo;
	private final ListPlayerRepository listRepo;
	
	
	public PlayerService(DetailPlayerRepository detailRepo, SearchPlayerRepository searchRepo,
			ListPlayerRepository listRepo) {
		this.detailRepo = detailRepo;
		this.searchRepo = searchRepo;
		this.listRepo = listRepo;
	}

	public List<ListPlayer> getAllPlayers() {
		return listRepo.findAll();
	}
	
	public Page<ListPlayer> getPagedPlayers(Pageable page){
		return listRepo.findAll(page);
	}
	
	public Optional<DetailPlayer> getPlayerById(int id) {
		return detailRepo.findById(id);
	}
	
	public Optional<DetailPlayer> getPlayerByUID(String uid) {
		return detailRepo.findByUid(uid);
	}
	
	public Optional<DetailPlayer> getPlayerByNick(String nick) {
		return detailRepo.findByNick(nick);
	}
	
	public int countPlayers() {
		return detailRepo.countPlayers();
	}
	
	public List<SearchPlayer> searchPlayersByName(String name) {
		return searchRepo.searchPlayersByName(name);
	}
	
}
