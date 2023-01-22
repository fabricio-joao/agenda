package conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexao {

	private static Connection conexao = null;
	
	public static Connection conexaoBancoMysql() {
		if(conexao != null) {
			try {
				Properties properties = carregarPropriedades();
				String url = properties.getProperty("url");
				conexao = DriverManager.getConnection(url, properties);
			}
			catch (SQLException e) {
				throw new ExcecaoBancoDados(e.getMessage());
			}
		}
		
		return conexao;
	}
	
	public static void fecharConexao() {
		if(conexao != null) {
			try {
				conexao.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void fecharStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ResultSet(java.sql.ResultSet rs){
		if(rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Properties carregarPropriedades() {
		try(FileInputStream fs = new FileInputStream("bd.propriedades")){
			Properties properties = new Properties();
			properties.load(fs);
			return properties;
		}
		catch (IOException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
	}
}
