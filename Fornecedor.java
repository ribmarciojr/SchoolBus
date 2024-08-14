import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Fornecedor extends PessoaJuridica {
    private final Set<Contrato> contratos = new HashSet<>();

    public Fornecedor(String nomeOficial, String cpf_cnpj, String telefone, Endereco endereco, String nomeFantasia, int numeroDeFuncionarios) {
        super(nomeOficial, cpf_cnpj, telefone, endereco, nomeFantasia, numeroDeFuncionarios);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return this.getCpf_cnpj().equals(that.getCpf_cnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getCpf_cnpj());
    }
}
