package cct.lucasmarcos.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import cct.lucasmarcos.db.model.Product;
import cct.lucasmarcos.db.model.User;

public class UserProductDAO extends AbstractConnectionDAO{
	public UserProductDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public boolean saveUserProduct(User user, Product product)
	{
		String sql = "INSERT INTO usuarioproduto (usuarioId, produtoId) values (?,?)";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());            
            stmt.setInt(2, product.getId());            
            stmt.execute();
            stmt.close();   
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public int getUserProductId(User user, Product product)
	{
		ResultSet resultSet;
        resultSet = null;        
        int result = 0;
        String sql = "SELECT usuarioProdutoId FROM usuarioproduto WHERE usuarioId = '" + user.getId() + "' and produtoId = '" + product.getId() + "'";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                
                result = resultSet.getInt(1);
                
                stmt.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;		
	}
	
	public boolean removeUserProduct(User user, Product product)
	{
		//procura 
		
		 String sql = "DELETE FROM usuarioproduto WHERE usuarioProdutoId = '" + getUserProductId(user, product) + "'";

	        try {
	            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	            stmt.execute();
	            stmt.close();

	            return true;

	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
}
