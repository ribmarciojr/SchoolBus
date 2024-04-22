import java.util.Objects;
import java.util.Date;
public abstract class Pessoa {
    private final String nomeCivil;
    private String nomeSocial;
    private final String cpf;
    private final String nomeDoPai;
    private final String nomeDaMae;
    private final String naturalidade;
    private String telefone;
    private Endereco endereco;
    private final Date dataDeNascimento;

    public Pessoa(String nomeCivil, String nomeSocial, String cpf, String nomeDoPai, String nomeDaMae, String naturalidade, String telefone, Endereco endereco, Date dataDeNascimento) {
        this.nomeCivil = Objects.requireNonNull(nomeCivil, "O nome civil nao pode ser nulo");
        this.nomeSocial = Objects.requireNonNull(nomeSocial, "O nome social nao pode ser nulo");
        if (nomeSocial.isBlank()) {
            this.nomeSocial = this.nomeCivil;
        }
        this.cpf = Objects.requireNonNull(cpf, "O CPF nao pode ser nulo");
        this.nomeDoPai = Objects.requireNonNull(nomeDoPai, "O nome do pai nao pode ser nulo");
        this.nomeDaMae = Objects.requireNonNull(nomeDaMae, "O nome da mae nao pode ser nulo");
        this.naturalidade = Objects.requireNonNull(naturalidade, "A naturalidade nao pode ser nula");
        this.telefone = Objects.requireNonNull(telefone, "O telefone nao pode ser nulo");
        this.endereco = Objects.requireNonNull(endereco, "O endereco nao pode ser nulo");
        this.dataDeNascimento = Objects.requireNonNull(dataDeNascimento, "A data de nascimento não pode ser nula");
    }
}
