package com.zer0.codeDesign.graph.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数据结构 -- 图
 * 包含节点和路径
 */
public class Graph {

    /**
     * 构造方法
     * @param routes 路径
     */
    public Graph(List<Route> routes){
        if(this.rotes == null){
            this.rotes = new ArrayList<>();
        }
        if(this.nodes == null){
            this.nodes = new HashSet<>();
        }
        for(Route route : routes){
            this.nodes.add(route.getFrom());
            this.nodes.add(route.getTo());
            this.rotes.add(route);
        }
    }

    /**
     * 节点集合
     */
    private Set<String> nodes;
    public Set<String> getNodes() {
        return nodes;
    }

    /**
     * 路径集合
     */
    private List<Route> rotes;
    public List<Route> getRotes() {
        return rotes;
    }
}
