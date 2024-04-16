import java.io.IOException;

public class Motorista extends Pessoa {
    private CNH cnh;
    private TipoDeContrato tipoDeContrato;
    private String numeroDeContrato = "";

    private Motorista(String nomeCivil, String nomeSocial, String cpf, String nomeDoPai,
                      String nomeDaMae, String naturalidade, String telefone, Endereco endereco, String numeroCNH,
                      CategoriaCNH categoriaCNH) {
        super(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, telefone, endereco);
        this.cnh = new CNH(numeroCNH, categoriaCNH);
    }

    /**
     * @apiNote "Em sendo terceirizado, o motorista também deve estar ligado a um contrato."
     */
    public static Motorista novoMotoristaTerceirizado(String nomeCivil, String nomeSocial,
                                                      String cpf, String nomeDoPai, String nomeDaMae, String naturalidade, String telefone,
                                                      Endereco endereco, String numeroDeContrato, String numeroCNH, CategoriaCNH categoriaCNH) {
        Motorista m = new Motorista(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, telefone, endereco, numeroCNH, categoriaCNH);
        m.tipoDeContrato = TipoDeContrato.TERCEIRIZADO;
        m.numeroDeContrato = numeroDeContrato;
        return m;
    }

    public static Motorista novoMotoristaSecretaria(String nomeCivil, String nomeSocial, String cpf,
                                                    String nomeDoPai, String nomeDaMae, String naturalidade, String telefone, Endereco endereco,
                                                    String numeroCNH, CategoriaCNH categoriaCNH) {
        Motorista m = new Motorista(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, telefone, endereco, numeroCNH, categoriaCNH);
        m.tipoDeContrato = TipoDeContrato.SECRETARIA;
        return m;
    }

    /**
     * @apiNote "Escreva um método que verifique se o motorista é servidor ou terceirizado."
     */
    public TipoDeContrato contrato() {
        return tipoDeContrato;
    }

    public void setNumeroDeContrato(String numeroDeContrato) throws IOException {
        if (this.tipoDeContrato == TipoDeContrato.SECRETARIA) {
            throw new IllegalArgumentException("Método inválido: o motorista deve ser terceirizado para estar associado a um contrato!");
        }
        this.numeroDeContrato = numeroDeContrato;
    }
}
