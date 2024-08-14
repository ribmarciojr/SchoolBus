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
    };

    public void cadastro(){
        painel.mostrarCadastros();
        int action = sc.nextInt();

        switch (action){
            case 1://aluno
                break;

            case 2://motorista
                break;

            case 3://contrato
                break;

            case 4://escola
                Escola escola = novaEscola();

                if(dados.addEscola(escola)){
                    System.out.println("Nova escola cadastrada com sucesso.");
                    break;
                }
            
                System.out.println("Já existe um cadastro dessa escola no sistema!");
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
