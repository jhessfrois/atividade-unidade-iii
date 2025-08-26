class Node {
  int valor;
  Node esquerda, direita;

  Node(int valor) {
    this.valor = valor;
    esquerda = direita = null;
  }
}

public class ativi_08 {
  // Retorna o menor valor em uma árvore binária de busca
  public static int encontrarMenorValor(Node raiz) {
    if (raiz == null) {
      throw new IllegalArgumentException("Árvore vazia");
    }
    Node atual = raiz;
    while (atual.esquerda != null) {
      atual = atual.esquerda;
    }
    return atual.valor;
  }

  // Exemplo de uso
  public static void main(String[] args) {
    // Mínimo de uma BST
    Node raiz = new Node(50);
    raiz.esquerda = new Node(30);
    raiz.direita = new Node(70);
    raiz.esquerda.esquerda = new Node(20);
    raiz.esquerda.direita = new Node(40);
    raiz.direita.esquerda = new Node(60);
    raiz.direita.direita = new Node(80);

    int menor = encontrarMenorValor(raiz);
    System.out.println("O menor valor (produto mais barato) é: " + menor);
  }
}