package me.Vark123.Archolos.EpicRPGStats.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import me.Vark123.Archolos.EpicRPGStats.Model.Detail.DetailPlayer;

@Entity
@Table(name = "player_rzemioslo")
@Getter
public class PlayerRzemioslo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@JoinColumn(name = "player_id")
	@OneToOne(fetch = FetchType.LAZY)
	private DetailPlayer player;
	
	private boolean alchemia;
	private boolean kowalstwo;
	private boolean platnerstwo;
	private boolean luczarstwo;
	private boolean jubilerstwo;

}
