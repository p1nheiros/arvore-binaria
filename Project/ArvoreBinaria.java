import java.util.LinkedList;
import java.util.Queue;

class No {
    int valor;
    No esquerdo, direito;

    public No(int item) {
        valor = item;
        esquerdo = direito = null;
    }
}

public class ArvoreBinaria {
    No raiz;  // Raiz da árvore

    // Construtor para inicializar a árvore vazia
    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para inserir um novo valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Método recursivo para inserir um novo valor na árvore
    private No inserirRecursivo(No raiz, int valor) {
        // Se a raiz é null, cria um novo nó e retorna
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        // Se o valor é menor que o valor do nó atual, insere na subárvore esquerda
        if (valor < raiz.valor) {
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, valor);
        }
        // Se o valor é maior que o valor do nó atual, insere na subárvore direita
        else if (valor > raiz.valor) {
            raiz.direito = inserirRecursivo(raiz.direito, valor);
        }

        return raiz;
    }

    // Método para buscar um valor na árvore
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método recursivo para buscar um valor na árvore
    private boolean buscarRecursivo(No raiz, int valor) {
        // Se a raiz é null, o valor não foi encontrado
        if (raiz == null) {
            return false;
        }

        // Se o valor do nó atual é igual ao valor procurado, retorna true
        if (raiz.valor == valor) {
            return true;
        }

        // Se o valor procurado é menor, busca na subárvore esquerda
        return valor < raiz.valor ? buscarRecursivo(raiz.esquerdo, valor) : buscarRecursivo(raiz.direito, valor);
    }

    // Método para percorrer a árvore em ordem (inorder)
    public void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    // Método recursivo para percorrer a árvore em ordem
    private void emOrdemRecursivo(No raiz) {
        if (raiz != null) {
            emOrdemRecursivo(raiz.esquerdo);
            System.out.print(raiz.valor + " ");
            emOrdemRecursivo(raiz.direito);
        }
    }

    // Método para percorrer a árvore em pré-ordem (preorder)
    public void preOrdem() {
        preOrdemRecursivo(raiz);
    }

    // Método recursivo para percorrer a árvore em pré-ordem
    private void preOrdemRecursivo(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRecursivo(raiz.esquerdo);
            preOrdemRecursivo(raiz.direito);
        }
    }

    // Método para percorrer a árvore em pós-ordem (postorder)
    public void posOrdem() {
        posOrdemRecursivo(raiz);
    }

    // Método recursivo para percorrer a árvore em pós-ordem
    private void posOrdemRecursivo(No raiz) {
        if (raiz != null) {
            posOrdemRecursivo(raiz.esquerdo);
            posOrdemRecursivo(raiz.direito);
            System.out.print(raiz.valor + " ");
        }
    }

    // Método para remover um valor da árvore
    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    // Método recursivo para remover um valor da árvore
    private No removerRecursivo(No raiz, int valor) {
        // Se a raiz é null, retorna null
        if (raiz == null) {
            return raiz;
        }

        // Se o valor a ser removido é menor, busca na subárvore esquerda
        if (valor < raiz.valor) {
            raiz.esquerdo = removerRecursivo(raiz.esquerdo, valor);
        }
        // Se o valor a ser removido é maior, busca na subárvore direita
        else if (valor > raiz.valor) {
            raiz.direito = removerRecursivo(raiz.direito, valor);
        }
        // Se o valor é igual ao valor do nó atual, este é o nó a ser removido
        else {
            // Nó com um filho ou nenhum filho
            if (raiz.esquerdo == null)
                return raiz.direito;
            else if (raiz.direito == null)
                return raiz.esquerdo;

            // Nó com dois filhos: encontra o menor valor na subárvore direita
            raiz.valor = minValor(raiz.direito);

            // Remove o menor valor na subárvore direita
            raiz.direito = removerRecursivo(raiz.direito, raiz.valor);
        }

        return raiz;
    }

    // Método para encontrar o menor valor em uma subárvore
    private int minValor(No raiz) {
        int minv = raiz.valor;
        while (raiz.esquerdo != null) {
            minv = raiz.esquerdo.valor;
            raiz = raiz.esquerdo;
        }
        return minv;
    }

    // Método para contar o número de nós na árvore
    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    // Método recursivo para contar o número de nós na árvore
    private int contarNosRecursivo(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(raiz.esquerdo) + contarNosRecursivo(raiz.direito);
    }

    // Método para percorrer a árvore em nível
    public void percorrerEmNivel() {
        if (raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            System.out.print(noAtual.valor + " ");

            if (noAtual.esquerdo != null) {
                fila.add(noAtual.esquerdo);
            }
            if (noAtual.direito != null) {
                fila.add(noAtual.direito);
            }
        }
    }
}
