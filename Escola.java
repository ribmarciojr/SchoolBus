import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Escola extends PessoaJuridica {
    private final Set<Aluno> alunos = new HashSet<>();

    public Escola(String nome, String cnpj, String telefone, Endereco endereco, String nomeFantasia, int numeroDeFuncionarios) {
        super(nome, cnpj, telefone, endereco, nomeFantasia, numeroDeFuncionarios);
    }

    public boolean matriculaAluno(Aluno aluno) {
        if (Objects.isNull(aluno)) {
            return false;
        }
        return alunos.add(aluno);
    }

    public void exibeAlunos() {
        alunos.forEach(aluno -> {
            System.out.format("Nome: %s - CPF: %s - Matricula: %s - Serie: %s\n",
                    aluno.getNomeSocial(), aluno.getCpf(),
                    aluno.matricula(), aluno.serie());
        });
    }
}
