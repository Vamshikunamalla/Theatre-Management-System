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
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Staff;
import com.jsp.theatre_management_system.service.BranchService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class BranchController {
@Autowired
BranchService branchService;

@Operation(summary = "saveBranch", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created")})
@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return	branchService.saveBranch(branch);
		}


@Operation(summary = "addExistingBranchToExistingAddress", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully addExistingBranchToExistingAddress"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

@PutMapping("/addExistingBranchToExistingAddress")
public ResponseStructure<Branch> addExistingBranchToExistingAddress(@RequestParam int branchId,@RequestParam int addressId ) {
return	branchService.addExistingBranchToExistingAddress(branchId, addressId);
}

@Operation(summary = "addExistingBranchToExisitingScreen", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully addExistingBranchToExisitingScreen"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

@PutMapping("/addExistingBranchToExisitingScreen")
public ResponseStructure<Branch> addExistingBranchToExisitingScreen(@RequestParam int branchId,@RequestParam int screenId) {
	return branchService.addExistingBranchToExisitingScreen(branchId, screenId);
}

@Operation(summary = "addExistingBranchToAddScreen", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully addExistingBranchToAddScreen"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

@PutMapping("/addExistingBranchToAddScreen")
public ResponseStructure<Branch> addExistingBranchToAddScreen(@RequestParam int branchId,@RequestBody Screen newScreen) {
return	branchService.addExistingBranchToAddScreen(branchId, newScreen);
}


@Operation(summary = "addExistingBranchToAddNewAddress", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully addExistingBranchToAddNewAddress"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

@PutMapping("/addExistingBranchToAddNewAddress")
public ResponseStructure<Branch> addExistingBranchToAddNewAddress(@RequestParam int branchId,@RequestBody Address newAddress ) {
return	branchService.addExistingBranchToAddNewAddress(branchId, newAddress);
}

@Operation(summary = "addExistingBranchToExisitingStaff", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully addExistingBranchToExisitingStaff"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

@PutMapping("/addExistingBranchToExisitingStaff")
public ResponseStructure<Branch> addExistingBranchToExisitingStaff(@RequestParam int branchId,@RequestParam int staffId) {
	return	branchService.addExistingBranchToExisitingStaff(branchId, staffId);
	}

@Operation(summary = "addExistingBranchToAddStaff", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully addExistingBranchToAddStaff"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })

@PutMapping("/addExistingBranchToAddStaff")
	public ResponseStructure<Branch> addExistingBranchToAddStaff(@RequestParam int branchId,@RequestBody Staff newStaff) {
	return	branchService.addExistingBranchToAddStaff(branchId, newStaff);
	}


@Operation(summary = "fetchBranchById", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetchBranchById"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
@GetMapping("/fetchBranchById")
		public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return	branchService.fetchBranchById(branchId);
		}


@Operation(summary = "deleteBranchById", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleteBranchById"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
@DeleteMapping("/deleteBranchById")
		public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return	branchService.deleteBranchById(branchId);	
		}


@Operation(summary = "updateBranchById", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updateBranchById"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
@PutMapping("/updateBranchById")
		public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBarnchId,@RequestBody Branch newBranch) {
		return	branchService.saveBranch(newBranch);	
		}

@Operation(summary = "fetchAllBranchs", description = "API is used to save the Branch")
@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetchAllBranchs"),
		@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
@GetMapping("/fetchAllBranchs")
		public ResponseStructureList<Branch> fetchAllBranchs() {
		return	branchService.fetchAllBranchs();
			
		}
}
