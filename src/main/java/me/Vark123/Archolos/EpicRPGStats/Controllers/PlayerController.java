package me.Vark123.Archolos.EpicRPGStats.Controllers;

import java.util.List;

import org.hibernate.internal.util.MutableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.Vark123.Archolos.EpicRPGStats.Model.Player;
import me.Vark123.Archolos.EpicRPGStats.Services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService service;
	
	@GetMapping(params = {"!sort", "!page", "!size"})
	ResponseEntity<List<Player>> getAllPlayers() {
		return ResponseEntity.ok(service.getAllPlayers());
	}
	
	@GetMapping
	ResponseEntity<List<Player>> getAllPlayers(Pageable page) {
		return ResponseEntity.ok(service.getPagedPlayers(page).getContent());
	}
	
	@GetMapping(params = "!sort")
	ResponseEntity<List<Player>> getAllPlayersByExp(Pageable page) {
		PageRequest pageRequest = PageRequest.of(
				page.getPageNumber(),
				page.getPageSize(), 
				Sort.by(new Order(Direction.DESC, "stats.exp")));
		return ResponseEntity.ok(service.getPagedPlayers(pageRequest).getContent());
	}
	
	@GetMapping(path = "/get", params = "id")
	ResponseEntity<?> getPlayerById(@RequestParam int id) {
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
		MutableObject<ResponseEntity<?>> mutableRespone = new MutableObject<>();
		service.getPlayerByNick(nick).ifPresentOrElse(player -> {
			mutableRespone.set(ResponseEntity.ok(player));
		}, () -> {
			mutableRespone.set(ResponseEntity.notFound().build());
		});
		return mutableRespone.get();
	}
	
}
