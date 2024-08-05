package me.Vark123.Archolos.EpicRPGStats.Repositories.Adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import me.Vark123.Archolos.EpicRPGStats.Model.Detail.DetailPlayer;
import me.Vark123.Archolos.EpicRPGStats.Repositories.DetailPlayerRepository;



public interface SqlDetailPlayerRepository extends DetailPlayerRepository, JpaRepository<DetailPlayer, Integer> {
	
	
}
