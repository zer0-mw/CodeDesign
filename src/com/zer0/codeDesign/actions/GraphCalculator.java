package com.zer0.codeDesign.actions;

import com.zer0.codeDesign.graph.entity.Graph;
import com.zer0.codeDesign.graph.entity.Route;

import java.util.*;

public class GraphCalculator {

    private static GraphCalculator instance;

    public static GraphCalculator getInstance(){
        if(instance == null){
            instance = new GraphCalculator();
        }
        return instance;
    }

    private static Graph graph;
    public void setGraph(Graph g){
        graph = g;
    }

    public boolean hasPath(Graph graph, String from, String to){
        Map<String, Boolean> visitedMap = new HashMap<>();
        visit(from, visitedMap);
        return visitedMap.getOrDefault(to, false);
    }
    
    private void visit(String node, Map<String, Boolean> visited){
        for(Route route : graph.getRotes()){
            if(!route.getFrom().equals(node)) continue;
            if(visited.getOrDefault(route.getTo(), false)) continue;
            visited.put(route.getTo(), true);
            visit(route.getTo(), visited);
        }
    }

    public void DFS(String node, List<String> visitedNodes){
        visitedNodes.add(node);
        for(Route route : graph.getRotes()){
            if(!route.getFrom().equals(node)) continue;
            if(visitedNodes.contains(route.getTo())) continue;
            DFS(route.getTo(), visitedNodes);
        }
    }

    /**
     * 第一次之后得到搜索，传入节点列表
     * @param nodes 节点列表
     * @param visitedNodes
     */
    public void BFS(List<String> nodes, List<String> visitedNodes){
        List<String> nextNodes = new ArrayList<>();
        for(String node : nodes){
            if(!visitedNodes.contains(node)) visitedNodes.add(node);
            for(Route route : graph.getRotes()){
                if(!route.getFrom().equals(node)) continue;
                if(visitedNodes.contains(route.getTo())) continue;
                nextNodes.add(route.getTo());
            }
        }
        if(nextNodes.isEmpty()) return;
        BFS(nextNodes, visitedNodes);
    }

    /**
     * 深度优先遍历（栈）
     *
     * @param node 起始节点
     * @return 遍历结果的节点顺序列表
     */
    public List<String> DFS(String node){
        List<String> resultList = new ArrayList<>();

        // 构建栈，加入其实节点
        Stack<String> stack = new Stack<>();
        stack.add(node);

        while(!stack.isEmpty()){
            // 将栈顶节点出栈并加入搜索结果列表
            String targetNode = stack.pop();
            resultList.add(targetNode);

            // 找到当前节点所能到达的节点并入栈
            Stack<String> tmpStack = new Stack<>();
            for(Route route : graph.getRotes()){
                if(!route.getFrom().equals(targetNode)) continue;
                // 已加入栈或写入结果列表的节点表示已搜索过，跳过
                if(resultList.contains(route.getTo())
                        || stack.contains(route.getTo())) continue;
                tmpStack.push(route.getTo());
            }

            while(!tmpStack.isEmpty()){
                stack.push(tmpStack.pop());
            }
        }

        return resultList;
    }

    /**
     * 广度优先遍历（队列）
     *
     * @param node 起始节点
     * @return 遍历结果的节点顺序列表
     */
    public List<String> BFS(String node) {
        List<String> resultList = new ArrayList<>();

        // 构建队列，加入起始节点
        Queue<String> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            // 将栈顶节点出队并加入搜索结果列表
            String targetNode = queue.poll();
            resultList.add(targetNode);

            // 找到当前节点所能到达的节点并入队列
            for(Route route : graph.getRotes()){
                if(!route.getFrom().equals(targetNode)) continue;
                // 已加入队列或写入结果列表的节点表示已搜索过，跳过
                if(resultList.contains(route.getTo())
                        || queue.contains(route.getTo())) continue;
                queue.offer(route.getTo());
            }
        }
        return resultList;
    }


}
