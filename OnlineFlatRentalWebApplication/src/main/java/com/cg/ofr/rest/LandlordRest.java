package com.cg.ofr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.service.ILandlordService;

@RestController
public class LandlordRest {

	@Autowired
	private ILandlordService Ilandlordservice;

	@PostMapping("/landlord")
	public Landlord addLandlord(@RequestBody Landlord landlord) {
		Landlord landlord2 = null;
		landlord2=this.Ilandlordservice.addLandlord(landlord);
		return landlord2;
	}

	@PutMapping("/landlord")
	public Landlord updateLandlord(@RequestBody Landlord landlord) {
		Landlord landlord2 = null;
		landlord2 = this.Ilandlordservice.updateLandlord(landlord);
		return landlord2;
	}

	@DeleteMapping("/landlord")
	public Landlord deleteLandlord(@RequestBody Landlord landlord) {
		Landlord landlord2 = null;
		landlord2 = this.Ilandlordservice.deleteLandlord(landlord);
		return landlord2;
	}

	@GetMapping("/landlord/{id}")
	public Landlord viewLandlord(@PathVariable("id") int id) {
		Landlord landlord2 = null;
		landlord2 =  this.Ilandlordservice.viewLandlord(id);
		return landlord2;
	}

	@GetMapping("/landlords")
	public List<Landlord> viewAlllandlord() {
		List<Landlord> landlord = this.Ilandlordservice.viewAllLandlord();
		return landlord;
	}

}