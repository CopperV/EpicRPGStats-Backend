package me.Vark123.Archolos.EpicRPGStats.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.Vark123.Archolos.EpicRPGStats.Model.List.ListPlayer;

public interface ListPlayerRepository {

	public List<ListPlayer> findAll();
	public Page<ListPlayer> findAll(Pageable page);
	
}
