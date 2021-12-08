package agendamento.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agendamento.presentation.model.Scheduling;
import agendamento.presentation.model.SchedulingItem;
import servico.presentation.model.Service;
import shared.MysqlConnection;

public class SchedulingItemDAOImpl implements SchedulingItemDAO{
	
	public boolean insert(Scheduling scheduling) {
		String sql = "insert into item_agendamento(id_item_agendamento, id_agendamento, id_servico) values(?,?,?)";

		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			for (Service service : scheduling.getServices()) {
				SchedulingItem schedulingItem = new SchedulingItem(scheduling.getId(), service.getId());
				stmt.setString(1, schedulingItem.getId());
				stmt.setString(2, schedulingItem.getSchedulingId());
				stmt.setString(3, schedulingItem.getServiceId());
				stmt.execute();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public List<Service> searchServicesByScheduling(String schedulingId) {
		List<Service> services = new ArrayList<>();
		
		String sql = "select s.* from item_agendamento i "
				+ "inner join servico s "
				+ "on i.id_servico = s.id_servico "
				+ " where id_agendamento = '"+schedulingId+"'";
		
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String description = rs.getString(2);
				double price = rs.getDouble(3);
				Service service = new Service(id, description, price);
				services.add(service);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		
		return services;
	}
}
