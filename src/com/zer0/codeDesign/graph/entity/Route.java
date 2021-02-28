package com.zer0.codeDesign.graph.entity;

/**
 * 路径(有向图)
 */
public class Route {
    /**
     * 构造方法
     * @param from 开始节点
     * @param to 目标节点
     */
    public Route(String from, String to){
        this.from = from;
        this.to = to;
    }

    /**
     * 开始节点
     */
    private String from;
    public String getFrom() {
        return from;
    }

    /**
     * 目标节点
     */
    private String to;
    public String getTo() {
        return to;
    }
}
