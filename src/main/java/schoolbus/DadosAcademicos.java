package schoolbus;

import schoolbus.compartilhado.InputUsuario;

import java.util.Objects;

public class DadosAcademicos {
    @InputUsuario(prompt = "Digite a matricula: ")
    private String matricula;
    @InputUsuario(prompt = "Digite a serie: ")
    private String serie;
    private Escola escola;
    private Turno turno;

    public DadosAcademicos(String matricula, String serie, Escola escola, Turno turno) {
        this.matricula = Objects.requireNonNull(matricula, "A matricula do aluno nao pode ser nula");
        this.serie = Objects.requireNonNull(serie, "A serie do aluno nao pode ser nula");
        this.escola = Objects.requireNonNull(escola, "A escola do aluno nao pode ser nula");
        this.turno = Objects.requireNonNull(turno, "O turno do aluno nao pode ser nulo");
    }

    public String matricula() {
        return matricula;
    }

    public String serie() {
        return serie;
    }
}
