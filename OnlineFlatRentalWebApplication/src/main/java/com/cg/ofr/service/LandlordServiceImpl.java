package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.ILandlordRepository;

@Service
@Transactional
public class LandlordServiceImpl implements ILandlordService {

	@Autowired
	private ILandlordRepository landlordRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		try {
			return landlordRepository.save(landlord);
		} catch (Exception e) {
			throw new EntityCreationException("valid details of landlord is not entered");
		}

	}

	@Override
	public Landlord updateLandlord(Landlord landlord) {
		try {
			Optional<Landlord> updatelandlord = landlordRepository.findById(landlord.getLandlordId());
			if (updatelandlord.isPresent()) {
				return landlordRepository.save(landlord);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException("No updation found");
		}

	}

	@Override
	public Landlord deleteLandlord(Landlord landlord) {
		try {

			Optional<Landlord> deletelandlord = landlordRepository.findById(landlord.getLandlordId());
			if (deletelandlord.isPresent()) {
				landlordRepository.delete(landlord);

			}
			return deletelandlord.get();

		} catch (Exception e) {
			throw new EntityDeletionException("landlord details are not valid");
		}

	}

	@Override
	public Landlord viewLandlord(int id) {
		try {
			Optional<Landlord> landlord = landlordRepository.findById(id);
			if (landlord.isPresent()) {
				return landlord.get();
			} else {
				throw new EntityNotFoundException("Landlord with id" + id + "not found");
			}
		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Landlord> viewAllLandlord() {
		List<Landlord> landlordlist = new ArrayList<Landlord>();
		try {
			landlordlist = landlordRepository.findAll();
			if (landlordlist.isEmpty()) {
				throw new EmptyEntityListException("No landlord found");

			} else {
				return landlordlist;
			}
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

}