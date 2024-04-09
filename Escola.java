public class Escola {
    private String nome;
    private String cnpj;
    private Administracao administracao;
    private DadosDeContato dadosDeContato;
    
    public Escola(String nome, String cnpj, Administracao administracao, DadosDeContato dadosDeContato) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.administracao = administracao;
        this.dadosDeContato = dadosDeContato;
    }
}
