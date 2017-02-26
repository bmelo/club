package v2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
	private static String usuario = "user";
	private static String senha = "pass";
	private static String url = "jdbc:postgresql://localhost:5432/poo2";
	private static Conexao instanciaUnica = null;
	private static Connection conexao = null;

	private Conexao(){
		System.err.println("vai criar a conexão");
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e){
			System.err.println("Erro ao tentar conectar ao banco: " + e.getMessage());
		} catch (Exception e){
			System.err.println("Erro ao tentar conectar (erro 2): " + e.getMessage());
		}
	}
	public synchronized static Conexao getInstancia(){
		// verifica se existe o objeto instanciaUnica
		if (instanciaUnica == null){
			instanciaUnica = new Conexao();
		}
		// vou verificar se a conexão com o banco está fechada
		try {
			if (conexao == null || conexao.isClosed()){
				instanciaUnica = new Conexao();
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		return instanciaUnica;
	}
	public Connection getConnection(){
		return conexao;
	}
}
