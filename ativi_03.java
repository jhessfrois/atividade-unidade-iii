public class ativi_03 {
  // Método para busca linear em um array de inteiros
  public static int buscaLinear(int[] array, int numeroBuscado) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == numeroBuscado) {
        return i; // Retorna a posição do número buscado
      }
    }
    return -1; // Retorna -1 se o número não estiver presente
  }

  // Exemplo de uso
  public static void main(String[] args) {
    // Busca Linear:
    int[] contatos = {1234, 5678, 9101, 1121, 3141};
    int numeroBuscado = 9101;
    int posicao = buscaLinear(contatos, numeroBuscado);

    if (posicao != -1) {
      System.out.println("Número encontrado na posição: " + posicao);
    } else {
      System.out.println("Número não encontrado.");
    }
  }
}