package br.edu.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private Connection connection = null;
	
	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meus_dados?serverTimezone=UTC", "theobr", "tbr1701");
		
	}
	
	public List<Pessoa> getLista() throws SQLException{
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoa");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getNString("nome"));
			pessoa.setIdade(rs.getInt("idade"));
			pessoas.add(pessoa);
		}
		
		rs.close();
		stmt.close();
		
		return pessoas;
	}
	
	public void adiciona(Pessoa pessoa) throws SQLException {
		
		String sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, pessoa.getNome());
		
		stmt.setInt(2,  pessoa.getIdade());
		
		stmt.execute();
		
		stmt.close();
	}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM pessoa WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void atualiza(Pessoa pessoa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE pessoa SET nome=?, idade=? WHERE id=?");
		stmt.setNString(1, pessoa.getNome());
		stmt.setInt(2, pessoa.getIdade());
		stmt.setInt(3, pessoa.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void close() throws SQLException {
		connection.close();
	}

}
