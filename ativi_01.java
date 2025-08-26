// Classe que representa um livro
class Livro {
  String titulo;
  String autor;
  int ano;

  // Construtor que inicializa os atributos do livro
  public Livro(String titulo, String autor, int ano) {
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
  }

  // Sobrescreve o método toString() para exibir as informações do livro de forma legível
  @Override
  public String toString() {
    return "Livro{" +
        "titulo='" + titulo + '\'' +
        ", autor='" + autor + '\'' +
        ", ano=" + ano +
        '}';
  }
}

// Classe que representa um nó da árvore binária
class No {
  Livro livro;
  No esquerda;
  No direita;

  // Construtor que cria um nó com o livro informado
  public No(Livro livro) {
    this.livro = livro;
    this.esquerda = null;
    this.direita = null;
  }
}

// Classe que representa a Árvore Binária de Livros
class ArvoreBinariaLivros {
  private No raiz;

  // Método público para inserir um livro na árvore
  public void inserir(Livro livro) {
    raiz = inserirRec(raiz, livro);
  }

  // Método recursivo para inserir um nó na posição correta
  private No inserirRec(No atual, Livro livro) {
    if (atual == null) {
      return new No(livro);
    }
    if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) < 0) {
      atual.esquerda = inserirRec(atual.esquerda, livro);
    } else {
      atual.direita = inserirRec(atual.direita, livro);
    }
    return atual;
  }

  // Listagem em Pré-Ordem (raiz -> esquerda -> direita)
  public void listarPreOrdem() {
    preOrdem(raiz);
  }

  private void preOrdem(No no) {
    if (no != null) {
      System.out.println(no.livro);
      preOrdem(no.esquerda);
      preOrdem(no.direita);
    }
  }

  // Listagem em Ordem (esquerda -> raiz -> direita)
  public void listarEmOrdem() {
    emOrdem(raiz);
  }

  private void emOrdem(No no) {
    if (no != null) {
      emOrdem(no.esquerda);
      System.out.println(no.livro);
      emOrdem(no.direita);
    }
  }

  // Listagem em Pós-Ordem (esquerda -> direita -> raiz)
  public void listarPosOrdem() {
    posOrdem(raiz);
  }

  private void posOrdem(No no) {
    if (no != null) {
      posOrdem(no.esquerda);
      posOrdem(no.direita);
      System.out.println(no.livro);
    }
  }
}


// Exemplo de uso
public class ativi_01 {
  public static void main(String[] args) {
    // Implementação da Árvore Binária

    ArvoreBinariaLivros arvore = new ArvoreBinariaLivros();
    arvore.inserir(new Livro("Java: Como Programar", "Deitel", 2016));
    arvore.inserir(new Livro("Estruturas de Dados", "Lafore", 2002));
    arvore.inserir(new Livro("Algoritmos", "Cormen", 2009));

    System.out.println("Pré-Ordem:");
    arvore.listarPreOrdem();

    System.out.println("\nEm Ordem:");
    arvore.listarEmOrdem();

    System.out.println("\nPós-Ordem:");
    arvore.listarPosOrdem();
  }
}