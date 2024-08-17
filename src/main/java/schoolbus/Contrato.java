package schoolbus;

import schoolbus.compartilhado.InputUsuario;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contrato {
    @InputUsuario(prompt = "Digite o numero do contrato: ")
    private String numContrato;
    @InputUsuario(prompt = "Digite a data de inicio do contrato: ")
    private LocalDate inicio;
    @InputUsuario(prompt = "Digite a data de fim do contrato: ")
    private LocalDate fim;
    @InputUsuario(prompt = "Digite o valor do contrato: ")
    private BigDecimal valor;
    private Fornecedor fornecedor;

    private final Set<Veiculo> veiculosAssociados = new HashSet<>();
    private final Set<Motorista> motoristasAssociados = new HashSet<>();

    public Contrato() {
    }

    public Contrato(String numContrato, LocalDate inicio, LocalDate fim, BigDecimal valor) {
        this.numContrato = numContrato;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
    }

    /**
     * @apiNote "Na classe schoolbus.Contrato, implemente os metodos para adicionar e remover veiculos associados
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
     * @apiNote "Na classe schoolbus.Contrato, implemente os metodos para adicionar e remover veiculos associados
     * ao contrato utilizando ArrayList. Apenas veiculos alugados podem ser adicionados ao contrato."
     * @see #associaVeiculo(Veiculo)
     */
    public boolean removeVeiculo(Veiculo veiculo) {
        return this.veiculosAssociados.remove(veiculo);
    }

    /**
     * @apiNote "Na classe schoolbus.Contrato, implemente os metodos para adicionar e remover motoristas
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
     * @apiNote "Na classe schoolbus.Contrato, implemente os metodos para adicionar e remover motoristas
     * associados ao contrato utilizando ArrayList. Apenas motoristas terceirizados podem ser adicionados ao contrato.
     * @see #associaMotorista(Motorista)
     */
    public boolean removeMotorista(Motorista motorista) {
        return this.motoristasAssociados.remove(motorista);
    }

    /**
     * @apiNote "Implemente um metodo polimorfico na classe schoolbus.Contrato para adicionar um schoolbus.Fornecedor ao contrato.
     * Este metodo deve ser capaz de aceitar qualquer objeto que herda de schoolbus.PessoaJuridica, contudo so deve ser possivel
     * criar contratos com o tipo schoolbus.Fornecedor. Caso a PJ seja diferente de schoolbus.Fornecedor o sistema deve
     * emitir uma mensagem de erro."
     */

    public void adicionaFornecedor(PessoaJuridica fornecedor) throws IOException {
        if (!(fornecedor instanceof Fornecedor)) {
            throw new IllegalStateException("Metodo invalido, o argumento precisa ser do tipo schoolbus.Fornecedor!");
        }
        this.fornecedor = (Fornecedor) fornecedor;
    }

    public String getNumContrato() {
        return this.numContrato;
    }

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
}
