package me.Vark123.Archolos.EpicRPGStats.Controllers;

import java.util.List;

import org.hibernate.internal.util.MutableObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.Vark123.Archolos.EpicRPGStats.Model.List.ListPlayer;
import me.Vark123.Archolos.EpicRPGStats.Services.PlayerService;

@CrossOrigin
@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService service;
	Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	@GetMapping(params = {"!sort", "!page", "!size"})
	ResponseEntity<List<ListPlayer>> getAllPlayers() {
		logger.info("getting all players without parameters");
		return ResponseEntity.ok(service.getAllPlayers());
	}
	
	@GetMapping
	ResponseEntity<List<ListPlayer>> getAllPlayers(Pageable page) {
		logger.info("getting paged players ["+page.toString()+"]");
		return ResponseEntity.ok(service.getPagedPlayers(page).getContent());
	}
	
	@GetMapping(params = "!sort")
	ResponseEntity<List<ListPlayer>> getAllPlayersByExp(Pageable page) {
		logger.info("getting paged players without sort parameter");
		PageRequest pageRequest = PageRequest.of(
				page.getPageNumber(),
				page.getPageSize(), 
				Sort.by(new Order(Direction.DESC, "stats.exp")));
		return ResponseEntity.ok(service.getPagedPlayers(pageRequest).getContent());
	}
	
	@GetMapping(path = "/get", params = "id")
	ResponseEntity<?> getPlayerById(@RequestParam int id) {
		logger.info("getting player by id ["+id+"]");
		MutableObject<ResponseEntity<?>> mutableRespone = new MutableObject<>();
		service.getPlayerById(id).ifPresentOrElse(player -> {
			mutableRespone.set(ResponseEntity.ok(player));
		}, () -> {
			mutableRespone.set(ResponseEntity.notFound().build());
		});
		return mutableRespone.get();
	}
	
	@GetMapping(path = "/get", params = "uid")
	ResponseEntity<?> getPlayerByUID(@RequestParam String uid) {
		logger.info("getting player by uid ["+uid+"]");
		MutableObject<ResponseEntity<?>> mutableRespone = new MutableObject<>();
		service.getPlayerByUID(uid).ifPresentOrElse(player -> {
			mutableRespone.set(ResponseEntity.ok(player));
		}, () -> {
			mutableRespone.set(ResponseEntity.notFound().build());
		});
		return mutableRespone.get();
	}
	
	@GetMapping(path = "/get", params = "nick")
	ResponseEntity<?> getPlayerByNick(@RequestParam String nick) {
		logger.info("getting player by nick ["+nick+"]");
		MutableObject<ResponseEntity<?>> mutableRespone = new MutableObject<>();
		service.getPlayerByNick(nick).ifPresentOrElse(player -> {
			mutableRespone.set(ResponseEntity.ok(player));
		}, () -> {
			mutableRespone.set(ResponseEntity.notFound().build());
		});
		return mutableRespone.get();
	}
	
	@GetMapping(path = "/get-player-amount")
	ResponseEntity<?> getAmountOfPlayers() {
		logger.info("getting amount of players in database");
		return ResponseEntity.ok(service.countPlayers());
	}
	
	@GetMapping(path = "/search-players-by-name", params = "name")
	ResponseEntity<?> searchPlayersByName(@RequestParam String name) {
		logger.info("search players starting with nick ["+name+"%]");
		return ResponseEntity.ok(service.searchPlayersByName(name));
	}
	
}
