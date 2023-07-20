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
@Table(name = "player_stats")
@Getter
public class PlayerStats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@JoinColumn(name = "player_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Player player;
	
	private String ranga;
	private String klasa;
	
	private int level;
	private long exp;
	@Column(name = "nextlevel")
	private long nextLevel;
	
	private int pn;
	
	@Column(name = "p_str")
	private int sila;
	@Column(name = "p_wytrz")
	private int wytrzymalosc;
	@Column(name = "p_zr")
	private int zrecznosc;
	@Column(name = "p_zd")
	private int zdolnosci;
	@Column(name = "p_int")
	private int inteligencja;
	@Column(name = "p_mana")
	private int mana;
	@Column(name = "p_walka")
	private int walka;
	
	@Column(name = "potion_str")
	private int potionSila;
	@Column(name = "potion_wytrz")
	private int potionWytrzymalosc;
	@Column(name = "potion_zr")
	private int potionZrecznosc;
	@Column(name = "potion_zd")
	private int potionZdolnosci;
	@Column(name = "potion_int")
	private int potionInteligencja;
	@Column(name = "potion_mana")
	private int potionMana;
	@Column(name = "potion_walka")
	private int potionWalka;
	
	@Column(name = "p_krag")
	private int krag;

	@Column(name = "p_stygia")
	private int stygia;
	@Column(name = "p_coins")
	private int coins;
	@Column(name = "p_brylki")
	private int brylki;

	@Column(name = "p_event")
	private int event;
}
