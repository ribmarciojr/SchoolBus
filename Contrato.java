import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contrato {
    private String numContrato;
    private LocalDate inicio;
    private LocalDate fim;
    private BigDecimal valor;

    // TODO: lidar com possiveis repeticoes, usando Set<> ou outros metodos
    private List<Veiculo> veiculosAssociados = new ArrayList<>();
    private List<Motorista> motoristasAssociados = new ArrayList<>();

    public Contrato(String numContrato, LocalDate inicio, LocalDate fim, BigDecimal valor) {
        this.numContrato = numContrato;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
    }

    /**
     * @apiNote "Na classe Contrato, implemente os métodos para adicionar e remover veículos associados
     * ao contrato utilizando ArrayList. Apenas veículos alugados podem ser adicionados ao contrato."
     * @see #removeVeiculo(Veiculo)
     */
    public boolean associaVeiculo(Veiculo veiculo) {
        if (Objects.isNull(veiculo) || veiculo.tipo() != TipoVeiculo.ALUGADO) {
            return false;
        }
        return this.veiculosAssociados.add(veiculo);
    }

    /**
     * @apiNote "Na classe Contrato, implemente os métodos para adicionar e remover veículos associados
     * ao contrato utilizando ArrayList. Apenas veículos alugados podem ser adicionados ao contrato."
     * @see #associaVeiculo(Veiculo)
     */
    public boolean removeVeiculo(Veiculo veiculo) {
        return this.veiculosAssociados.remove(veiculo);
    }

    /**
     * @apiNote "Na classe Contrato, implemente os métodos para adicionar e remover motoristas
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
     * @apiNote "Na classe Contrato, implemente os métodos para adicionar e remover motoristas
     * associados ao contrato utilizando ArrayList. Apenas motoristas terceirizados podem ser adicionados ao contrato.
     * @see #associaMotorista(Motorista)
     */
    public boolean removeMotorista(Motorista motorista) {
        return this.motoristasAssociados.remove(motorista);
    }
}
