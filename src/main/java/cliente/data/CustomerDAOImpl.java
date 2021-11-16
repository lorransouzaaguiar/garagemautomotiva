package cliente.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cliente.presentation.model.Customer;
import shared.MysqlConnection;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public boolean insert(Customer customer) {
		String sql = "insert into cliente(id_cliente,nome,celular,email,cpf) values(?,?,?,?,?)";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getNumber());
			stmt.setString(4, customer.getEmail());
			stmt.setString(5, customer.getCpf());
			stmt.execute();
			return true;
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}finally {
			MysqlConnection.closeConnection();
		}
	}

	@Override
	public boolean update(Customer customer) {
		String sql = "update cliente set nome = ?, celular = ?, email = ?, cpf = ? "
				+ "where id_cliente = '"+customer.getId()+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getNumber());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getCpf());
			stmt.executeUpdate();
			return true;
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}finally {
			MysqlConnection.closeConnection();
		}
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from cliente where id_cliente like '"+id+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}finally {
			MysqlConnection.closeConnection();
		}
	}

	@Override
	public List<Customer> searchByName(String name) {
		List<Customer> customers = new ArrayList<Customer>();
		String sql = "select * from cliente where nome like '"+name+"%'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String dbName = rs.getString(2);
				String number = rs.getString(3);
				String email = rs.getString(4);
				String cpf = rs.getString(5);
				Customer customer = new Customer(id, dbName, number, email, cpf);
				customers.add(customer);
			}			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return customers;
	}

	@Override
	public List<Customer> searchAll() {
		List<Customer> customers = new ArrayList<Customer>();
		String sql = "select * from cliente";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String dbName = rs.getString(2);
				String number = rs.getString(3);
				String email = rs.getString(4);
				String cpf = rs.getString(5);
				Customer customer = new Customer(id, dbName, number, email, cpf);
				customers.add(customer);
			}			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return customers;
	}


}
