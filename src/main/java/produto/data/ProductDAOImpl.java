package produto.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import produto.presentation.model.Product;
import shared.MysqlConnection;

public class ProductDAOImpl implements ProductDAO{

	@Override
	public boolean insert(Product product) {
		String sql = "insert into produto (id_produto, descricao, preco, qtdEstoque) "
				+ "values (?,?,?,?)";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getDescription());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQtyStock());
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			MysqlConnection.closeConnection();
		}
		return true;
	}

	@Override
	public boolean update(Product product) {
		String sql = "update produto "
				+ "set descricao = ?, preco = ?, qtdEstoque = ? "
				+ "where id_produto = '"+product.getId()+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getDescription());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getQtyStock());
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			MysqlConnection.closeConnection();
		}
		return true;
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from produto where id_produto = '"+id+"'";
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			MysqlConnection.closeConnection();
		}
		return true;
	}

	@Override
	public List<Product> searchByDescription(String description) {
		String sql = "select * from produto where descricao like '"+description+"%'";
		List<Product> products = new ArrayList<Product>();
		
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String descriptionDB = rs.getString(2);
				double price = rs.getDouble(3);
				int qtyStock = rs.getInt(4);
				Product product = new Product(id, descriptionDB, price, qtyStock);
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			MysqlConnection.closeConnection();
		}
		
		return products;
	}

	@Override
	public String count() {
		String sql = "select count(id_produto) from produto";
		String count = null;
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			count = rs.getString(1);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			MysqlConnection.closeConnection();
		}
		
		return count;
	}

}
