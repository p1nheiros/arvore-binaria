import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);
        int escolha, valor;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir");
            System.out.println("2. Buscar");
            System.out.println("3. Remover");
            System.out.println("4. Percurso em Ordem");
            System.out.println("5. Percurso em Pre-Ordem");
            System.out.println("6. Percurso em Pos-Ordem");
            System.out.println("7. Percurso em Nivel");
            System.out.println("8. Contar Nos");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opcao: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Inserção de um novo valor
                    System.out.print("Digite o valor para inserir: ");
                    valor = scanner.nextInt();
                    arvore.inserir(valor);
                    System.out.println("Valor inserido com sucesso.");
                    break;
                case 2:
                    // Busca de um valor
                    System.out.print("Digite o valor para buscar: ");
                    valor = scanner.nextInt();
                    boolean encontrado = arvore.buscar(valor);
                    System.out.println(encontrado ? "Valor encontrado." : "Valor nao encontrado.");
                    break;
                case 3:
                    // Remoção de um valor
                    System.out.print("Digite o valor para remover: ");
                    valor = scanner.nextInt();
                    arvore.remover(valor);
                    System.out.println("Valor removido se existia.");
                    break;
                case 4:
                    // Percurso em Ordem
                    System.out.println("Percurso em Ordem:");
                    arvore.emOrdem();
                    System.out.println();  // Adiciona uma nova linha após o percurso
                    break;
                case 5:
                    // Percurso em Pre-Ordem
                    System.out.println("Percurso em Pre-Ordem:");
                    arvore.preOrdem();
                    System.out.println();  // Adiciona uma nova linha após o percurso
                    break;
                case 6:
                    // Percurso em Pos-Ordem
                    System.out.println("Percurso em Pos-Ordem:");
                    arvore.posOrdem();
                    System.out.println();  // Adiciona uma nova linha após o percurso
                    break;
                case 7:
                    // Percurso em Nivel
                    System.out.println("Percurso em Nivel:");
                    arvore.percorrerEmNivel();
                    System.out.println();  // Adiciona uma nova linha após o percurso
                    break;
                case 8:
                    // Contar nós na árvore
                    System.out.println("Numero de nos na arvore: " + arvore.contarNos());
                    break;
                case 9:
                    // Sair do programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Opção inválida
                    System.out.println("Opção invalida. Tente novamente.");
                    break;
            }
        } while (escolha != 9);

        scanner.close();  // Fecha o scanner para liberar recursos
    }
}
