package V2;

public class Produto {

    private int id;
    private String nome,  descricao;
    private double valor;

    public Produto() {
    }

    public Produto(String nome, double valor, String descricao) throws Exception{
        if(nome.trim().length()<=0){
            throw new Exception("Erro: Produto sem nome.");
        }            
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return this.descricao;
    }

    public void setDesc(String descricao) {
        this.descricao = descricao;
    }
}
