import java.util.Objects;

public abstract class PessoaJuridica extends Pessoa {
    private String nomeFantasia;
    private int numeroDeFuncionarios;

    public PessoaJuridica(String nomeOficial, String cpf_cnpj, String telefone, Endereco endereco, String nomeFantasia, int numeroDeFuncionarios) {
        super(nomeOficial, cpf_cnpj, telefone, endereco);
        this.nomeFantasia = Objects.requireNonNull(nomeFantasia, "O nome fantasia nao pode ser nulo!");
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public String getNomeFantasia() { return nomeFantasia; }

    public String getCNPJ(){ return getCpf_cnpj(); }
}
