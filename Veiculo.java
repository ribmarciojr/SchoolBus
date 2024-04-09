import java.io.IOException;
import java.time.Year;

public class Veiculo {
    private String placa;
    private Year ano;
    private String modelo;
    private int capacidade;
    private String numeroDeContrato;
    private TipoVeiculo tipoVeiculo;
   
    private Veiculo(String placa, Year ano, String modelo, int capacidade, String numeroDeContrato) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.numeroDeContrato = numeroDeContrato;
    }

    public static Veiculo novoVeiculoAlugado(String placa, Year ano, String modelo, int capacidade, String numeroDeContrato){
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade, numeroDeContrato);
        
        veiculo.tipoVeiculo = TipoVeiculo.ALUGADO;
        
        return veiculo;
    }

    public static Veiculo novoVeiculoProprio(String placa, Year ano, String modelo, int capacidade){
        Veiculo veiculo = new Veiculo(placa, ano, modelo, capacidade, modelo);

        veiculo.tipoVeiculo = TipoVeiculo.PROPRIO;

        return veiculo;
    }

    public boolean foiAlugado(){
        return (tipoVeiculo == TipoVeiculo.ALUGADO) ? true : false;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setNumeroDeContrato(String numeroDeContrato) throws IOException {
        if(this.tipoVeiculo == TipoVeiculo.PROPRIO){
            throw new IOException("Contrato inválido, o veículo deve ser alugado para estar associado a um contrato!");
        } else {
            this.numeroDeContrato = numeroDeContrato;
        }
    }

}
