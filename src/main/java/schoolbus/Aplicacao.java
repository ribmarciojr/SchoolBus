package schoolbus;

public class Aplicacao {
    private final Menu menu;

    public Aplicacao(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        menu.mostrarAcoesGerais();
        while (menu.opcao() != 3) {
            menu.lerOpcao();
            menu.executarOpcao();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Aplicacao aplicacao = new Aplicacao(menu);
        aplicacao.run();
    }
}
