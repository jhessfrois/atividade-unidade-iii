public class ativi_04 {
  // Algoritmo de busca binária
  public static int buscaBinaria(int[] array, int elemento) {
    int inicio = 0;
    int fim = array.length - 1;

    while (inicio <= fim) {
      int meio = inicio + (fim - inicio) / 2;
      if (array[meio] == elemento) {
        return meio; // Elemento encontrado
      } else if (array[meio] < elemento) {
        inicio = meio + 1;
      } else {
        fim = meio - 1;
      }
    }
    return -1; // Elemento não encontrado
  }

  public static void main(String[] args) {
    // Busca Binária
    int[] numeros = {1, 3, 5, 7, 9, 11, 13, 15};
    int elemento = 7;
    int posicao = buscaBinaria(numeros, elemento);

    if (posicao != -1) {
      System.out.println("Elemento encontrado na posição: " + posicao);
    } else {
      System.out.println("Elemento não encontrado.");
    }
  }
}