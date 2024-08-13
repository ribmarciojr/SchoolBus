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
        this.id = totalPontos++;
    }

    public static void exibeTotalPontos(){
        System.out.println("Total de pontos: "+totalPontos);
    }

    public int totalAlunos() {return alunos.size();}

    public boolean adicionaAluno(Aluno aluno) {
        if (Objects.isNull(aluno)) {
            return false;
        }
        return this.alunos.add(aluno);
    }
}
