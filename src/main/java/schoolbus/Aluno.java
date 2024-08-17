package schoolbus;

import java.time.LocalDate;
import java.util.Objects;

public class Aluno extends PessoaFisica {
    private DadosAcademicos dadosAcademicos;
    private PontoDeParada pontoDeParada;

    public Aluno(String nomeCivil, String nomeSocial, String cpf, String nomeDoPai, String nomeDaMae,
                 String naturalidade, String telefone, Endereco endereco, LocalDate dataDeNascimento,
                 String matricula, String serie, Escola escola,
                 Turno turno, PontoDeParada pontoDeParada) {
        super(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, dataDeNascimento, telefone, endereco);
        this.dadosAcademicos = new DadosAcademicos(matricula, serie, escola, turno);
        this.pontoDeParada = Objects.requireNonNull(pontoDeParada, "O ponto de parada do aluno nao pode ser nulo");
    }


    public String matricula() {
        return dadosAcademicos.matricula();
    }

    public String serie() {
        return dadosAcademicos.serie();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return this.getCpf_cnpj().equals(aluno.getCpf_cnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getCpf_cnpj());
    }
}
