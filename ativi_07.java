import java.util.*;

public class ativi_07 {
  private Map<Integer, List<Integer>> grafo = new HashMap<>();

  // Adiciona uma aresta ao grafo
  public void adicionarAresta(int origem, int destino) {
    grafo.computeIfAbsent(origem, _ -> new ArrayList<>()).add(destino);
    grafo.computeIfAbsent(destino, _ -> new ArrayList<>()); // garante que o destino exista
  }

  // Método de Busca em Profundidade (DFS)
  public void dfs(int verticeInicial) {
    Set<Integer> visitados = new HashSet<>();
    System.out.println("Vértices visitados na DFS a partir de " + verticeInicial + ":");
    dfsRecursivo(verticeInicial, visitados);
  }

  private void dfsRecursivo(int vertice, Set<Integer> visitados) {
    if (!visitados.contains(vertice)) {
      System.out.println(vertice);
      visitados.add(vertice);
      for (int vizinho : grafo.getOrDefault(vertice, Collections.emptyList())) {
        dfsRecursivo(vizinho, visitados);
      }
    }
  }

  // Exemplo de uso
  public static void main(String[] args) {
    // DFS em Grafos
    ativi_07 app = new ativi_07();

    // Criando conexões (arestas)
    app.adicionarAresta(1, 2);
    app.adicionarAresta(1, 3);
    app.adicionarAresta(2, 4);
    app.adicionarAresta(3, 5);
    app.adicionarAresta(5, 6);

    // Executando DFS a partir do vértice 1
    app.dfs(1);
  }
}
