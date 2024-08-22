import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Contrato {
    private final String numContrato;
    private final LocalDate inicio;
    private final LocalDate fim;
    private final BigDecimal valor;
    private Fornecedor fornecedor;

    private Set<Veiculo> veiculosAssociados = new HashSet<>();
    private Set<Motorista> motoristasAssociados = new HashSet<>();

    public Contrato(String numContrato, LocalDate inicio, LocalDate fim, BigDecimal valor) {
        this.numContrato = Objects.requireNonNull(numContrato, "Numero do contrato nao pode ser nulo!");
        this.inicio = Objects.requireNonNull(inicio, "Data de inicio nao pode ser nula!");
        this.fim = Objects.requireNonNull(fim, "Data de fim nao pode ser nula!");
        this.valor = Objects.requireNonNull(valor, "Valor nao pode ser nulo!");
    }

    /**
     * @apiNote "Na classe Contrato, implemente os metodos para adicionar e remover veiculos associados
     * ao contrato utilizando ArrayList. Apenas veiculos alugados podem ser adicionados ao contrato."
     * @see #removeVeiculo(Veiculo)
     */
    public boolean associaVeiculo(Veiculo veiculo) {
        if (Objects.isNull(veiculo) || veiculo.tipo() != TipoVeiculo.ALUGADO) {
            return false;
        }
        return this.veiculosAssociados.add(veiculo);
    }

    /**
     * @apiNote "Na classe Contrato, implemente os metodos para adicionar e remover veiculos associados
     * ao contrato utilizando ArrayList. Apenas veiculos alugados podem ser adicionados ao contrato."
     * @see #associaVeiculo(Veiculo)
     */
    public boolean removeVeiculo(Veiculo veiculo) {
        return this.veiculosAssociados.remove(veiculo);
    }

    /**
     * @apiNote "Na classe Contrato, implemente os metodos para adicionar e remover motoristas
     * associados ao contrato utilizando ArrayList. Apenas motoristas terceirizados podem ser adicionados ao contrato.
     * @see #removeMotorista(Motorista)
     */
    public boolean associaMotorista(Motorista motorista) {
        if (Objects.isNull(motorista) || motorista.contrato() != TipoDeContrato.TERCEIRIZADO) {
            return false;
        }
        return this.motoristasAssociados.add(motorista);
    }

    /**
     * @apiNote "Na classe Contrato, implemente os metodos para adicionar e remover motoristas
     * associados ao contrato utilizando ArrayList. Apenas motoristas terceirizados podem ser adicionados ao contrato.
     * @see #associaMotorista(Motorista)
     */
    public boolean removeMotorista(Motorista motorista) {
        return this.motoristasAssociados.remove(motorista);
    }

    /**
     * @apiNote "Implemente um metodo polimorfico na classe Contrato para adicionar um Fornecedor ao contrato.
     * Este metodo deve ser capaz de aceitar qualquer objeto que herda de PessoaJuridica, contudo so deve ser possivel
     * criar contratos com o tipo Fornecedor. Caso a PJ seja diferente de Fornecedor o sistema deve
     * emitir uma mensagem de erro."
     */

    public void adicionaFornecedor(PessoaJuridica fornecedor) throws IOException {
            if (!(fornecedor instanceof Fornecedor)) {
                throw new IllegalStateException("Metodo invalido, o argumento precisa ser do tipo Fornecedor!");
            }
            this.fornecedor = (Fornecedor) fornecedor;
    }

    public String getNumContrato(){
        return this.numContrato;
    }

    public Fornecedor getFornecedor() { return this.fornecedor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(numContrato, contrato.numContrato) && Objects.equals(inicio, contrato.inicio) && Objects.equals(fim, contrato.fim) && Objects.equals(valor, contrato.valor) && Objects.equals(fornecedor, contrato.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numContrato, inicio, fim, valor, fornecedor);
    }

    @Override
    public String toString() {
        return "{" +
                "numContrato='" + numContrato + '\'' +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", valor=" + valor +
                '}';
    }
}
