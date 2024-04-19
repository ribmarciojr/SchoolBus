import java.util.Objects;

public class Escola {
    private String nome;
    private String cnpj;
    private String telefone;
    private Endereco endereco;

    public Escola(String nome, String cnpj, String telefone) {
        this.nome = Objects.requireNonNull(nome, "O nome da escola nao pode ser nulo");
        this.cnpj = Objects.requireNonNull(cnpj, "O CNPJ da escola nao pode ser nulo");
        this.telefone = Objects.requireNonNull(telefone, "O telefone da escola nao pode ser nulo");
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = Objects.requireNonNull(endereco, "O endereco da escola nao pode ser nulo");
    }
}
