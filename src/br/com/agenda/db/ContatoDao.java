package br.com.agenda.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.models.Contato;
import br.com.agenda.utils.ExceptionDao;

public class ContatoDao {
	private Connection connection;
	private String sql;
	
	public ContatoDao() {
		this.connection = new ConnectFactory().getConnection();
	}
	
	public void add(Contato contato) {
		sql = "insert into contatos (nome,email,endereco,dataNasc) values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, (Date) contato.getDataNasc());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getList(){
		try {
			List<Contato> contatos = new ArrayList<>();
			sql = "SELECT * FROM contatos";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				Contato contato = new Contato();
				
				contato.setId(res.getLong("id"));
				contato.setNome(res.getString("nome"));
				contato.setEmail(res.getString("email"));
				contato.setEndereco(res.getString("endereco"));
				contato.setDataNasc(res.getDate("DataNasc"));
				
				contatos.add(contato);
			}
			res.close();
			stmt.close();
			return contatos;
		}catch(SQLException e) {
			ExceptionDao.erro(e);
		}
		
		return null;
	}
	
	public List<Contato> getList(String busca){
		try {
			List<Contato> contatos = new ArrayList<>();
			sql = "SELECT * FROM contatos where nome like '"+busca+"%';";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				Contato contato = new Contato();
				
				contato.setId(res.getLong("id"));
				contato.setNome(res.getString("nome"));
				contato.setEmail(res.getString("email"));
				contato.setEndereco(res.getString("endereco"));
				contato.setDataNasc(res.getDate("DataNasc"));
				
				contatos.add(contato);
			}
			res.close();
			stmt.close();
			return contatos;
		}catch(SQLException e) {
			ExceptionDao.erro(e);
		}
		return null;
	}
	
	public Contato getContatoById(int id) {
		try {
			Contato contato = new Contato();
			sql = "SELECT * FROM contatos where id = '"+id+"';";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
		
			while(res.next()) {
				contato.setId(res.getLong("id"));
				contato.setNome(res.getString("nome"));
				contato.setEmail(res.getString("email"));
				contato.setEndereco(res.getString("endereco"));
				contato.setDataNasc(res.getDate("dataNasc"));
			}
			stmt.close();
			res.close();
			
			return contato;
		} catch (SQLException e) {
			ExceptionDao.erro(e);
		}
		return null;
	}
	
	public void remove(Contato contato, int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete " +
			"from contatos where id=?");
			stmt.setLong(id, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?," +
				"dataNasc=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, (Date) contato.getDataNasc());
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
