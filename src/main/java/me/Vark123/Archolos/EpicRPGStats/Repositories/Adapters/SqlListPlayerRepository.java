package me.Vark123.Archolos.EpicRPGStats.Repositories.Adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import me.Vark123.Archolos.EpicRPGStats.Model.List.ListPlayer;
import me.Vark123.Archolos.EpicRPGStats.Repositories.ListPlayerRepository;

public interface SqlListPlayerRepository extends ListPlayerRepository, JpaRepository<ListPlayer, Integer> {
	
	
}
