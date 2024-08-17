package schoolbus;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Rota {
    private static int TOTAL = 0;

    private final int id;
    private Set<PontoDeParada> pontosDeParada;

    /**
     * @apiNote "Implemente um construtor para a classe schoolbus.Rota que permita inicializar a lista de pontos de parada."
     */

    public Rota(LinkedHashSet<PontoDeParada> pontosDeParada) {
        this.pontosDeParada = pontosDeParada;
        this.id = TOTAL++;
    }

    /**
     * @apiNote "Crie um método estático na classe schoolbus.Rota para exibir o número total de rotas criadas."
     */

    public static void exibeTotalRotas() {
        System.out.println("Total de rotas: " + TOTAL);
    }

    public static int total() {
        return TOTAL;
    }

    /**
     * @apiNote "Implemente um método na classe schoolbus.Rota para calcular a demanda total da rota com base na associação
     * dos alunos aos pontos de parada.
     * Esse método deve percorrer todos os alunos associados a cada ponto de parada da rota e somar suas demandas."
     */

    public int demanda() {
        int total = 0;
        for (PontoDeParada p : pontosDeParada) {
            total += p.totalAlunos();
        }
        return total;
    }

    public boolean adicionaPontoDeParada(PontoDeParada pontoDeParada) {
        if (Objects.isNull(pontoDeParada)) {
            return false;
        }
        return this.pontosDeParada.add(pontoDeParada);
    }

    @Override
    public String toString() {
        return " {" +
                "id = " + id +
                ", pontos de parada = " + pontosDeParada +
                '}';
    }
}
