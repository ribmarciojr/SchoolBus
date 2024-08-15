import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CadastroDados {
        private Painel painel;
        private Dados dados;
        private Scanner sc;

        public CadastroDados(Painel painel, Dados dados, Scanner sc) {
            this.painel = painel;
            this.dados = dados;
            this.sc = sc;
        }

    public PontoDeParada novoPontoDeParada() {
        sc.nextLine();
        System.out.println("Digite o nome do ponto de parada");
        String nome = sc.nextLine();
        System.out.println("Digite a longitude");
        double longitude = sc.nextDouble();
        System.out.println("Digite a latitude");
        double latitude = sc.nextDouble();

        PontoDeParada p = dados.findPontoDeParada(nome, longitude, latitude);
        if(p == null) {
            return new PontoDeParada(nome, latitude, longitude);
        }
        return p;
    }

    public Endereco novoEndereco() {
        sc.nextLine();
        System.out.println("Digite o endereço na ordem");
        System.out.println("Rua");
        String rua = sc.nextLine();
        System.out.println("Numero");
        String numero = sc.nextLine();
        System.out.println("Bairro");
        String bairro = sc.nextLine();
        System.out.println("Cidade");
        String cidade = sc.nextLine();
        System.out.println("Estado");
        String estado = sc.nextLine();
        System.out.println("Complemento");
        String complemento = sc.nextLine();
        

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, complemento);

        return endereco;
    }

    public Contrato novoContrato(){
            sc.nextLine();
            System.out.println("Digite o número do contrato");
            String numContrato = sc.nextLine();
            System.out.println("Digite a data de início");
            LocalDate inicio = LocalDate.parse(sc.nextLine());
            System.out.println("Digite a data de fim");
            LocalDate fim = LocalDate.parse(sc.nextLine());
            System.out.println("Digite o valor");
            BigDecimal valor = sc.nextBigDecimal();

            Contrato contrato = new Contrato(numContrato, inicio, fim, valor);
            
            return contrato;
    }
    public Motorista novoMotorista(){
            sc.nextLine();
            System.out.println("Digite o nome civil do motorista");
            String nomeCivil = sc.nextLine();
            System.out.println("Digite o nome social do motorista");
            String nomeSocial = sc.nextLine();
            System.out.println("Digite o CPF");
            String cpf = sc.nextLine();
            System.out.println("Digite o telefone");
            String telefoneMotorista = sc.nextLine();
            System.out.println("Digite o nome do pai");
            String nomeDoPai = sc.nextLine();
            System.out.println("Digite o nome da mãe");
            String nomeDaMae = sc.nextLine();
            System.out.println("Digite a data de nascimento");
            LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
            System.out.println("Digite a naturalidade");
            String naturalidade = sc.nextLine();
            Endereco endereco = novoEndereco();
            System.out.println("Digite o número da CNH");
            String numeroCNH = sc.nextLine();
            System.out.println("Digite a categoria da CNH");
            String categoriaCNH = sc.nextLine();
            System.out.println("Digite o tipo de contrato");
            String tipoContrato = sc.nextLine();

            if (tipoContrato == "terceirizado"){
                Contrato contrato = novoContrato();
                Motorista motorista = Motorista.novoMotoristaTerceirizado(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, dataNascimento, telefoneMotorista, endereco, contrato, numeroCNH, CategoriaCNH.valueOf(categoriaCNH));
                contrato.associaMotorista(motorista);
                return motorista;
            }
            else if (tipoContrato == "secretaria"){
                Motorista motorista = Motorista.novoMotoristaSecretaria(nomeCivil, nomeSocial, cpf, nomeDoPai, nomeDaMae, naturalidade, dataNascimento, telefoneMotorista, endereco, numeroCNH, CategoriaCNH.valueOf(categoriaCNH));
                return motorista;
            }
            else{
                System.out.println("Tipo de contrato inválido");
                return null;
            }

    }

    public Escola novaEscola(){
        sc.nextLine();
        System.out.println("Digite o nome da escola");
        String nome = sc.nextLine();
        System.out.println("Digite o CNPJ");
        String cnpj = sc.nextLine();
        System.out.println("Digite o telefone");
        String telefone = sc.nextLine();
        System.out.println("Digite o nome fantasia");
        String nomeFantasia = sc.nextLine();
        System.out.println("Digite a quantidade atual de funcionários");
        int numeroDeFuncionarios = sc.nextInt();


        Escola escola = new Escola(nome, cnpj, telefone, novoEndereco(), nomeFantasia, numeroDeFuncionarios);

        return escola;
    }

    public void cadastro(){
        painel.mostrarCadastros();
        int action = sc.nextInt();

        switch (action){
            case 1://aluno

                break;

            case 2://motorista
                Motorista motorista = novoMotorista();
                if (dados.addMotorista(motorista)){
                    System.out.println("Novo motorista cadastrado com sucesso.");
                    break;
                }else {
                    System.out.println("Já existe um cadastro desse motorista no sistema!");
                }
                break;

            case 3://contrato

                break;

            case 4://escola
                Escola escola = novaEscola();

                if(dados.addEscola(escola)){
                    System.out.println("Nova escola cadastrada com sucesso.");
                    break;
                }
                else {
                    System.out.println("Já existe um cadastro dessa escola no sistema!");
                }
                break;

            case 5://veiculo

                break;

            case 6://ponto de parada
                PontoDeParada ponto = novoPontoDeParada();
                if(dados.addPontoDeParada(ponto)){
                    System.out.println("Novo ponto de parada cadastrado com sucesso.");
                }
                else{
                    System.out.println("O ponto de parada fornecido já existe no sistema.");
                }
                break;

            case 7:// rota
                System.out.println("Digite quantos pontos de parada deseja incluir na nova rota");
                int n = sc.nextInt();
                if(n <= 0){
                    painel.opcaoInvalida();
                }
                else{
                    LinkedHashSet pontos = new LinkedHashSet();
                    for(int i = 0; i < n; i++){
                        PontoDeParada ponto1 = novoPontoDeParada();
                        pontos.add(ponto1);
                        dados.addPontoDeParada(ponto1);
                    }
                    Rota rota = new Rota(pontos);
                    dados.addRota(rota);
                    System.out.println("Nova rota cadastrada com sucesso.");
                }
                break;

            case 8://fornecedor

                break;

            case 9://menu anterior

                break;

            default:
                painel.opcaoInvalida();
        }
    }
}
