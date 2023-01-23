package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
/**Modulo conexao**/ 
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
    	}
        catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
    //teste de conexao
    public void testeConexao() {
    	try {
    		Connection conexao = conectar();
    		System.out.println(conexao);
    		conexao.close();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
}
