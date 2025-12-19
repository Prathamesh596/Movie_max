package com.moviemax.controller;

import com.moviemax.dto.TheaterOwnerDTO;
import com.moviemax.service.TheaterOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaterowner")
@CrossOrigin(origins = "http://localhost:5173")
public class TheaterOwnerController {
	@Autowired
	private TheaterOwnerService theaterOwnerService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAlOwners() {
		System.out.println("in get all users");
		List<TheaterOwnerDTO> theaterOwner = theaterOwnerService.getAllTheaterOwner();
		if (theaterOwner.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(theaterOwner);
	}

	@DeleteMapping("/deleteUser/{ownerId}")
	public ResponseEntity<?> deleteTheaterOwnerDetails(@PathVariable Long ownerId) {
		System.out.println("in delete owner details " + ownerId);

		return ResponseEntity.ok(theaterOwnerService.deleteTheaterOwnerDetails(ownerId));
	}

	@GetMapping("/{id}")
	public TheaterOwnerDTO getTheaterOwnerById(@PathVariable long id) {
		return theaterOwnerService.getTheaterOwneById(id);
	}

}
