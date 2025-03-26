import java.util.Scanner;

public class ControleGastosMatriz {
    // Definindo os meses e os tipos de gastos
    private static final String[] MESES = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    private static final String[] TIPOS_GASTO = { "Luz", "Água", "Internet", "Aluguel" };

    // Matriz para armazenar gastos [mes][tipo_gasto]
    // 12 meses por 4 tipos de gastos
    private static double[][] gastos = new double[12][4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Controle de Gastos Anuais");
            System.out.println("1. Inserir gastos");
            System.out.println("2. Exibir gastos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirGastos(scanner);
                    break;
                case 2:
                    exibirGastos();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    // Método para inserir gastos na matriz
    private static void inserirGastos(Scanner scanner) {
        for (int mes = 0; mes < MESES.length; mes++) {
            System.out.println("Mês: " + MESES[mes]);
            for (int tipo = 0; tipo < TIPOS_GASTO.length; tipo++) {
                System.out.print("Gastos com " + TIPOS_GASTO[tipo] + ": R$ ");
                gastos[mes][tipo] = scanner.nextDouble();
            }
            System.out.println();
        }
    }

    // Método para exibir os gastos armazenados na matriz
    private static void exibirGastos() {
        System.out.println("\nGastos Anuais:");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s%n", "Mês", TIPOS_GASTO[0], TIPOS_GASTO[1], TIPOS_GASTO[2], TIPOS_GASTO[3]);

        for (int mes = 0; mes < MESES.length; mes++) {
            System.out.printf("%-10s ", MESES[mes]);
            for (int tipo = 0; tipo < TIPOS_GASTO.length; tipo++) {
                System.out.printf("%-10.2f ", gastos[mes][tipo]);
            }
            System.out.println();
        }
        System.out.println();
    }
}  