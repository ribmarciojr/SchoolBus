package schoolbus;

import schoolbus.compartilhado.InputUsuario;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeituraDados {
    private static final Map<Integer, Class> OPCOES = new HashMap<>();

    static {
        OPCOES.put(1, Aluno.class);
        OPCOES.put(2, Motorista.class);
        OPCOES.put(3, Contrato.class);
        OPCOES.put(4, Escola.class);
        OPCOES.put(5, Veiculo.class);
        OPCOES.put(6, PontoDeParada.class);
        OPCOES.put(7, Rota.class);
        OPCOES.put(8, Fornecedor.class);
    }

    private final Dados dados = new Dados();
    private final Scanner scanner;

    public LeituraDados(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerOpcao() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void demandaDeRota() {
        if (Rota.total() == 0) {
            System.out.println("Não há rotas para serem listadas!");
            return;
        }
        System.out.println("Digite o número da rota que deseja obter a demanda:");
        dados.listarRotas();
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 0 || n > Rota.total() - 1) {
            System.out.println("Opção inválida!");
            return;
        }
        dados.listarDemandaRota(n);
    }

    public void exibeTotalRotas() {
        Rota.exibeTotalRotas();
    }

    public void exibeTotalPontos() {
        PontoDeParada.exibeTotalPontos();
    }

    public void cadastrar() {
        int action = lerOpcao();
        if (!OPCOES.containsKey(action)) {
            System.out.println("Opção inválida!");
            return;
        }
        Class clazz = OPCOES.get(action);
        Object obj = processaObjeto(clazz);
        switch (obj) {
            case Aluno aluno -> dados.addAluno(aluno);
            case Motorista motorista -> dados.addMotorista(motorista);
            case Contrato contrato -> dados.addContrato(contrato);
            case Escola escola -> dados.addEscola(escola);
            case Veiculo veiculo -> dados.addVeiculo(veiculo);
            case PontoDeParada pontoDeParada -> dados.addPontoDeParada(pontoDeParada);
            case Rota rota -> dados.addRota(rota);
            case Fornecedor fornecedor -> dados.addFornecedor(fornecedor);
            default -> throw new RuntimeException("Invalid object: " + obj);
        }
    }

    private <T> T processaObjeto(Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            Class<?> current = clazz;
            while (current != null) {
                leiaUsandoReflexao(current, obj);
                current = current.getSuperclass();
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object: " + e.getMessage(), e);
        }
    }

    private void leiaUsandoReflexao(Class clazz, Object obj) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (Collection.class.isAssignableFrom(field.getType())) {
                continue;
            }
            if (field.isAnnotationPresent(InputUsuario.class)) {
                InputUsuario annotation = field.getAnnotation(InputUsuario.class);
                System.out.println(annotation.prompt());
                String input = scanner.nextLine();
                Object value = tipo(field, input);
                field.set(obj, value);
            } else {
                Object nestedObj = processaObjeto(field.getType());
                field.set(obj, nestedObj);
            }
        }
    }

    private Object tipo(Field field, String input) {
        Class<?> type = field.getType();
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return Integer.parseInt(input);
        } else if (type.equals(BigDecimal.class)) {
            return new BigDecimal(input);
        } else if (type.equals(LocalDate.class)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(input, formatter);
        } else if (type.equals(String.class)) {
            return input;
        } else if (type.isEnum()) {
            return Enum.valueOf((Class<Enum>) type, input);
        }
        throw new IllegalArgumentException("Tipo inválido: " + type);
    }
}
