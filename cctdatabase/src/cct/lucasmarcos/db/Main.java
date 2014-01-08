package cct.lucasmarcos.db;

import cct.lucasmarcos.db.dao.EvaluationDAO;
import cct.lucasmarcos.db.dao.FriendDAO;
import cct.lucasmarcos.db.dao.ProductDAO;
import cct.lucasmarcos.db.dao.UserDAO;
import cct.lucasmarcos.db.dao.UserProductDAO;
import cct.lucasmarcos.db.model.User;

public class Main {
	
	public static void main(String[]args)
	{
		UserDAO userDAO = new UserDAO();
		ProductDAO productDAO = new ProductDAO();
		EvaluationDAO avaliacao = new EvaluationDAO();
		UserProductDAO userProductDAO = new UserProductDAO();
		FriendDAO friendDAO = new FriendDAO();
		
		User user = userDAO.getUser(1);
		
		friendDAO.getUserFriends(user);
		
//		Product product = productDAO.getProduct(1);
//		
//		userProductDAO.saveUserProduct(user, product);
//		
//		userProductDAO.removeUserProduct(user, product);
		
		
		
//		avaliacao.removeEvaluation(2);
		
		
//		Evaluation eval = new Evaluation();
//		eval.setDate("TODO");
//		eval.setDescription("UHU maluco beleza");
//		eval.setProduct(productDAO.getProduct(1));
//		eval.setUser(userDAO.getUser(2));
//		eval.setStars(8);
//		
//		avaliacao.saveEvaluation(eval);
		
//		Product product = productDAO.getProduct(1);
		
//		product.setName("Samsung S3");
		
//		productDAO.editProduct(product);
		
		int i =0;
		
		
		
		
		
	}

}
