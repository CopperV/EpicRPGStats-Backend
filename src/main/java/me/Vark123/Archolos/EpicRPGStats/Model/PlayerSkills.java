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
@Table(name = "player_skills")
@Getter
public class PlayerSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@JoinColumn(name = "player_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Player player;
	
	@Column(name = "manareg")
	private boolean manaRegeneration;
	@Column(name = "unlimitarr")
	private boolean unlimitedArrows;
	@Column(name = "foodless")
	private boolean hungerless;
	@Column(name = "slugabeliara")
	private boolean slugaBeliara;
	@Column(name = "magkrwi")
	private boolean magKrwi;
	@Column(name = "cioskrytyczny")
	private boolean ciosKrytyczny;
	@Column(name = "magnetyzm")
	private boolean magnetyzm;
	@Column(name = "silazywiolow")
	private boolean silaZywiolow;
	@Column(name = "polnocnybarbarzynca")
	private boolean polnocnyBarbarzynca;
	private boolean rozprucie;

}
