import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dados {
    private final Set<Fornecedor> fornecedores = new HashSet<>();
    private final Set<Contrato> contratos = new HashSet<>();
    private final Set<Motorista> motoristas = new HashSet<>();
    private final Set<Veiculo> veiculos = new HashSet<>();
    private final Set<Aluno> alunos = new HashSet<>();
    private final Set<Escola> escolas = new HashSet<>();
    private final Set<PontoDeParada> pontosDeParada = new HashSet<>();
    private final List<Rota> rotas = new ArrayList<>();

    public Dados(){}

    public boolean addFornecedor(Fornecedor fornecedor){
        return fornecedores.add(fornecedor);
    }
    public boolean addContrato(Contrato contrato){
        return contratos.add(contrato);
    }
    public boolean addMotorista(Motorista motorista){
        return motoristas.add(motorista);
    }
    public boolean addVeiculo(Veiculo veiculo){
        return veiculos.add(veiculo);
    }
    public boolean addAluno(Aluno aluno){
        return alunos.add(aluno);
    }
    public boolean addEscola(Escola escola){
        return escolas.add(escola);
    }
    public boolean addRota(Rota rota){
        return rotas.add(rota);
    }
    public boolean addPontoDeParada(PontoDeParada pontoDeParada){
        return pontosDeParada.add(pontoDeParada);
    }


    public Fornecedor findFornecedor(Fornecedor f1){
        if(fornecedores.contains(f1)){
            for(Fornecedor fornecedor : fornecedores){
                if(fornecedor.equals(f1)){
                    return fornecedor;
                }
            }
        }
        return null;
    }

    public Contrato findContrato(Contrato c1){
        if(contratos.contains(c1)){
            for(Contrato contrato : contratos){
                if(contrato.equals(c1)){
                    return contrato;
                }
            }
        }
        return null;
    }

    public Contrato findContratoByNum(String numContrato ){
        for(Contrato contrato : contratos){
            if(contrato.getNumContrato().equals(numContrato)){
                return contrato;
            }
        }
        return null;
    }

    public Motorista findMotorista(Motorista m1){
        if(motoristas.contains(m1)){
            for(Motorista motorista : motoristas){
                if(motorista.equals(m1)){
                    return motorista;
                }
            }
        }
        return null;
    }

    public Veiculo findVeiculo(Veiculo v1){
        if(veiculos.contains(v1)){
            for(Veiculo veiculo : veiculos){
                if(veiculo.equals(v1)){
                    return veiculo;
                }
            }
        }
        return null;
    }

    public Aluno findAluno(Aluno a1){
        if(alunos.contains(a1)){
            for(Aluno aluno : alunos){
                if(aluno.equals(a1)){
                    return aluno;
                }
            }
        }
        return null;
    }

    public Escola findEscola(Escola a1){
        if(escolas.contains(a1)){
            for(Escola escola : escolas){
                if(escola.equals(a1)){
                    return escola;
                }
            }
        }
        return null;
    }

    public PontoDeParada findPontoDeParada(String nome, double latitude, double longitude){
            for(PontoDeParada pontoDeParada : pontosDeParada){
                if(pontoDeParada.same(nome,latitude, longitude)){
                    return pontoDeParada;
                }
            }
        return null;
    }

    public void listarRotas(){
        int i = 0;
        for (Rota rota : rotas) {
            System.out.println("Rota " + i + ": " + rota);
            ++i;
        }
    }

    public void listarFornecedores(){
        int i = 1;
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println("Fornecedor " + i + ": " + fornecedor);
            ++i;
        }
    }

    public int totalFornecedores(){
        return fornecedores.size();
    }

    public Fornecedor getFornecedor(int n){
        Fornecedor f;
        for(Fornecedor fornecedor : fornecedores){
            n = n-1;
            if(n == 0){
                return fornecedor;
            }
        }
        return null;
    }

    public void listarDemandaRota(int n){
        Rota r = rotas.get(n);
        System.out.println("A demanda da rota " + r + " é: " + r.demanda());
    }

}

