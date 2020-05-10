package br.com.agenda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class ConnectFactory {
	
	public String db = "web";
	public String ip = "127.0.0.1";
	public String user = "root";
	public String password = "";
	public String port = "3308";
	
	public String url = "jdbc:mysql://"+ip+":"+port+"/"+db+"?useTimezone=true&serverTimezone=UTC";
	
	public Connection getConnection() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}		
}
