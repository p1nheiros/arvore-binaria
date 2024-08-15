public class No {
    int valor;  // Valor do nó
    No esquerdo, direito;   // Referência para o filho esquerdo e direito

    // Construtor para criar um novo nó
    public No(int item) {
        valor = item;
        esquerdo = direito = null;
    }
}