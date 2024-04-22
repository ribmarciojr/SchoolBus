
public abstract class Pessoa {
    private String nomeCivil;
    private String nomeSocial;
    private String cpf;
    private String nomeDoPai;
    private String nomeDaMae;
    private String naturalidade;
    private String telefone;
    private Endereco endereco;

    public Pessoa(String nomeCivil, String nomeSocial, String cpf, String nomeDoPai,
        String nomeDaMae, String naturalidade, String telefone, Endereco endereco) {
        this.nomeCivil = nomeCivil;
        if (nomeSocial.isEmpty()) {
            this.nomeSocial = nomeCivil;
        } else {
            this.nomeSocial = nomeSocial;
        }
        this.cpf = cpf;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.naturalidade = naturalidade;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
