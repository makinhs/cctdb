package cct.lucasmarcos.db.dao;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import cct.lucasmarcos.db.model.UserEvaluation;

public class UserEvaluationDAO extends AbstractConnectionDAO{
	
	public UserEvaluationDAO() {
		super();
	}
	
	
	public boolean saveScore(UserEvaluation userEvaluation)
	{
		String sql = "INSERT INTO usuarioavaliacao (usuarioId, avaliacaoId, positivos, negativos) values (?,?,?,?)";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, userEvaluation.getUser().getId());
            stmt.setInt(2, userEvaluation.getEvaluationId());
            stmt.setInt(3, userEvaluation.getPositive());
            stmt.setInt(4, userEvaluation.getNegative());
            stmt.execute();
            stmt.close();   
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }	
	}
	
	public boolean editScore()
	{
		return false;
	}
	
	
	public boolean isDidScore()
	{
		return false;
	}

}
