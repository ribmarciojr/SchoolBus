import java.util.Scanner;

public class LeituraDados {
    private Painel painel;
    private Dados dados;
    private Scanner sc;

    public LeituraDados(Painel painel, Dados dados, Scanner sc) {
        this.painel = painel;
        this.dados = dados;
        this.sc = sc;
    }

    public void ler(){
        painel.mostrarLeituras();
        int action = sc.nextInt();

        switch (action){
            case 1://demanda de uma rota especifica
                if(Rota.getTotalRotas() == 0){
                    System.out.println("Não há rotas para serem listadas!");
                }
                else {
                    System.out.println("Digite o número da rota que deseja obter a demanda:");
                    dados.listarRotas();
                    int n = sc.nextInt();
                    if(n < 0 || n > Rota.getTotalRotas()-1){
                        painel.opcaoInvalida();
                    }
                    else{
                        dados.listarDemandaRota(n);
                    }
                }
                break;

            case 2: //total rotas criadas
                Rota.exibeTotalRotas();
                break;

            case 3://total pontos de parada criados
                PontoDeParada.exibeTotalPontos();
                break;

            case 4://menu anterior
                break;

            default:
                painel.opcaoInvalida();
        }
    }
}