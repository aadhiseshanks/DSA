import java.util.*;

class Graph {
    private Map<String, List<String>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addVertex(String vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2, boolean isDirected) {
        addVertex(vertex1);
        addVertex(vertex2);
        graph.get(vertex1).add(vertex2);

        if (!isDirected) {
            graph.get(vertex2).add(vertex1);
        }
    }

    public void display() {
        for (String vertex : graph.keySet()) {
            System.out.println(vertex + ": " + graph.get(vertex));
        }
    }

    public List<String> getVertices() {
        return new ArrayList<>(graph.keySet());
    }

    public void getEdges() {
        for (String vertex : graph.keySet()) {
            for (String edge : graph.get(vertex)) {
                System.out.println(vertex + " -> " + edge);
            }
        }
    }

    public void removeVertex(String vertex) {
        if (graph.containsKey(vertex)) {
            graph.remove(vertex);
            for (List<String> edges : graph.values()) {
                edges.remove(vertex);
            }
        }
    }

    public boolean isEdge(String vertex1, String vertex2) {
        return (graph.containsKey(vertex1) && graph.get(vertex1).contains(vertex2)) ||
               (graph.containsKey(vertex2) && graph.get(vertex2).contains(vertex1));
    }

    public void removeEdge(String vertex1, String vertex2, boolean isDirected) {
        if (isEdge(vertex1, vertex2)) {
            graph.get(vertex1).remove(vertex2);
        }
        if (!isDirected && isEdge(vertex2, vertex1)) {
            graph.get(vertex2).remove(vertex1);
        }
    }

    // DFS
    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(String current, Set<String> visited) {
        if (!visited.contains(current)) {
            visited.add(current);
            System.out.print(current + " ");
        }

        for (String neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // BFS
    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Shortest Path (BFS-based)
    public void shortestPath(String start, String end) {
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();

        List<String> initialPath = new ArrayList<>();
        initialPath.add(start);

        queue.add(initialPath);
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String current = path.get(path.size() - 1);

            if (current.equals(end)) {
                System.out.println(String.join(" -> ", path));
                return;
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("A", "B", false);
        graph.addEdge("B", "E", false);
        graph.addEdge("B", "D", false);
        graph.addEdge("C", "D", false);
        graph.addEdge("E", "C", false);

        graph.display();

        System.out.println("DFS starting from vertex A:");
        graph.dfs("A");

        System.out.println("\nBFS starting from vertex A:");
        graph.bfs("A");

        System.out.println("\nThe Shortest Path from A to D is:");
        graph.shortestPath("A", "D");
    }
}
