public class Painel {
    private static Painel instance;

    private Painel(){
    }

    public static Painel getInstance(){
        if(instance == null){
            instance = new Painel();
        }
        return instance;
    }

    public void mostrarAcoesGerais(){
        System.out.println("O que você deseja fazer? (Digite um número)");
        System.out.println("[1] Ler dados no sistema");
        System.out.println("[2] Cadastrar dados no sistema");
        System.out.println("[3] Sair do sistema");
    }

    public void mostrarCadastros(){
        System.out.println("O que você deseja cadastrar?");
        System.out.println("[1] Aluno");
        System.out.println("[2] Motorista");
        System.out.println("[3] Contrato");
        System.out.println("[4] Escola");
        System.out.println("[5] Veiculo");
        System.out.println("[6] Ponto de Parada");
        System.out.println("[7] Rota");
        System.out.println("[8] Fornecedor");
        System.out.println("[9] Contrato associado a um fornecedor");
        System.out.println("[10] Voltar ao menu anterior");
    }

    public void mostrarLeituras(){
        System.out.println("O que você deseja ler?");
        System.out.println("[1] Demanda de uma rota específica");
        System.out.println("[2] Numero de rotas criadas");
        System.out.println("[3] Numero de pontos de parada criados");
        System.out.println("[4] Informações detalhadas de um aluno");
        System.out.println("[5] Informações detalhadas de um motorista");
        System.out.println("[6] Informações detalhadas de uma escola");
        System.out.println("[7] Informações detalhadas de um fornecedor");
        System.out.println("[8] Exibir o tipo de um aluno");
        System.out.println("[9] Exibir o tipo de um motorista");
        System.out.println("[10] Exibir o tipo de uma escola");
        System.out.println("[11] Exibir o tipo de um fornecedor");
        System.out.println("[12] Voltar ao menu anterior");
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida digitada! Tente novamente.");
    }

    public void erroRotaInexistente(){
        System.out.println("Erro! A rota procurada não existe.");
    }
}
