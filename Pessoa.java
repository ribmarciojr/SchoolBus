import java.util.Objects;

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
        this.nomeSocial = nomeSocial;
        if (Objects.isNull(nomeSocial) || nomeSocial.isBlank()) {
            this.nomeSocial = nomeCivil;
        }
        this.cpf = cpf;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.naturalidade = naturalidade;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
