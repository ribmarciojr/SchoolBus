import java.time.LocalDate;
import java.util.*;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Painel painel = Painel.getInstance();
        Dados dados = new Dados();
        CadastroDados cadastrar = new CadastroDados(painel, dados, sc);
        LeituraDados leitura = new LeituraDados(painel, dados, sc);

        painel.mostrarAcoesGerais();
        int action = sc.nextInt();
        while(action != 3) {
            switch(action) {
                case 1:
                    leitura.ler();
                    break;

                case 2:
                    cadastrar.cadastro();
                    break;

                default:
                    painel.opcaoInvalida();
            }
            painel.mostrarAcoesGerais();
            action = sc.nextInt();
        }
    }
}
