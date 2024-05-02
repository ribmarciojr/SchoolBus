import java.util.LinkedHashSet;
import java.util.Set;

public class Rota {
    private final int id;
    private Set<PontoDeParada> pontosDeParada;
    private static int totalRotas = 0;

    /**
     * @apiNote "Implemente um construtor para a classe Rota que permita inicializar a lista de pontos de parada."
     */

    public Rota(LinkedHashSet<PontoDeParada> pontosDeParada) {
        this.pontosDeParada = pontosDeParada;
        this.id = totalRotas++;
    }

    /**
     * @apiNote "Crie um método estático na classe Rota para exibir o número total de rotas criadas."
     */

    public static void exibeTotalRotas() {
        System.out.println("Total de rotas: " + totalRotas);
    }

    /**
     * @apiNote "Implemente um método na classe Rota para calcular a demanda total da rota com base na associação
     * dos alunos aos pontos de parada.
     * Esse método deve percorrer todos os alunos associados a cada ponto de parada da rota e somar suas demandas."
     */

    public int demanda(){
        int total = 0;
        for(PontoDeParada p : pontosDeParada){
            total+=p.totalAlunos();
        }
        return total;
    }
}
