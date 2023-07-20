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
@Table(name = "player_info")
@Getter
public class PlayerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@JoinColumn(name = "player_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Player player;
	
	@Column(name = "health")
	private int hp;
	@Column(name = "p_health")
	private int potionHp;
	
	private boolean itemDrop;
	private boolean tutorial;
	private boolean checkHp;
	
}
