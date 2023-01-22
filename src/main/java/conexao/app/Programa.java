package conexao.app;

import java.sql.Connection;

import conexao.Conexao;

public class Programa {

	public static void main(String[] args) {
		
		Connection conexao = Conexao.conexaoBancoMysql();
        Conexao.fecharConexao();
	}

}
