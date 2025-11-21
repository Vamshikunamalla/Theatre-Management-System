package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.AddressRepo;
import com.jsp.theatre_management_system.dto.Address;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
	return	addressRepo.save(address);
	}

	public Address ftchAddressById(int addressId) {
		Optional<Address> address=addressRepo.findById(addressId);
		if(address.isPresent()) {
			return address.get();
		}else {
			return null;
		}
	}
	public Address deleteAddressById(int addressId) {
	Address address=addressRepo.findById(addressId).get();
	addressRepo.delete(address);
	return address;
	}
	public Address updateAddressById(int oldAddressId,Address newAddress) {
	 return	addressRepo.save(newAddress);
	}
	public List<Address> fetchAllAddress() {
	return	addressRepo.findAll();
		
	}
}
