package V2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {

    public static boolean adicionar(Produto prod) throws Exception {
        if (prod == null) {
            throw new Exception("Informe os dados do produto!");
        }
        Connection con = Conexao.getInstancia().getConnection();
        try {
            String comandoSql = "INSERT INTO produtos (nome, valor, descricao) VALUES ('" + prod.getNome() + "', " + prod.getValor() +
                    ", '" + prod.getDesc() + "')";
            PreparedStatement ps = con.prepareStatement(comandoSql);
            // vai setar cada interrogatório do comando sql
            //ps.setString(1, prod.getNome());
            //ps.setDouble(3, prod.getValor());
            ps.execute();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static boolean remover(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Codigo invalido!");
        }
        Connection con = Conexao.getInstancia().getConnection();
        try {
            String comandoSql = "DELETE FROM produtos where id = " + id;
            PreparedStatement sta = con.prepareStatement(comandoSql);
//			sta.setInt(0, id);
            int x = sta.executeUpdate();
            if (x == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static boolean alterar(Produto prod) throws Exception {
        if (prod == null) {
            throw new Exception("Não foi possível atualizar:\n\rInforme os dados do produto");
        } else if (prod.getId() <= 0) {
            throw new Exception("Não foi possível encontrar o produto:\n\tID inválido");
        }
        Connection con = Conexao.getInstancia().getConnection();
        try {
            String comandoSql = "UPDATE produtos SET nome = '" + prod.getNome() + "', valor=" + prod.getValor() +
                    ", descricao='" + prod.getDesc() + "' WHERE id = " + prod.getId();
            PreparedStatement sta = con.prepareStatement(comandoSql);
//			sta.setString(1, prod.getNome());
//			sta.setInt(3, prod.getId());
            int x = sta.executeUpdate();
            if (x == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Produto pesquisar(String id) throws Exception {
        if (id == null) {
            throw new Exception("Não foi possível pesquisar pelo produto:\n\tInforme os dados para pesquisa");
        }
        Connection con = Conexao.getInstancia().getConnection();
        try {
            String comandoSql = "SELECT * FROM produtos WHERE id = " + id;
            Statement sta = con.createStatement();
            ResultSet resultado = sta.executeQuery(comandoSql);
            if (resultado.next()) {
                String nome = resultado.getString("nome");
                double valor = resultado.getDouble("valor");
                String desc = resultado.getString("descricao");
                Produto produto = new Produto(nome, valor, desc);
                produto.setId(Integer.parseInt(id));
                return produto;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return null;
    }

    public static List<Produto> listar() throws Exception {
        List<Produto> lista = new ArrayList<Produto>();
        try {
            Connection con = Conexao.getInstancia().getConnection();
            String comandoSql = "SELECT * FROM produtos ORDER BY nome ";
            Statement sta = con.createStatement();
            ResultSet resultado = sta.executeQuery(comandoSql);
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                double valor = resultado.getDouble("valor");
                String desc = resultado.getString("descricao");

                Produto produto = new Produto();
                produto.setId(id);
                produto.setNome(nome);
                produto.setValor(valor);
                produto.setDesc(desc);
                lista.add(produto);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }
}
