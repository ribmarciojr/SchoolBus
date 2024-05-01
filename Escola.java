import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Escola {
    private String nome;
    private String cnpj;
    private String telefone;
    private Endereco endereco;
    private final Set<Aluno> alunos = new HashSet<>();

    public Escola(String nome, String cnpj, String telefone) {
        this.nome = Objects.requireNonNull(nome, "O nome da escola nao pode ser nulo");
        this.cnpj = Objects.requireNonNull(cnpj, "O CNPJ da escola nao pode ser nulo");
        this.telefone = Objects.requireNonNull(telefone, "O telefone da escola nao pode ser nulo");
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = Objects.requireNonNull(endereco, "O endereco da escola nao pode ser nulo");
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
                    aluno.nomeSocial(), aluno.cpf(),
                    aluno.matricula(), aluno.serie());
        });
    }
}
