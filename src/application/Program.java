package application;

import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		int id = 0;

		char resp = 's';

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		while (resp == 's' || resp == 'S') {

			System.out.println("--== Digite o id da busca ==--");
			System.out.println(" ");
			id = sc.nextInt();
			Seller seller = sellerDao.findById(id);

			if (seller != null) {
				System.out.println(seller);
			} else {
				System.out.println(" O id especificado não existe");
			}

			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Deseja Fazer uma nova busca ? S/N");
			resp = sc.next().charAt(0);
			System.out.println(" ");
		}

		System.out.println(" --== Tchau :D ==--");
		
		sc.close();
		DB.closeConnection();
	}

}
