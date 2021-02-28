package com.zer0.codeDesign;

import com.zer0.codeDesign.actions.GraphCalculator;
import com.zer0.codeDesign.graph.entity.Graph;
import com.zer0.codeDesign.graph.entity.Route;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {

    public static void main(String[] args){
        Graph graph = new Graph(new ArrayList<>(){{
            add(new Route("A", "B"));
            add(new Route("A", "C"));
            add(new Route("C", "B"));
            add(new Route("B", "E"));
            add(new Route("C", "D"));
            add(new Route("D", "F"));
            add(new Route("E", "F"));
            add(new Route("F", "G"));
        }});

        GraphCalculator cal = GraphCalculator.getInstance();
        cal.setGraph(graph);

//        List<String> nodeList = new ArrayList<>();
//        cal.BFS(new ArrayList<>(){{add("A");}}, nodeList);

        List<String> nodeList = cal.BFS("A");

        nodeList.forEach(node -> System.out.println(node));
    }
}
