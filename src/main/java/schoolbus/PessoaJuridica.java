package schoolbus;

import schoolbus.compartilhado.InputUsuario;

import java.util.Objects;

public abstract class PessoaJuridica extends Pessoa {
    @InputUsuario(prompt = "Digite o nome fantasia da pessoa juridica: ")
    private String nomeFantasia;
    @InputUsuario(prompt = "Digite o numero de funcionarios da pessoa juridica: ")
    private int numeroDeFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nomeOficial, String cpfOrCnpj, String telefone,
                          Endereco endereco, String nomeFantasia, int numeroDeFuncionarios) {
        super(nomeOficial, cpfOrCnpj, telefone, endereco);
        this.nomeFantasia = Objects.requireNonNull(nomeFantasia, "O nome fantasia nao pode ser nulo!");
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCNPJ() {
        return getCpf_cnpj();
    }
}
