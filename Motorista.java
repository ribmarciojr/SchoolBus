import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Motorista extends PessoaFisica {
    private CNH cnh;
    private TipoDeContrato tipoDeContrato;
    private Set<Contrato> contratos;

    private Motorista(String nomeCivil, String nomeSocial, String cpf, String nomeDoPai,
            String nomeDaMae, String naturalidade, LocalDate dataDeNascimento, String telefone, Endereco endereco,
            String numeroCNH, CategoriaCNH categoriaCNH) {
        super(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, dataDeNascimento, telefone, endereco);
        this.cnh = new CNH(numeroCNH, categoriaCNH);
    }

    /**
     * @apiNote "Em sendo terceirizado, o motorista também deve estar ligado a um
     *          contrato."
     */
    public static Motorista novoMotoristaTerceirizado(String nomeCivil, String nomeSocial, String cpf,
            String nomeDoPai, String nomeDaMae, String naturalidade, LocalDate dataDeNascimento,
            String telefone, Endereco endereco, Contrato contrato,
            String numeroCNH, CategoriaCNH categoriaCNH) {
        Motorista m = new Motorista(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, dataDeNascimento, telefone, endereco,
                numeroCNH, categoriaCNH);
        m.tipoDeContrato = TipoDeContrato.TERCEIRIZADO;
        m.contratos = new HashSet<>();
        m.contratos.add(Objects.requireNonNull(contrato, "Contrato nao pode ser nulo!"));
        return m;
    }

    public static Motorista novoMotoristaSecretaria(String nomeCivil, String nomeSocial, String cpf,
            String nomeDoPai, String nomeDaMae, String naturalidade, LocalDate dataDeNascimento,
            String telefone, Endereco endereco, String numeroCNH, CategoriaCNH categoriaCNH) {
        Motorista m = new Motorista(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, dataDeNascimento, telefone, endereco,
                numeroCNH, categoriaCNH);
        m.tipoDeContrato = TipoDeContrato.SECRETARIA;
        return m;
    }

    /**
     * @apiNote "Escreva um método que verifique se o motorista é servidor ou
     *          terceirizado."
     */
    public TipoDeContrato contrato() {
        return tipoDeContrato;
    }

    public boolean addContrato(Contrato contrato) throws IOException {
        if (tipoDeContrato == TipoDeContrato.SECRETARIA) {
                     throw new IllegalArgumentException(
                             "Metodo invalido: o motorista deve ser terceirizado para ser associado a um contrato!");
        }
                 return contratos.add(contrato);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(cnh, motorista.cnh) && tipoDeContrato == motorista.tipoDeContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnh, tipoDeContrato);
    }
}
