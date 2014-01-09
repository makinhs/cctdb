package cct.lucasmarcos.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cct.lucasmarcos.model.entity.Product;

import com.mysql.jdbc.PreparedStatement;

public class ProductDAO extends AbstractConnectionDAO{
	
	public ProductDAO() { 
		super();
	}
	
	public boolean saveProduct(Product product)
	{
		String sql = "INSERT INTO produto (nome, descricao) values (?,?)";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);            
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());            
            stmt.execute();
            stmt.close();   
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

	}
	
	public Product getProduct(Object productId)
	{
		ResultSet resultSet;
        resultSet = null;
        Product product = null;
        String sql = "SELECT * FROM produto WHERE produtoId = '" + productId + "'";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                stmt.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;		
	}
	
	
	public boolean editProduct(Product product)
	{
		String sql = "UPDATE produto SET nome = ?, descricao = ? WHERE produtoId = '" + product.getId() + "'";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
//            stmt.setInt(1, product.getId());            
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());            
            stmt.execute();
            stmt.close();        
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
