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
    }
}
