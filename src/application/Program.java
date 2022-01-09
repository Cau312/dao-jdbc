package application;

import java.util.Date;

import db.DB;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DB.getConnection();
		DB.closeConnection();

		Department dptM = new Department(1, "Macacos");
		
		Seller vend = new Seller(21,"Marquinhos", "xaolinmatadordeporco@gmail.com", new Date() , 5000.0, dptM);
		
		System.out.println(dptM);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(vend);

	}

}
