package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- TEST 1: seller findby ID---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n--- TEST 2: seller findbyDepartment ID---");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) { 
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 2: seller findAll ID---");
		list = sellerDao.findAll();
		for (Seller obj : list) { 
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 2: seller INSERT---");
		Seller newSeller = new Seller(null, "BMO", "imbmo@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n--- TEST 2: seller UPDATE---");
		seller = sellerDao.findById(6);
		seller.setName("Nepthur");
		seller.setEmail("imamicrowave@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
	}

}
