
public class Motorista extends Pessoa {
    private CNH cnh;
    private TipoDeContrato tipoDeContrato;
    private String numeroDeContrato;

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
        Motorista motorista = new Motorista(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae,
            naturalidade, telefone, endereco, numeroCNH, categoriaCNH);
        motorista.tipoDeContrato = TipoDeContrato.TERCEIRIZADO;
        motorista.numeroDeContrato = numeroDeContrato;
        return motorista;
    }

    public static Motorista novoMotoristaSecretaria(String nomeCivil, String nomeSocial, String cpf,
        String nomeDoPai, String nomeDaMae, String naturalidade, String telefone, Endereco endereco,
        String numeroCNH, CategoriaCNH categoriaCNH) {
        Motorista motorista = new Motorista(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae,
            naturalidade, telefone, endereco, numeroCNH, categoriaCNH);
        motorista.tipoDeContrato = TipoDeContrato.SECRETARIA;
        return motorista;
    }
}
