package application;

import db.DB;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DB.getConnection();
		DB.closeConnection();

		Department dptM = new Department(1, "Macacos");
		System.out.println(dptM);

	}

}
