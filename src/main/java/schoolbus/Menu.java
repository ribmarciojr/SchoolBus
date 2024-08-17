package schoolbus;

import java.util.Scanner;

public class Menu {
    private static final String OPCOES_GERAIS = """
            Menu Principal - O que você deseja fazer? (Digite um número)
            [1] - Ler dados no sistema
            [2] - Cadastrar dados no sistema
            [3] - Sair
            Digite a opcao desejada:\s""";

    private static final String OPCOES_LEITURA = """
            Menu de Leitura - O que você deseja ler? (Digite um número)
            [1] - Demanda de uma rota específica
            [2] - Número de rotas criadas
            [3] - Número de pontos de parada criados
            [4] - Voltar ao menu anterior
            Digite a opcao desejada:\s""";

    private static final String OPCOES_CADASTRO = """
            Menu de Cadastro - O que você deseja cadastrar? (Digite um número)
            [1] - Aluno
            [2] - Motorista
            [3] - Contrato
            [4] - Escola
            [5] - Veiculo
            [6] - Ponto de Parada
            [7] - Rota
            [8] - Fornecedor
            [9] - Voltar ao menu anterior
            Digite a opcao desejada:\s""";

    private final LeituraDados dados;
    private int opcao = -1;

    public Menu() {
        this.dados = new LeituraDados(new Scanner(System.in));
    }

    public void mostrarAcoesGerais() {
        System.out.print(OPCOES_GERAIS);
    }

    public void lerOpcao() {
        opcao = dados.lerOpcao();
    }

    public void executarOpcao() {
        switch (opcao) {
            case 1 -> {
                mostrarOpcoesLeitura();
                processarOpcoesExibicao();
            }
            case 2 -> {
                mostrarOpcoesCadastro();
                dados.cadastrar();
            }
            case 3 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

    public int opcao() {
        return opcao;
    }

    private void mostrarOpcoesLeitura() {
        System.out.print(OPCOES_LEITURA);
    }

    private void processarOpcoesExibicao() {
        int opcaoLeitura = dados.lerOpcao();
        switch (opcaoLeitura) {
            // demanda de uma rota especifica
            case 1 -> dados.demandaDeRota();
            // total rotas criadas
            case 2 -> dados.exibeTotalRotas();
            // total pontos de parada criados
            case 3 -> dados.exibeTotalPontos();
            // menu anterior
            case 4 -> System.out.println("Voltando ao menu anterior...");
            default -> System.out.println("Opção inválida!");
        }
    }

    private void mostrarOpcoesCadastro() {
        System.out.print(OPCOES_CADASTRO);
    }
}
