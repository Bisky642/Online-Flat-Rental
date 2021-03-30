/**
 * 
 */
package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.IFlatBookingRepository;

/**
 * @author
 *
 */

@Service
@Transactional
public class FlatBookingServiceImpl implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository repository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatbooking) {
		try {
			int check=flatbooking.getTenant().getAge();
			if(check>0)
			{
				String avail="No";
				flatbooking.getFlat().setAvailibilty(avail);
			}
			return repository.save(flatbooking);
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatbooking) {
		FlatBooking flatbooking3 = null;
		try {
			Optional<FlatBooking> flatBooking = repository.findById(flatbooking.getBookingNo());
			if (flatBooking.isPresent()) {
				flatbooking3 = repository.save(flatbooking);
				return flatbooking3;
			}

			else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}

	}

	@Override
	public FlatBooking deleteFlatBooking(FlatBooking flatbooking) {
		try {
			int tenantId=flatbooking.getTenant().getTenantId();
			Optional<FlatBooking> flatBooking = repository.findById(flatbooking.getBookingNo());
			if (flatBooking.isPresent()) {
				repository.deleteById(tenantId);
				repository.delete(flatbooking);
				return flatBooking.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}

	}

	@Override
	public FlatBooking viewFlatBooking(int id) {
		try {
			Optional<FlatBooking> flatBooking = repository.findById(id);
			if (flatBooking.isPresent()) {
				return flatBooking.get();
			} else {
				throw new EntityNotFoundException("FlatBooking with id " + id + " is not found");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatbookings = new ArrayList<>();
		try {
			flatbookings = repository.findAll();
			if (flatbookings.isEmpty()) {
				throw new EmptyEntityListException("No FlatBooking Found");
			} else
				return flatbookings;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}