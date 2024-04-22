import java.io.IOException;
import java.time.Year;
import java.util.Objects;

public class Veiculo {
    private final String placa;
    private final Year ano;
    private final String modelo;
    private final int capacidade;
    private String numeroDeContrato;
    private TipoVeiculo tipo;

    private Veiculo(String placa, Year ano, String modelo, int capacidade, String numeroDeContrato) {
        this.placa = Objects.requireNonNull(placa, "Placa nao pode ser nula!");
        this.ano = Objects.requireNonNull(ano, "Ano nao pode ser nulo!");
        this.modelo = Objects.requireNonNull(modelo, "Modelo nao pode ser nulo!");
        this.capacidade = capacidade;
        this.numeroDeContrato = Objects.requireNonNull(numeroDeContrato, "Número de contrato nao pode ser nulo!");
    }

    public static Veiculo novoVeiculoAlugado(String placa, Year ano, String modelo, int capacidade, String numeroDeContrato) {
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade, numeroDeContrato);
        veiculo.tipo = TipoVeiculo.ALUGADO;
        return veiculo;
    }

    public static Veiculo novoVeiculoProprio(String placa, Year ano, String modelo, int capacidade) {
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade, "");
        veiculo.tipo = TipoVeiculo.PROPRIO;
        return veiculo;
    }

    /**
     * @apiNote "Escreva um método que verifique se o veículo é próprio ou alugado"
     */
    public TipoVeiculo tipo() {
        return tipo;
    }

    public void setNumeroDeContrato(String numeroDeContrato) throws IOException {
        if (this.tipo == TipoVeiculo.PROPRIO) {
            throw new IllegalStateException("Método inválido, o veículo deve ser alugado para estar associado a um contrato!");
        }
        this.numeroDeContrato = numeroDeContrato;
    }
}
