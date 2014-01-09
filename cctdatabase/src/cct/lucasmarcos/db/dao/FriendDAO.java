package cct.lucasmarcos.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cct.lucasmarcos.model.entity.User;

import com.mysql.jdbc.PreparedStatement;

public class FriendDAO extends AbstractConnectionDAO{
	public FriendDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public boolean saveFriend(User user, User friend)
	{
		String sql = "INSERT INTO amigo (usuarioId, usuarioAmigoId) values (?,?)";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());            
            stmt.setInt(2, friend.getId());            
            stmt.execute();
            stmt.close();   
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public int getIndexUserFriend(User user, User friend)
	{
		ResultSet resultSet;
        resultSet = null;        
        int result = 0;
        String sql = "SELECT amigo FROM usuarioproduto WHERE usuarioId = '" + user.getId() + "' and usuarioAmigoId = '" + friend.getId() + "'";
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
	
	public List<User> getUserFriends(User user)
	{
		ResultSet resultSet;
        resultSet = null;        
        ArrayList<User> friends = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        String sql = "SELECT usuarioAmigoId FROM amigo WHERE usuarioId = '" + user.getId() + "'";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = stmt.executeQuery(sql);
            
            while (resultSet.next()) {
            	friends.add(userDAO.getUser(resultSet.getInt(1)));
            	                    
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    
        
        return friends;		
	}
	
	public boolean removeFriend(User user, User friend)
	{
		String sql = "DELETE FROM amigo WHERE amigoId = '" + getIndexUserFriend(user, friend) + "'";

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
