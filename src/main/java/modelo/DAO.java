package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	/** Modulo conexao **/
//parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda";
	private String user = "novo";
	private String password = "dF7* Pm *2r";

//Método de conexão
	private Connection conectar() {
		Connection conexao = null;
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD CREATE
	public void inserirDados(JavaBeans contato) {
		String create = "insert into contatos (nome,fone, email) values (?,?,?)";

		try {
			// abrir conexao
			Connection conexao = conectar();
			// Prepara a query para execução no banco de dados
			PreparedStatement ps = conexao.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das ?
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getFone());
			ps.setString(3, contato.getEmail());
			// Executar a query
			ps.executeUpdate();
			// Encerrar a conexao
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// teste de conexao
	/*
	 * public void testeConexao() { try { Connection conexao = conectar();
	 * System.out.println(conexao); conexao.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */
}
