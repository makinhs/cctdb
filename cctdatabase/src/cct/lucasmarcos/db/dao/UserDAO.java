package cct.lucasmarcos.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cct.lucasmarcos.model.entity.User;

import com.mysql.jdbc.PreparedStatement;

public class UserDAO extends AbstractConnectionDAO{
	
	
	public UserDAO() {
		super();
	}
	
	public boolean saveUser(User user)
	{
		String sql = "INSERT INTO usuario (facebookId, nome, pontos) values (?,?,?)";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setString(2, user.getName());
            stmt.setInt(3, user.getRating());            
            stmt.execute();
            stmt.close();   
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

	}
	
	public User getUser(Object userId)
	{
		ResultSet resultSet;
        resultSet = null;
        User usuario = null;
        String sql = "SELECT * FROM usuario WHERE usuarioId = '" + userId + "'";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
//                usuario = new User(resultSet.getInt(1), resultSet.getInt(6), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(3), resultSet.getInt(2));
                usuario = new User();
                usuario.setId(resultSet.getInt(1));
                usuario.setName(resultSet.getString(3));
                usuario.setRating(resultSet.getInt(4));
                stmt.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;		
	}
	
	
	public boolean editUser(User user)
	{
		String sql = "UPDATE usuario SET nome = ?, pontos = ? WHERE usuarioId = '" + user.getId() + "'";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
//            stmt.setInt(1, user.getId());            
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getRating());            
            stmt.execute();
            stmt.close();        
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		ResultSet resultSet;
        resultSet = null;
        User usuario = null;
        ArrayList<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM usuario";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
//                usuario = new User(resultSet.getInt(1), resultSet.getInt(6), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(3), resultSet.getInt(2));
                usuario = new User();
                usuario.setId(resultSet.getInt(1));
                usuario.setName(resultSet.getString(3));
                usuario.setRating(resultSet.getInt(4));
                users.add(usuario);               
            }
            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;		
		
	}
	
}
