package V2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorSocios {

    public static boolean adicionar(Socio socio) throws Exception {
        if (socio == null) {
            throw new Exception("Informe os dados do sócio!");
        }
        try {
            String comandoSql = "INSERT INTO socios (nome, cpf, saldo,endereco,bairro,cep,cidade,uf) VALUES ('" + socio.getNome() +
                    "', '" + socio.getCpf() + "', " + socio.getSaldo() + ", '" + socio.getEnder() + "', '" +
                    socio.getBairro() + "', '" + socio.getCep() + "', '" + socio.getCidade() + "', '" + socio.getUf() + "')";
            int x = executarComando(comandoSql);
            ResultSet resultado = executarComandoSel("SELECT max(id) AS id FROM socios");
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String[] dep = socio.getDependentes();
                for (String dependente : dep) {
                    if (dependente != null && !(dependente.equals(""))) {
                        executarComando("INSERT INTO socios_dependentes(id_socio,nome) VALUES (" + id + ",'" + dependente + "')");
                    }
                }
            }
            if (x == 1) {
                return true;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }

    public static boolean remover(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido!");
        }
        try {
            String comandoSql = "DELETE FROM socios where id = " + id;
            int x = executarComando(comandoSql);
            //Exclusão dos Dependentes
            comandoSql = "DELETE FROM socios_dependentes where id_socio = " + id;
            x += executarComando(comandoSql);
            if (x >= 1) {
                return true;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }

    public static boolean alterar(Socio socio) throws Exception {
        if (socio == null) {
            throw new Exception("Não foi possível atualizar:\n\tInforme os dados do sócio");
        } else if (socio.getId() <= 0) {
            throw new Exception("Não foi possível encontrar o sócio:\n\tCódigo inválido)");
        }
        try {
            String comandoSql = "UPDATE socios SET nome = '" + socio.getNome() + "', cpf = '" + socio.getCpf() + "', saldo=" + socio.getSaldo() +
                    ", endereco='" + socio.getEnder() + "', bairro='" + socio.getBairro() + "', cep='" + socio.getCep() + "', cidade='" + socio.getCidade() +
                    "', uf='" + socio.getUf() + "' WHERE id = " + socio.getId();
            int x = executarComando(comandoSql);
            //Limpa os nomes dos dependentes
            String comandoSqlLimpa = "UPDATE socios_dependentes SET nome='' WHERE id_socio=" + socio.getId();
            x += executarComando(comandoSqlLimpa);
            String[] dependentes = socio.getDependentes();
            // Atualiza os dependentes
            List<Integer> ids = getIdDependentes(socio.getId());
            int i = 0;
            for (String dep : dependentes) {
                if (dep != null && !(dep.equals(""))) {
                    String comandoSqlDep = null;
                    if (ids.size() > i) {
                        comandoSqlDep = "UPDATE socios_dependentes SET nome='" + dep + "' WHERE id=" + ids.get(i);
                    } else {
                        comandoSqlDep = "INSERT INTO socios_dependentes(id_socio,nome) VALUES (" + socio.getId() + ",'" + dep + "')";
                    }
                    executarComando(comandoSqlDep);
                    i++;
                }
            }
            executarComando("DELETE FROM socios_dependentes WHERE nome=''");
            if (x > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }

    private static String preencheZero(String texto, int tamRes) {
        int tam = texto.length();
        int quantZero = tamRes - tam;
        for (int i = 0; i < quantZero; i++) {
            texto = "0" + texto;
        }
        return texto;
    }

    public static Socio pesquisar(String cpf) throws Exception {
        if (cpf == null || cpf.trim().length() == 0) {
            throw new Exception("Não foi possível pesquisar pelo sócio:\n\t* Informe os dados da pesquisa");
        }
        cpf = GerenciadorSocios.preencheZero(cpf, 11);
        try {
            String comandoSql = "SELECT * FROM socios WHERE cpf = '" + cpf + "'";
            ResultSet resultado = executarComandoSel(comandoSql);
            if (resultado.next()) {
                int id = resultado.getInt("id");
                //Criando o objeto Socio
                Socio socio = new Socio();
                socio.setId(id);
                socio.setNome(resultado.getString("nome"));
                socio.setCpf(resultado.getString("cpf"));
                socio.setSaldo(resultado.getDouble("saldo"));
                socio.setEnder(resultado.getString("endereco"));
                socio.setBairro(resultado.getString("bairro"));
                socio.setCep(resultado.getString("cep"));
                socio.setCidade(resultado.getString("cidade"));
                socio.setUf(resultado.getString("uf"));
                List<String> dependentes = pesquisarDependentes(id);
                for (String dep : dependentes) {
                    socio.addDependentes(dep);
                }
                return socio;
            }
        } catch (Exception e) {
            throw new Exception(e);//e.getMessage());//printStackTrace();
        }
        return null;
    }

    public static List<Socio> listar() throws Exception {
        List<Socio> lista = new ArrayList<Socio>();
        try {
            String comandoSql = "SELECT * FROM socios ORDER BY nome ";
            ResultSet resultado = executarComandoSel(comandoSql);
            while (resultado.next()) {
                int id = resultado.getInt("id");
                Socio socio = new Socio();
                socio.setId(id);
                socio.setCpf(resultado.getString("cpf"));
                socio.setNome(resultado.getString("nome"));
                socio.setSaldo(resultado.getDouble("saldo"));
                socio.setEnder(resultado.getString("endereco"));
                socio.setBairro(resultado.getString("bairro"));
                socio.setCep(resultado.getString("cpf"));
                socio.setCidade(resultado.getString("cidade"));
                socio.setUf(resultado.getString("uf"));
                lista.add(socio);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }

    private static List<String> pesquisarDependentes(int id) throws Exception {
        List<String> dependentes = new ArrayList<String>();
        try {
            String comandoSql = "SELECT nome FROM socios_dependentes WHERE id_socio = " + id;
            ResultSet resultado = executarComandoSel(comandoSql);
            while (resultado.next()) {
                dependentes.add(resultado.getString("nome"));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return dependentes;
    }

    private static List<Integer> getIdDependentes(int id) throws Exception {
        List<Integer> idDependentes = new ArrayList<Integer>();
        try {
            String comandoSql = "SELECT id FROM socios_dependentes WHERE id_socio = " + id;
            ResultSet resultado = executarComandoSel(comandoSql);
            while (resultado.next()) {
                idDependentes.add(resultado.getInt("id"));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return idDependentes;
    }

    private static ResultSet executarComandoSel(String sql) throws Exception {
        sql = sql.trim();
        Connection con = Conexao.getInstancia().getConnection();
        try {
            Statement sta = con.createStatement();
            return sta.executeQuery(sql);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static int executarComando(String sql) throws Exception {
        sql = sql.trim();
        Connection con = Conexao.getInstancia().getConnection();
        try {
            PreparedStatement sta = con.prepareStatement(sql);
            if (sql.startsWith("INSERT")) {
                sta.execute();
                return 1;
            } else {
                return sta.executeUpdate();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
