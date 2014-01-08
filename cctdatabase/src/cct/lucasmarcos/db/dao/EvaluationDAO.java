package cct.lucasmarcos.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import cct.lucasmarcos.db.model.Evaluation;

public class EvaluationDAO extends AbstractConnectionDAO{
	
	public EvaluationDAO() {
		super();
	}
	
	public boolean saveEvaluation(Evaluation evaluation)
	{
		String sql = "INSERT INTO avaliacao (usuarioId, produtoId, descricao, estrelas, positivos, negativos, dataReview) values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);            
            stmt.setInt(1, evaluation.getUser().getId());
            stmt.setInt(2, evaluation.getProduct().getId());
            stmt.setString(3, evaluation.getDescription());
            stmt.setInt(4, evaluation.getStars());
            stmt.setInt(5, evaluation.getPositive());
            stmt.setInt(6, evaluation.getNegative());
            stmt.setString(7, evaluation.getDate());
            stmt.execute();
            stmt.close();   
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public Evaluation getEvaluation(Object evaluationId)
	{
		ResultSet resultSet;
        resultSet = null;
        Evaluation evaluation = null;
        UserDAO userDAO = new UserDAO();
        ProductDAO productDAO = new ProductDAO();
        	
        String sql = "SELECT * FROM avaliacao WHERE avaliacaoId = '" + evaluationId + "'";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                evaluation = new Evaluation();
                evaluation.setId(resultSet.getInt(1));
                evaluation.setUser(userDAO.getUser(resultSet.getInt(2)));
                evaluation.setProduct(productDAO.getProduct(resultSet.getInt(3)));
                evaluation.setDescription(resultSet.getString(4));
                evaluation.setStars(resultSet.getInt(5));
                evaluation.setPositive(resultSet.getInt(6));
                evaluation.setNegative(resultSet.getInt(7));
                evaluation.setDate(resultSet.getString(8));                
                stmt.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return evaluation;		
	}
	
	public boolean addPositiveEvaluation(Evaluation evaluation)
	{
		String sql = "UPDATE avaliacao SET positivos = ?, dataReview = ? WHERE avaliacaoId = '" + evaluation.getId() + "'";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);                       
            stmt.setInt(1, evaluation.getPositive()+1);
            stmt.setString(2, "TODO");
            stmt.execute();
            stmt.close();        
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }		
	}
	
	public boolean addNegativeEvaluation(Evaluation evaluation)
	{
		String sql = "UPDATE avaliacao SET negativos = ?, dataReview = ? WHERE avaliacaoId = '" + evaluation.getId() + "'";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);                       
            stmt.setInt(1, evaluation.getNegative()+1);
            stmt.setString(2, "TODO");
            stmt.execute();
            stmt.close();        
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }		
	}
	
	public boolean editEvaluation(Evaluation evaluation)
	{
		
		String sql = "UPDATE avaliacao SET descricao = ?, estrelas = ?, dataReview = ? WHERE avaliacaoId = '" + evaluation.getId() + "'";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);           
            stmt.setString(1, evaluation.getDescription());
            stmt.setInt(2, evaluation.getStars());
            stmt.setString(3, "TODO");
            stmt.execute();
            stmt.close();        
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }		
	}
	
	public boolean removeEvaluation(Object evaluationId)
	{		

        String sql = "DELETE FROM avaliacao WHERE avaliacaoId = '" + evaluationId + "'";

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
