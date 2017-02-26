package V2;

public class Socio {

    private int id,totalDep;
    private String nome,cpf,ender,bairro,cep,cidade,uf;
    int cpfDig1,cpfDig2;
    private double saldo;
    private String[] dependentes;

    public Socio() {
        this.dependentes = new String[5];
        this.totalDep = 0;
    }

    public Socio(String nome, String cpf, double saldo, String ender, String bairro, String cep, String cidade, String uf) throws Exception {
        this.nome = nome;
        try{
            this.trataCpf(cpf);
        }catch(Exception e){
            throw e;
        }
        this.saldo = saldo;
        this.ender = ender;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        // Cria espaço para dependentes
        this.dependentes = new String[5];
        this.totalDep = 0;
        
    }
    
    private void trataCpf(String cpf) throws Exception{
        this.cpf = cpf.trim().replace(".", "").replace("-","").replace(" ",""); //Limpa o cpf e retira '.' e '-'
        this.completaCpf(11);
        this.cpfDig1 = Integer.parseInt(this.cpf.substring(9,10));
        this.cpfDig2 = Integer.parseInt(this.cpf.substring(10,11));
        if(!this.cpfValido()){
            throw new Exception("O CPF '"+this.cpf+"' é inválido!");
        }
    }
    
    private void completaCpf(int tamRes){
        int tam = this.cpf.length();
        int quantZero = tamRes-tam;
        for(int i=0; i<quantZero; i++){
            this.cpf = "0"+this.cpf;
        }
    }
    
    private Boolean cpfValido() {
        if (this.cpfCorreto ()){
            if(this.calcDig1() == this.cpfDig1) {
                if (this.calcDig2() == this.cpfDig2) {                    
                    return true;
                }
            }
        }
        return false;
    }

    //Verifica a validade do cpf, indicando como inválido cpf's que possuem
    //todos os digitos repetidos. Ex.: 111.111.111-11 é inválido.
    private Boolean cpfCorreto () {
        int i;
        String digInicial = this.cpf.substring(0,1);
        Boolean valido = false;

        for (i = 1; i < 9; i++){
            if (!digInicial.equals(this.cpf.substring(i,i + 1))) {
                valido = true;
            }
        }
        return valido;
    }

    private int calcDig1 () {
        int i, resto, dig, soma = 0;

        for (i = 0; i < 9; i++) {
            soma += ((Integer.parseInt(this.cpf.substring(i,i + 1))) * (i + 1));
        }

        resto = soma % 11;
        if (resto == 10) {
            dig = 0;
        } else {
            dig = resto;
        }
        return dig;
    }

    private int calcDig2 () {
        int i, resto, dig, soma = 0;

        for (i = 0; i < 9; i++) {
            soma += ((Integer.parseInt(this.cpf.substring(i,i + 1))) * (12 - (i + 1)));
        }

        soma += this.calcDig1 () * 2;
        soma *= 10;
        resto = soma % 11;
        if (resto == 10) {
            dig = 0;
        } else {
            dig = resto;
        }
        return dig;
    }

    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) throws Exception{
        try{
            this.trataCpf(cpf);
        }catch(Exception e){
            throw e;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) throws Exception{
        if(saldo<0){
            throw new Exception("Saldo insuficiente para transação!");
        }
        this.saldo = saldo;
            
    }
    
   public String getEnder() {
        return this.ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }
    
    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void limpaDependentes(){
        for(int i=0; i<5; i++)
            this.dependentes[i] = null;
        this.totalDep = 0;
    }
    
    public boolean addDependentes(String nome) {
        if (this.totalDep < 5) {
            this.dependentes[this.totalDep] = nome;
            this.totalDep++;
            return true;
        }
        return false;
    }

    public String[] getDependentes() {
        return this.dependentes;
    }
}
