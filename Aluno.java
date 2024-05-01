import java.time.LocalDate;

public class Aluno extends Pessoa {
    private DadosAcademicos dadosAcademicos;
    private String rota;

    public Aluno(String nomeCivil, String nomeSocial, String cpf, String nomeDoPai, String nomeDaMae,
                 String naturalidade, String telefone, Endereco endereco, LocalDate dataDeNascimento,
                 String rota, String matricula, String serie, Escola escola, Turno turno) {
        super(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, telefone, endereco, dataDeNascimento);
        this.dadosAcademicos = new DadosAcademicos(matricula, serie, escola, turno);
        this.rota = rota;
    }

    public String matricula() {
        return dadosAcademicos.matricula();
    }

    public String serie() {
        return dadosAcademicos.serie();
    }
}
