package v1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorClientes {


	public static void adicionar(){
		String cpf;
		String nome;
		cpf = JOptionPane.showInputDialog("Informe o CPF");
		nome = JOptionPane.showInputDialog("Informe o nome: ");
		Connection con = Conexao.pegarConexao();
		try {
			String comandoSql = "INSERT INTO clientes (nome, cpf, saldo) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(comandoSql);
			// vai setar cada interrogação do comando sql
			ps.setString(1,nome);
			ps.setString(2, cpf);
			ps.setDouble(3, 0);
			ps.execute();
			JOptionPane.showMessageDialog(null, "cliente cadastrado com sucesso!");
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente!");
		}
		// fechar a conexão
		try {
			con.close();
		} catch (Exception e){}
	}
	public static void remover(){
		String entrada;
		int id;
		entrada = JOptionPane.showInputDialog("Informe o código do cliente");
		Connection con = Conexao.pegarConexao();
		try {
			id = Integer.parseInt(entrada);
			String comandoSql = "DELETE FROM clientes where id = ?";
			PreparedStatement sta = con.prepareStatement(comandoSql);
			sta.setInt(1, id);
			int x = sta.executeUpdate();
			if (x == 1){
				JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não foi encontrado na base de dados!");
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Não foi possível remover o cliente");
		}
		// fechar a conexão
		try {
			con.close();
		} catch (Exception e){}
	}

	public static void alterar(){
		String entrada;
		int id;
		String nome;
		String cpf;
		entrada = JOptionPane.showInputDialog("Informe o código do cliente que vai ser alterado");
		id = Integer.parseInt(entrada);
		// verificar se o cliente existe
		// melhorar esse código na nova versão --> verificar se o cliente existe
		nome = JOptionPane.showInputDialog("Informe o novo nome");
		cpf = JOptionPane.showInputDialog("Informe o novo cpf");
		Connection con = Conexao.pegarConexao();
		try {
			String comandoSql = "UPDATE clientes SET nome = ?, cpf = ? WHERE id = ?";
			PreparedStatement sta = con.prepareStatement(comandoSql);
			sta.setString(1, nome);
			sta.setString(2, cpf);
			sta.setInt(3, id);
			int x = sta.executeUpdate();
			if (x == 1){
				JOptionPane.showMessageDialog(null, "Dados do cliente alterado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "O cliente não foi encontrado!");
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar a modificação");
		}
		// fechar conexão
		try {
			con.close();
		} catch (Exception e) {}
	}

	public static void listar(){
		Connection con = Conexao.pegarConexao();
		try {
			String comandoSql = "SELECT * FROM clientes ORDER BY nome ";
			Statement sta = con.createStatement();
			ResultSet resultado = sta.executeQuery(comandoSql);
			String saida = "";
			while (resultado.next()){
				int id = resultado.getInt("id");
				String n = resultado.getString("nome");
				String c = resultado.getString("cpf");
				double s = resultado.getDouble("saldo");
				saida += id + " | " + n + " | " + c + " | " + s + "\n";
			}
			JOptionPane.showMessageDialog(null, saida);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível listar os clientes");
		}
		// fechar conexão
		try {
			con.close();
		} catch (Exception e){
		}
	}

}
