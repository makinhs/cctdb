package cct.lucasmarcos.db.dao;

import cct.lucasmarcos.db.util.ConnectionDB;

import com.mysql.jdbc.Connection;

public class AbstractConnectionDAO {
	
	protected ConnectionDB con;
	protected Connection connection;
	
	public AbstractConnectionDAO() {
		// TODO Auto-generated constructor stub
		con = new ConnectionDB();
		connection = (Connection) con.getConnection();
	}
	

}
