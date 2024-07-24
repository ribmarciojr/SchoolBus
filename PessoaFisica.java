import java.time.LocalDate;
import java.util.Objects;

public abstract class PessoaFisica extends Pessoa{
    private String nomeSocial;
    private final String nomeDoPai;
    private final String nomeDaMae;
    private final String naturalidade;
    private final LocalDate dataDeNascimento;

    public PessoaFisica(String nomeOficial, String nomeSocial, String cpf, String nomeDoPai, String nomeDaMae,
                        String naturalidade, LocalDate dataDeNascimento, String telefone, Endereco endereco) {
        super(nomeOficial, cpf, telefone, endereco);
        this.nomeSocial = Objects.requireNonNull(nomeSocial, "O nome social nao pode ser nulo!");
        if (nomeSocial.isBlank()) {
            this.nomeSocial = nomeOficial;
        }
        this.nomeDaMae = Objects.requireNonNull(nomeDaMae, "O nome da mae nao pode ser nulo!");
        this.naturalidade = Objects.requireNonNull(naturalidade, "A naturalidade nao pode ser nula!");
        this.dataDeNascimento = Objects.requireNonNull(dataDeNascimento, "A data de nascimento nao pode ser nula!");
        this.nomeDoPai = Objects.requireNonNull(nomeDoPai, "O nome do pai nao pode ser nulo!");
    }

    public String getNomeCivil() { return getNomeOficial();}

    public String getNomeSocial() { return nomeSocial;}

    public String getCpf() { return getCpf_cnpj();}

}
