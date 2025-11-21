package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Address;
import com.jsp.theatre_management_system.service.AddressService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created")})
	@PostMapping("/saveAddress")
	 public ResponseStructure<Address> saveAddress(Address address) {
		return	addressService.saveAddress(address);
		}
	
	@Operation(summary = "ftchAddressById", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetch"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@GetMapping("/ftchAddressById")
	public ResponseStructure<Address> ftchAddressById(int addressId) {
		 return	 addressService.ftchAddressById(addressId);
		}
	@Operation(summary = "deleteAddressById", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully delete"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@DeleteMapping("/deleteAddressById")
		public ResponseStructure<Address> deleteAddressById(@RequestParam int addressId) {
		return 	addressService.deleteAddressById(addressId);
		}
	@Operation(summary = "updateAddressById", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully update"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@PutMapping("/updateAddressById")
		public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId ,@RequestBody Address newAddress) {
		 return	addressService.saveAddress(newAddress);
		}
	@Operation(summary = "fetchAllAddresses", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetchAll"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@GetMapping("/fetchAllAddresses")
		public ResponseStructureList<Address> fetchAllAddresses() {
		return	addressService.fetchAllAddresses();
			
		}

}
