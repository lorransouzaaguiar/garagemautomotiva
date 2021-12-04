package servico.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cliente.presentation.model.Customer;
import servico.presentation.model.Service;
import shared.MysqlConnection;

public class ServiceDAOImpl implements ServiceDAO{

	@Override
	public boolean insert(Service service) {
		String sql = "insert into servico(id_servico,descricao,preco) values(?,?,?)";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, service.getId());
			stmt.setString(2, service.getDescription());
			stmt.setDouble(3, service.getPrice());
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
	public boolean update(Service service) {
		String sql = "update servico set descricao = ?, preco = ?"
				+ "where id_servico = '"+service.getId()+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, service.getDescription());
			stmt.setDouble(2, service.getPrice());
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
	public boolean delete(String id) {
		String sql = "delete from servico where id_servico like '"+id+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
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
	public List<Service> searchByName(String description) {
		List<Service> services = new ArrayList<Service>();
		String sql = "select * from servico where descricao like '"+description+"%'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String dbDescription = rs.getString(2);
				double price = rs.getDouble(3);
				Service service = new Service(id, dbDescription, price);
				services.add(service);
			}			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return services;
	}

	@Override
	public List<Service> searchAll() {
		List<Service> services = new ArrayList<Service>();
		String sql = "select * from servico";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String dbDescription = rs.getString(2);
				double price = rs.getDouble(3);
				Service service = new Service(id, dbDescription, price);
				services.add(service);
			}			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return services;
	}

	
}
