package br.com.agenda.utils;

import java.sql.SQLException;

public class ExceptionDao extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static String msg;
	
	public static String erro(SQLException e) {
		msg = "Ocorreu um erro durante em relação ao banco de dados: "+e;
		System.err.print(msg);
		
		return msg;
	}
	
}
