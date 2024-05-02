import java.io.IOException;
import java.time.Year;
import java.util.Objects;

public class Veiculo {
    private final String placa;
    private final Year ano;
    private final String modelo;
    private final int capacidade;
    private Contrato contrato;
    private TipoVeiculo tipo;

    private Veiculo(String placa, Year ano, String modelo, int capacidade) {
        this.placa = Objects.requireNonNull(placa, "Placa nao pode ser nula!");
        this.ano = Objects.requireNonNull(ano, "Ano nao pode ser nulo!");
        this.modelo = Objects.requireNonNull(modelo, "Modelo nao pode ser nulo!");
        this.capacidade = capacidade;
    }

    public static Veiculo novoVeiculoAlugado(String placa, Year ano, String modelo, int capacidade, Contrato contrato) {
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade);
        veiculo.contrato = Objects.requireNonNull(contrato, "Contrato nao pode ser nulo!");
        veiculo.tipo = TipoVeiculo.ALUGADO;
        return veiculo;
    }

    public static Veiculo novoVeiculoProprio(String placa, Year ano, String modelo, int capacidade) {
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade);
        veiculo.tipo = TipoVeiculo.PROPRIO;
        return veiculo;
    }

    /**
     * @apiNote "Escreva um método que verifique se o veículo é próprio ou alugado"
     */
    public TipoVeiculo tipo() {
        return tipo;
    }

    public void setContrato(Contrato novoContrato) throws IOException {
        if (this.tipo == TipoVeiculo.PROPRIO) {
            throw new IllegalStateException("Metodo invalido, o veiculo deve ser alugado para estar associado a um contrato!");
        }

        if (!this.contrato.equals(novoContrato) && novoContrato != null) {
            this.contrato.removeVeiculo(this);
            this.contrato = novoContrato;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return capacidade == veiculo.capacidade && Objects.equals(placa, veiculo.placa) && Objects.equals(ano, veiculo.ano) && Objects.equals(modelo, veiculo.modelo) && tipo == veiculo.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, ano, modelo, capacidade, tipo);
    }
}
