import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PontoDeParada {
    private final String nome;
    private final double latitude;
    private final double longitude;
    private final int id;

    private final Set<Aluno> alunos = new HashSet<>();

    private static int totalPontos = 0;

    public PontoDeParada(String nome, double latitude, double longitude) {
        this.nome = Objects.requireNonNull(nome, "O nome do ponto de parada nao pode ser nulo");
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = totalPontos;
        totalPontos++;
    }

    public static void exibeTotalDePontos(){
        System.out.println("Total de pontos: "+totalPontos);
    }
}
