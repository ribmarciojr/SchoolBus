package schoolbus;

import schoolbus.compartilhado.InputUsuario;

public abstract class Pessoa {
    @InputUsuario(prompt = "Digite o nome oficial: ")
    private String nomeOficial;
    @InputUsuario(prompt = "Digite o CPF ou CNPJ: ")
    private String cpf_cnpj;
    @InputUsuario(prompt = "Digite o telefone: ")
    private String telefone;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nomeOficial, String cpf_cnpj, String telefone, Endereco endereco) {
        this.nomeOficial = nomeOficial;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    protected String getNomeOficial() {
        return nomeOficial;
    }

    protected String getCpf_cnpj() {
        return cpf_cnpj;
    }
}
