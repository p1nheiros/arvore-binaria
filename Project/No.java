public class No {
    int valor;      // Valor do nó
    No esquerdo;    // Referência para o filho esquerdo
    No direito;     // Referência para o filho direito

    // Construtor para criar um novo nó
    public No(int valor) {
        this.valor = valor;
        esquerdo = null;
        direito = null;
    }
}
