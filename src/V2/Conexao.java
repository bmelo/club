package V2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static String usuario = "user";
    private static String senha = "pass";
    private static String url = "jdbc:postgresql://localhost:5432/poo2";
    private static Conexao instanciaUnica = null;
    private static Connection conexao = null;

    private Conexao() throws Exception {
        //System.err.println("vai criar a conexao");
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new Exception("Erro ao tentar conectar ao banco: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Erro ao tentar conectar (erro 2): " + e.getMessage());
        }
    }

    public synchronized static Conexao getInstancia() throws Exception {
        // verifica se existe o objeto instanciaUnica
        if (instanciaUnica == null) {
            try {
                instanciaUnica = new Conexao();
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        // verifica se a conexão com o banco está fechada
        try {
            if (conexao == null || conexao.isClosed()) {
                instanciaUnica = new Conexao();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return instanciaUnica;
    }

    public Connection getConnection() {
        return conexao;
    }
}
