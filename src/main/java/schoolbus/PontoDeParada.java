package schoolbus;

import schoolbus.compartilhado.InputUsuario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PontoDeParada {
    @InputUsuario(prompt = "Digite o nome do ponto de parada: ")
    private String nome;
    @InputUsuario(prompt = "Digite a latitude do ponto de parada: ")
    private double latitude;
    @InputUsuario(prompt = "Digite a longitude do ponto de parada: ")
    private double longitude;
    private int id;

    private final Set<Aluno> alunos = new HashSet<>();

    private static int totalPontos = 0;

    public PontoDeParada() {
    }

    public PontoDeParada(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = totalPontos++;
    }

    public static void exibeTotalPontos() {
        System.out.println("Total de pontos: " + totalPontos);
    }

    public int totalAlunos() {
        return alunos.size();
    }

    public boolean adicionaAluno(Aluno aluno) {
        if (Objects.isNull(aluno)) {
            return false;
        }
        return this.alunos.add(aluno);
    }

    public boolean same(String nome, double latitude, double longitude) {
        return this.nome.equals(nome) && this.latitude == latitude && this.longitude == longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PontoDeParada that = (PontoDeParada) o;
        return Double.compare(latitude, that.latitude) == 0 && Double.compare(longitude, that.longitude) == 0 && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, latitude, longitude);
    }

    @Override
    public String toString() {
        return "{" +
                "nome = '" + nome + '\'' +
                ", latitude = " + latitude +
                ", longitude = " + longitude +
                ", id = " + id +
                ", alunos = " + alunos +
                '}';
    }
}
