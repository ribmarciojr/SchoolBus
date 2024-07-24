import java.util.Set;
import java.util.HashSet;

public class Fornecedor extends PessoaJuridica {
    private final Set<Contrato> contratos = new HashSet<>();

    public Fornecedor(String nomeOficial, String cpf_cnpj, String telefone, Endereco endereco, String nomeFantasia, int numeroDeFuncionarios) {
        super(nomeOficial, cpf_cnpj, telefone, endereco, nomeFantasia, numeroDeFuncionarios);
    }
}
