package caixa.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import caixa.presentation.model.Sale;
import shared.MysqlConnection;

public class ProductSaleDAOImpl implements ProductSaleDAO{

	@Override
	public boolean insert(Sale sale) {
		String sql = "insert into venda(id_venda,id_cliente,data, valor) values(?,?,?,?)";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, sale.getId());
			stmt.setString(2, sale.getCustomerId());
			stmt.setDate(3, new Date(sale.getDate().getTime()));
			stmt.setDouble(4, sale.getTotalValue());
			stmt.execute();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return true;
	}

}
