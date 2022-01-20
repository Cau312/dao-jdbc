package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int id = 0;
		
		Connection conn = DB.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {

			st = conn.createStatement();

			
			System.out.println("Digite o Id de quem procura");
			id = sc.nextInt();
			
			
			rs = st.executeQuery("SELECT seller.*,department.Name as DepName \r\n"
					+ "FROM seller INNER JOIN department \r\n"
					+ "ON seller.DepartmentId = department.Id \r\n"
					+ "WHERE seller.Id = " + id);

			Seller sel = null;
					
			while (rs.next() == true) {

				sel = new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"),
						rs.getDate("BirthDate"), rs.getDouble("BaseSalary"),
						new Department(rs.getInt("DepartmentId"), rs.getString("DepName")));
			}
			
			System.out.println(sel);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
	}

}
