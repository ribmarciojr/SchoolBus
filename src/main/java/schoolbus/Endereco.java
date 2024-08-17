package schoolbus;

import schoolbus.compartilhado.InputUsuario;

public class Endereco {
    @InputUsuario(prompt = "Digite a rua: ")
    private String rua;
    @InputUsuario(prompt = "Digite o numero: ")
    private String numero;
    @InputUsuario(prompt = "Digite o bairro: ")
    private String bairro;
    @InputUsuario(prompt = "Digite a cidade: ")
    private String cidade;
    @InputUsuario(prompt = "Digite o estado: ")
    private String estado;
    @InputUsuario(prompt = "Digite o complemento: ")
    private String complemento;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }
}
