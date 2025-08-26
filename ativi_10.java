import java.util.*;

public class ativi_10 {
  // Classe para representar o grafo usando lista de adjacência
  static class Grafo {
    private int V; // Número de vértices
    private List<List<Integer>> adj; // Lista de adjacência

    public Grafo(int V) {
      this.V = V;
      adj = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
      }
    }

    // Adiciona uma aresta do vértice u para o vértice v
    public void adicionarAresta(int u, int v) {
      adj.get(u).add(v);
    }

    // Ordenação topológica usando DFS
    public List<Integer> ordenacaoTopologica() {
      boolean[] visitado = new boolean[V];
      Stack<Integer> pilha = new Stack<>();

      for (int i = 0; i < V; i++) {
        if (!visitado[i]) {
          dfs(i, visitado, pilha);
        }
      }

      List<Integer> resultado = new ArrayList<>();
      while (!pilha.isEmpty()) {
        resultado.add(pilha.pop());
      }
      return resultado;
    }

    private void dfs(int v, boolean[] visitado, Stack<Integer> pilha) {
      visitado[v] = true;
      for (int vizinho : adj.get(v)) {
        if (!visitado[vizinho]) {
          dfs(vizinho, visitado, pilha);
        }
      }
      pilha.push(v);
    }
  }

  public static void main(String[] args) {
    // Ordenação de Grafos
    Grafo grafo = new Grafo(6);
    grafo.adicionarAresta(5, 2);
    grafo.adicionarAresta(5, 0);
    grafo.adicionarAresta(4, 0);
    grafo.adicionarAresta(4, 1);
    grafo.adicionarAresta(2, 3);
    grafo.adicionarAresta(3, 1);

    List<Integer> ordenacao = grafo.ordenacaoTopologica();
    System.out.println("Ordenação topológica dos vértices:");
    for (int v : ordenacao) {
      System.out.print(v + " ");
    }
  }
}