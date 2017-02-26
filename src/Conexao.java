package v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String usuario = "user";
	private static String senha = "pass";
	private static String url = "jdbc:postgresql://localhost:5432/poo2";

	public static Connection pegarConexao(){
		Connection conexao = null;
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e){
			System.err.println("Erro ao tentar conectar ao banco: " + e.getMessage());
		} catch (Exception e){
			System.err.println("Erro ao tentar conectar (erro 2): " + e.getMessage());
		}
		return conexao;
	}

	public static void main(String args[]){
		System.out.println(  pegarConexao()  );
	}
}
