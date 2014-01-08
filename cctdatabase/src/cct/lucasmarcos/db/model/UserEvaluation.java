package cct.lucasmarcos.db.model;

public class UserEvaluation {
	
	private User user = null;	
	private int positive = 0, negative = 0, evaluationId = 0;
	
	public UserEvaluation(User user, int evaluationId) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.evaluationId = evaluationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPositive() {
		return positive;
	}

	public void setPositive(int positive) {
		this.positive = positive;
	}

	public int getNegative() {
		return negative;
	}

	public void setNegative(int negative) {
		this.negative = negative;
	}

	public int getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}
	
	
	
	

}
