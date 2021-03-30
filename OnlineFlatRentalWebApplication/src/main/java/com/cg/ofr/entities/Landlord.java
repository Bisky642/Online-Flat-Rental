/**
 * 
 */
package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admit
 *
 */
@Entity
public class Landlord {

	@Id
	private int landlordId;
	private String landlordName;
	private int landlordAge;
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "land_lord_ID")
	private List<Flat> flatList;

	/**
	 * 
	 */
	public Landlord() {
		super();
	}

	/**
	 * @param landlordId
	 * @param landlordName
	 * @param landlordAge
	 * @param flatList
	 */
	public Landlord(int landlordId, String landlordName, int landlordAge, List<Flat> flatList) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}

	/**
	 * @return the landlordId
	 */
	public int getLandlordId() {
		return landlordId;
	}

	/**
	 * @param landlordId the landlordId to set
	 */
	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	/**
	 * @return the landlordName
	 */
	public String getLandlordName() {
		return landlordName;
	}

	/**
	 * @param landlordName the landlordName to set
	 */
	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	/**
	 * @return the landlordAge
	 */
	public int getLandlordAge() {
		return landlordAge;
	}

	/**
	 * @param landlordAge the landlordAge to set
	 */
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}

	/**
	 * @return the flatList
	 */
	public List<Flat> getFlatList() {
		return flatList;
	}

	/**
	 * @param flatList the flatList to set
	 */
	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}

}
