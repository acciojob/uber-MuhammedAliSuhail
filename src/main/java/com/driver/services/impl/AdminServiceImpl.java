package com.driver.services.impl;

import java.util.List;
import java.util.Optional;

import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.AdminRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository1;

	@Autowired
	DriverRepository driverRepository1;

	@Autowired
	CustomerRepository customerRepository1;

	@Override
	public void adminRegister(Admin admin) {
		//Save the admin in the database
		adminRepository1.save(admin);
	}

	@Override
	public Admin updatePassword(Integer adminId, String password) throws Exception {
		//Update the password of admin with given id
		Optional<Admin> admin =adminRepository1.findById(adminId);
		Admin admin1=new Admin();
		if(admin.isPresent()){
			admin1=admin.get();
			admin1.setPassword(password);
			adminRepository1.save(admin1);
		}else {
		throw new Exception("not such id presant");
		}




		return admin1;

	}

	@Override
	public void deleteAdmin(int adminId){
		// Delete admin without using deleteById function
         adminRepository1.deleteById(adminId);
	}

	@Override
	public List<Driver> getListOfDrivers() {
		//Find the list of all drivers
		List<Driver> drivers=driverRepository1.findAll();
 return drivers;
	}

	@Override
	public List<Customer> getListOfCustomers() {
		//Find the list of all customers
		List<Customer> customers=customerRepository1.findAll();
return customers;
	}

}
