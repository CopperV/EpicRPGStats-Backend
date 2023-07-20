package me.Vark123.Archolos.EpicRPGStats.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "player_reputation")
@Getter
public class PlayerReputation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@JoinColumn(name = "player_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Player player;
	
	@Column(name = "archolos_id")
	private int archolosLevel;
	private int archolosAmount;
	
	@Column(name = "klan_id")
	private int klanLevel;
	private int klanAmount;
	
	@Column(name = "witcher_id")
	private int witcherLevel;
	private int witcherAmount;

}
