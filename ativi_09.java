import java.util.*;

public class ativi_09 {
  // Classe que representa uma aresta (destino e peso)
  static class Aresta {
    int destino;
    int peso;

    Aresta(int destino, int peso) {
      this.destino = destino;
      this.peso = peso;
    }
  }

  // Algoritmo de Dijkstra para menor caminho em grafo ponderado
  public static int[] dijkstra(List<List<Aresta>> grafo, int inicio) {
    int n = grafo.size();
    int[] distancias = new int[n];
    Arrays.fill(distancias, Integer.MAX_VALUE);
    distancias[inicio] = 0;

    PriorityQueue<int[]> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    filaPrioridade.offer(new int[]{inicio, 0});

    while (!filaPrioridade.isEmpty()) {
      int[] atual = filaPrioridade.poll();
      int u = atual[0];
      int d = atual[1];

      if (d > distancias[u]) continue;

      for (Aresta aresta : grafo.get(u)) {
        int v = aresta.destino;
        int w = aresta.peso;
        if (distancias[u] + w < distancias[v]) {
          distancias[v] = distancias[u] + w;
          filaPrioridade.offer(new int[]{v, distancias[v]});
        }
      }
    }
    return distancias;
  }

  // Retorna o caminho mais curto de um vértice até outro
  public static List<Integer> menorCaminho(List<List<Aresta>> grafo, int inicio, int fim) {
    int n = grafo.size();
    int[] distancias = new int[n];
    int[] anterior = new int[n];
    Arrays.fill(distancias, Integer.MAX_VALUE);
    Arrays.fill(anterior, -1);
    distancias[inicio] = 0;

    PriorityQueue<int[]> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    filaPrioridade.offer(new int[]{inicio, 0});

    while (!filaPrioridade.isEmpty()) {
      int[] atual = filaPrioridade.poll();
      int u = atual[0];
      int d = atual[1];

      if (d > distancias[u]) continue;

      for (Aresta aresta : grafo.get(u)) {
        int v = aresta.destino;
        int w = aresta.peso;
        if (distancias[u] + w < distancias[v]) {
          distancias[v] = distancias[u] + w;
          anterior[v] = u;
          filaPrioridade.offer(new int[]{v, distancias[v]});
        }
      }
    }

    // Reconstruindo o caminho
    List<Integer> caminho = new ArrayList<>();
    for (int no = fim; no != -1; no = anterior[no]) {
      caminho.add(no);
    }
    Collections.reverse(caminho);
    if (caminho.get(0) != inicio) return Collections.emptyList(); // Não existe caminho
    return caminho;
  }

  public static void main(String[] args) {
    // Exemplo de grafo: 0--(2)-->1--(4)-->2, 0--(1)-->2
    int n = 3;
    List<List<Aresta>> grafo = new ArrayList<>();
    for (int i = 0; i < n; i++) grafo.add(new ArrayList<>());
    
    grafo.get(0).add(new Aresta(1, 2)); // 0 -> 1 (peso 2)
    grafo.get(0).add(new Aresta(2, 1)); // 0 -> 2 (peso 1)
    grafo.get(1).add(new Aresta(2, 4)); // 1 -> 2 (peso 4)

    int inicio = 0, fim = 2;
    List<Integer> caminho = menorCaminho(grafo, inicio, fim);
    
    System.out.println("Caminho mais curto de " + inicio + " até " + fim + ": " + caminho);
  }
}
