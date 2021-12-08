package agendamento.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import agendamento.presentation.model.Scheduling;
import cliente.presentation.model.Customer;
import servico.presentation.model.Service;
import shared.MysqlConnection;

public class SchedulingDAOImpl implements SchedulingDAO {
	
	private SchedulingItemDAO schedulingItemDAO;
	
	public SchedulingDAOImpl(SchedulingItemDAO schedulingItemDAO){
		this.schedulingItemDAO = schedulingItemDAO;
	}

	@Override
	public boolean insert(Scheduling scheduling) {
		String sql = "insert into agendamento(id_agendamento, id_cliente, data, hora) values(?,?,?,?)";

		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, scheduling.getId());
			stmt.setString(2, scheduling.getCustomer().getId());
			stmt.setDate(3, new Date(scheduling.getDate().getTime()));
			stmt.setString(4, scheduling.getHour());
			stmt.execute();
			return schedulingItemDAO.insert(scheduling);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			MysqlConnection.closeConnection();
		}
	}

	

	@Override
	public boolean update(Scheduling service) {
		
		
		return true;
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from agendamento where id_agendamento like '"+id+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return true;
	}

	@Override
	public List<Scheduling> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scheduling> searchByDate(java.util.Date date) {
		Date sqlDate = new Date(date.getTime());
		List<Scheduling> schedulings = new ArrayList<Scheduling>();
		
		String sql = "select a.id_agendamento, a.data, a.hora, c.* "
				+ "from agendamento a "
				+ "inner join cliente c "
				+ "on a.id_cliente = c.id_cliente "
				+ "where data = '"+sqlDate+"'";
		
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				Date dateDB = rs.getDate(2);
				String hour = rs.getString(3);
				String customerId = rs.getString(4);
				String customerName = rs.getString(5);
				String customerNumber = rs.getString(6);
				String customerEmail= rs.getString(7);
				String customerCPF = rs.getString(8);
				Customer customer = new Customer(customerId, customerName, customerNumber, customerEmail, customerCPF);
				List<Service> services = schedulingItemDAO.searchServicesByScheduling(id);
				Scheduling scheduling = new Scheduling(id, customer, services, dateDB, hour);
				schedulings.add(scheduling);
			}			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return schedulings;
	}

}
