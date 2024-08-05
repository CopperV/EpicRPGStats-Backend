package me.Vark123.Archolos.EpicRPGStats.Model.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import me.Vark123.Archolos.EpicRPGStats.Model.PlayerStats;

@Entity
@Table(name = "players")
@Getter
public class ListPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "UUID")
	private String uid;
	private String nick;

	@JsonManagedReference
	@OneToOne(
			mappedBy = "player",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch=FetchType.LAZY)
	private PlayerStats stats;
	
}
