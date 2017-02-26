package v1;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {

		String mensagem = "Escolha uma opçao: \n";
		mensagem += "1 - Cadastrar cliente\n";
		mensagem += "2 - Remover cliente\n";
		mensagem += "3 - Alterar cliente\n";
		mensagem += "4 - Listar clientes\n";
		mensagem += "5 - Sair\n";

		int opcao = 0;
		do {
			String entrada = JOptionPane.showInputDialog(mensagem);
			try {
				opcao = Integer.parseInt(entrada);
			} catch (Exception e) {
				opcao = 20;
			}
			switch (opcao) {
			case 1:
				GerenciadorClientes.adicionar();
				break;
			case 2:
				GerenciadorClientes.remover();
				break;
			case 3:
				GerenciadorClientes.alterar();
				break;
			case 4:
				GerenciadorClientes.listar();
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Sistema encerrado!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "opção inválida!");
			}
		} while (opcao != 5);
	}

}
