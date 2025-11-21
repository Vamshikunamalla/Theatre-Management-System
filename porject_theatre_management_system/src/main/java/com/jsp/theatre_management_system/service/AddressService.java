package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.AddressDao;
import com.jsp.theatre_management_system.dto.Address;
import com.jsp.theatre_management_system.exception.AddressIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;

	    public ResponseStructure<Address> saveAddress(Address address) {
	    	responseStructure.setStatusCoad(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Succesfully Saved the Address into db");
	    	responseStructure.setData(addressDao.saveAddress(address));
		return	responseStructure;
		}

		public ResponseStructure<Address> ftchAddressById(int addressId) {
		     Address address=addressDao.ftchAddressById(addressId);
		     if(address!=null) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetch  Address from db");
			responseStructure.setData(addressDao.ftchAddressById(addressId)); 
		 return	responseStructure;}
		     else {
				throw new AddressIdNotFound();
			}
		}
		public ResponseStructure<Address> deleteAddressById(int addressId) {
			 Address address=addressDao.ftchAddressById(addressId);
		     if(address!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Delete Address from db");
			responseStructure.setData(addressDao.deleteAddressById(addressId));
		return responseStructure;}
		     else {
				throw new AddressIdNotFound();
			}
		
		}
		public ResponseStructure<Address> updateAddressById(int oldAddressId,Address newAddress) {
			Address address=addressDao.ftchAddressById(oldAddressId);
		     if(address!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully update Address in db");
			responseStructure.setData(addressDao.saveAddress(newAddress));
		 return	responseStructure;}
		     else {
				throw new AddressIdNotFound();
			}
		}
		public ResponseStructureList<Address> fetchAllAddresses() {
			Address address=(Address) addressDao.fetchAllAddress();
		     if(address!=null) {
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Succesfully fetch allAddress from db ");
			responseStructureList.setData(addressDao.fetchAllAddress());
		return	 responseStructureList;}
		     else {
				throw new AddressIdNotFound();
			}
			
		}
}
