import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ativi_05 {
    private Map<Integer, List<Integer>> adjacencias;
    
    public ativi_05() {
        adjacencias = new HashMap<>();
    }

    public void adicionarVertice(int vertice) {
        adjacencias.put(vertice, new ArrayList<>());
    }

    public void adicionarAresta(int origem, int destino) {
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem); // Para grafos não direcionados
    }

    public List<Integer> getAdjacentes(int vertice) {
        return adjacencias.get(vertice);
    }

    public static void main(String[] args) {
        // Representação de Grafos
        ativi_05 grafo = new ativi_05();
        
        // Adicionando vértices
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        
        // Adicionando arestas
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        
        // Exibindo adjacências
        System.out.println("Vértices adjacentes ao 1: " + grafo.getAdjacentes(1));
        System.out.println("Vértices adjacentes ao 2: " + grafo.getAdjacentes(2));
    }
}