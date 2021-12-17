package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath1 = new DijkstraShortestPath(graph);
        List<String> shortestPath1 = dijkstraShortestPath1.getPath("v3", "v1").getVertexList();
        System.out.println(shortestPath1);

        DijkstraShortestPath dijkstraShortestPath2 = new DijkstraShortestPath(graph);
        List<String> shortestPath2 = dijkstraShortestPath2.getPath("v1", "v3").getVertexList();
        System.out.println(shortestPath2);

        assertThat(shortestPath1.size()).isEqualTo(3);
        assertThat(shortestPath2.size()).isEqualTo(3);
    }
}
