package me.Vark123.Archolos.EpicRPGStats.Model;

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

@Entity
@Table(name = "players")
@Getter
public class Player {

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
	private PlayerInfo info;

	@JsonManagedReference
	@OneToOne(
			mappedBy = "player",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch=FetchType.LAZY)
	private PlayerReputation rep;

	@JsonManagedReference
	@OneToOne(
			mappedBy = "player",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch=FetchType.LAZY)
	private PlayerRzemioslo rzemioslo;

	@JsonManagedReference
	@OneToOne(
			mappedBy = "player",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch=FetchType.LAZY)
	private PlayerSkills skills;

	@JsonManagedReference
	@OneToOne(
			mappedBy = "player",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch=FetchType.LAZY)
	private PlayerStats stats;
	
}
