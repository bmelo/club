package v2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorClientes {
	public static boolean adicionar(Cliente c) throws Exception {
		if (c == null){
			throw new Exception ("Informe os dados do cliente!");
		}
		Connection con = Conexao.getInstancia().getConnection();
		try {
			String comandoSql = "INSERT INTO clientes (nome, cpf, saldo) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(comandoSql);
			// vai setar cada interrogação do comando sql
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCpf());
			ps.setDouble(3, 0);
			ps.execute();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean remover(int id) throws Exception{
		if (id <= 0){
			throw new Exception ("Código inválido!");
		}
		Connection con = Conexao.getInstancia().getConnection();
		try {
			String comandoSql = "DELETE FROM clientes where id = ?";
			PreparedStatement sta = con.prepareStatement(comandoSql);
			sta.setInt(1, id);
			int x = sta.executeUpdate();
			if (x == 1){
				return true;
			} else {
				return false;
			}
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static boolean alterar(Cliente c) throws Exception {
		if (c == null){
			throw new Exception ("Não foi possível atualizar: informe os dados do cleinte");
		} else if (c.getId() <= 0){
			throw new Exception ("Não foi possível encontrar o cliente (código inválido)");
		}
		Connection con = Conexao.getInstancia().getConnection();
		try {
			String comandoSql = "UPDATE clientes SET nome = ?, cpf = ? WHERE id = ?";
			PreparedStatement sta = con.prepareStatement(comandoSql);
			sta.setString(1, c.getNome());
			sta.setString(2, c.getCpf());
			sta.setInt(3, c.getId());
			int x = sta.executeUpdate();
			if (x == 1){
				return true;
			} else {
				return false;
			}
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static List<Cliente> listar(){
		Connection con = Conexao.getInstancia().getConnection();

		List<Cliente> lista = new ArrayList<Cliente>();

		try {
			String comandoSql = "SELECT * FROM clientes ORDER BY nome ";
			Statement sta = con.createStatement();
			ResultSet resultado = sta.executeQuery(comandoSql);
			while (resultado.next()){
				int id = resultado.getInt("id");
				String n = resultado.getString("nome");
				String c = resultado.getString("cpf");
				double s = resultado.getDouble("saldo");

				Cliente cliente = new Cliente();
				cliente.setId(id);
				cliente.setNome(n);
				cliente.setCpf(c);
				cliente.setSaldo(s);
				lista.add(cliente);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}

	public static void main(String args[]){
		List<Cliente> lista = listar();
		String saida = "";
		for (Cliente c : lista){
			saida += c.getNome() + "-" + c.getCpf() + "\n";
		}
		System.out.println(saida);
		saida = "";
		System.out.println(" outra forma de listar ................");
		for (int i=0; i<lista.size(); i++){
			saida += lista.get(i).getNome() + "-" + lista.get(i).getCpf() + "\n";
		}
		System.out.println(saida);

	}

}
