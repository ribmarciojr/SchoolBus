package schoolbus;

import schoolbus.compartilhado.InputUsuario;

public class CNH {
    @InputUsuario(prompt = "Digite o numero da CNH: ")
    private String numero;
    @InputUsuario(prompt = "Digite a categoria da CNH (A, B, C, D, E, AB): ")
    private CategoriaCNH categoria;

    public CNH() {
    }

    public CNH(String numero, CategoriaCNH categoria) {
        this.numero = numero;
        this.categoria = categoria;
    }
}
