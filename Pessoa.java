import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    private final String nomeOficial;
    private final String cpf_cnpj;
    private final String telefone;
    private final Endereco endereco;


    public Pessoa(String nomeOficial, String cpf_cnpj, String telefone, Endereco endereco) {
        this.nomeOficial = Objects.requireNonNull(nomeOficial, "O nome oficial nao pode ser nulo!");
        this.cpf_cnpj = Objects.requireNonNull(cpf_cnpj, "O CPF ou CNPJ nao pode ser nulo!");
        this.telefone = Objects.requireNonNull(telefone, "O telefone nao pode ser nulo!");
        this.endereco = Objects.requireNonNull(endereco, "O endereco nao pode ser nulo!");
    }

    protected String getNomeOficial() {
        return nomeOficial;
    }

    protected String getCpf_cnpj() {
        return cpf_cnpj;
    }
}
