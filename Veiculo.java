import java.io.IOException;
import java.time.Year;

public class Veiculo {
    private String placa;
    private Year ano;
    private String modelo;
    private int capacidade;
    private String numeroDeContrato;
    private TipoVeiculo tipo;

    private Veiculo(String placa, Year ano, String modelo, int capacidade, String numeroDeContrato) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.numeroDeContrato = numeroDeContrato;
    }

    public static Veiculo novoVeiculoAlugado(String placa, Year ano, String modelo, int capacidade, String numeroDeContrato) {
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade, numeroDeContrato);
        veiculo.tipo = TipoVeiculo.ALUGADO;
        return veiculo;
    }

    public static Veiculo novoVeiculoProprio(String placa, Year ano, String modelo, int capacidade) {
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade, modelo);
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
            throw new IllegalArgumentException("Método inválido, o veículo deve ser alugado para estar associado a um contrato!");
        }
        this.numeroDeContrato = numeroDeContrato;
    }
}
