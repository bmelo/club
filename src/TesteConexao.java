package v2;

import java.util.Calendar;
import java.util.Date;

public class TesteConexao {
	public static void main(String[] args) {
		Conexao c1 = Conexao.getInstancia();
		Conexao c2 = Conexao.getInstancia();
		Conexao c3 = Conexao.getInstancia();
		Conexao c4 = Conexao.getInstancia();
		Conexao c5 = Conexao.getInstancia();

		Calendar cal = Calendar.getInstance();

		int dia, mes, ano, hora, min;
		dia = cal.get(Calendar.DATE);
		mes = cal.get(Calendar.MONTH) + 1;
		ano = cal.get(Calendar.YEAR);
		hora = cal.get(Calendar.HOUR);
		min = cal.get(Calendar.MINUTE);

		System.out.println(new Date());
		System.out.println(dia + "/" + mes + "/" + ano + " " + hora + ":" + min);
	}
}
