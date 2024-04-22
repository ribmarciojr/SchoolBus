import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Contrato {
    private final String numContrato;
    private final LocalDate inicio;
    private final LocalDate fim;
    private final BigDecimal valor;

    private Set<Veiculo> veiculosAssociados = new HashSet<>();
    private Set<Motorista> motoristasAssociados = new HashSet<>();

    public Contrato(String numContrato, LocalDate inicio, LocalDate fim, BigDecimal valor) {
        this.numContrato = Objects.requireNonNull(numContrato, "Número do contrato não pode ser nulo!");
        this.inicio = Objects.requireNonNull(inicio, "Data de início não pode ser nula!");
        this.fim = Objects.requireNonNull(fim, "Data de fim não pode ser nula!");
        this.valor = Objects.requireNonNull(valor, "Valor não pode ser nulo!");
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
